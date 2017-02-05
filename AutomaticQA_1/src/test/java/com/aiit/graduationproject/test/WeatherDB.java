/**
 * Copyright 2017 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aiit.graduationproject.entity.Area;
import com.aiit.graduationproject.entity.Weather;
import com.aiit.graduationproject.service.AreaService;
import com.aiit.graduationproject.service.WeatherService;
import com.aiit.graduationproject.utils.DateUtil;
import com.aiit.graduationproject.utils.MessagesUtils;
import com.aiit.graduationproject.utils.StringUtils;
import com.aiit.graduationproject.utils.WeatherUtil;

/**
 * <p>
 * <code>WeatherDB</code>
 * </p>
 *
 * @author sjwang6
 * @time 2017年1月3日 下午3:50:29
 * @since 1.0
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/applicationContext-mvc.xml" })
public class WeatherDB {
	@Autowired
	private WeatherService weatherService;
	@Autowired
	private AreaService areaService;
	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(WeatherDB.class);

	@SuppressWarnings("static-access")
	@Test
	public void test() throws InterruptedException {
		Map<Integer, List<Area>> map = new HashMap<Integer, List<Area>>();
		int full_weather_num = StringUtils.StringCastInteger(MessagesUtils.getProperty(MessagesUtils.full_weather_num));
		if (full_weather_num == 7) {
			// 清空表
			weatherService.truncateTable("tb_weather");
		} else {
			// 根据num 删除 靠前的 num 天
			logger.info("删除:::" + full_weather_num + ":::前的天气数据！");
			deleteWeather(full_weather_num);
			logger.info("删除数据完成！");
		}
		logger.info("开始新增各地区7天的天气信息:::开始时间:::" + DateUtil.getLocationDate());
		// 先查找
		List<Area> areaList = areaService.findAllArea();
		for (int i = 0, size = areaList.size(); i <= size / 500; i++) {
			if ((i + 1) * 500 < size) {
				areaList = areaService.findAreaByIndexAndLastPos(i * 500 + 1, (i + 1) * 500);
			} else {
				areaList = areaService.findAreaByIndexAndLastPos(i * 500 + 1, size);
			}
			map.put(i, areaList);
		}
		for (int i = 0; i < 6; i++) {
			Runnable weatherThread = new WeatherThread(map.get(i), weatherService, full_weather_num);
			Thread thread = new Thread(weatherThread);
			thread.start();
			while (thread.isAlive()) {
				thread.sleep(10);
			}
		}
	}

	/**
	 * 根据日期删除天气库
	 * <p>
	 * <code>deleteWeather</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param full_weather_num
	 *            要删除的天气数，即删除从今天往前的full_weather_num天的天气天数
	 */
	public void deleteWeather(int full_weather_num) {
		// today->previous的full_weather_num
		String[] dates = DateUtil.pre_enter(new Date(), full_weather_num);
		List<Weather> weList = weatherService.findWeatherDateAndFkAreaId();
		for (int i = 0; i < dates.length; i++) { // 小循环放在大循环外面的效率比较高
			for (int j = 0; j < weList.size(); j++) {
				if (weList.get(j).getWeatherDate().contains(dates[i])) {
					// 删除full_weather_num天的天气信息
					// System.out.println(weList.get(j).getWeatherDate() +
					// ":::"+ dates[i]);
					weatherService.deleteWeatherByWeatherId(weList.get(j).getWeatherId());
				}
			}
		}
	}
}

class WeatherThread implements Runnable {
	List<Weather> weatherList = null;
	private List<Area> areaList = null;
	private WeatherService weatherService;
	private int num;
	private static final Logger logger = LoggerFactory.getLogger(WeatherDB.class);

	public WeatherThread(List<Area> areaList, WeatherService weatherService, int num) {
		this.weatherService = weatherService;
		this.areaList = areaList;
		this.num = num;
	}

	/**
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {
			synchronized (areaList) {
				for (Area area : areaList) {
					// 此处判断messager.properties属性文件中的数据获取是几天的还是全量的，如果是全量的这是7，
					// 若是1或2，则表示需要删除今天往前的1~2天数据，存入明后天的数据
					weatherList = WeatherUtil.getWeatherInfoByListAndNum(area, num); // weatherList只是7个
					weatherService.batchAddWeatherInfo(weatherList);
				}
			}
		} catch (IOException e) {
			logger.error("Jsoup解析数据超时！", e);
			e.printStackTrace();
		}
		logger.info("初始化各地区7天的天气信息完成！:::完成时间:::" + DateUtil.getLocationDate());
	}
}

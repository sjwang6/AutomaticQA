/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aiit.graduationproject.entity.Area;
import com.aiit.graduationproject.entity.Weather;
import com.aiit.graduationproject.service.AreaService;
import com.aiit.graduationproject.service.WeatherService;
import com.aiit.graduationproject.utils.DateUtil;
import com.aiit.graduationproject.utils.PageUtil;
import com.aiit.graduationproject.utils.StringUtils;
import com.aiit.graduationproject.utils.WeatherUtil;

/**
 * 获取天气信息
 * <p>
 * <code>WeatherController</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月28日 下午6:02:10
 * @since 1.0
 * @version 1.0
 */
@Controller
public class WeatherController {

	/**
	 * 注入
	 */
	@Autowired
	private WeatherService weatherService;

	@Autowired
	private AreaService areaService;
	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

	/**
	 * 查看所有天气信息
	 * <p>
	 * <code>ShowAllWeatherInfo</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param map
	 * @param request
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/showAllWeatherInfo")
	public String ShowAllWeatherInfo(HttpServletRequest request, Map map) {
		List<Weather> alits = weatherService.findWeatherDateAndFkAreaId();
		int Num = StringUtils.StringCastInteger(request.getParameter("currentPage"));
		int[] pageview = PageUtil.pageViews(request.getParameter("currentPage"), Num);
		List<Weather> allList = weatherService.findWeatherAllByPage(pageview[0], pageview[1]);
		map.put("size", alits.size());
		map.put("currentPage", pageview[2]);
		map.put("totalPage", (alits.size() / 10) % 2 == 0 ? (alits.size() / 10) : (alits.size() / 10) + 1);
		map.put("All_Weather_List", allList);
		return "backstage/weather";
	}

	/**
	 * 检查天气是否数据完全(适合补全最后面缺失的，添加后全在后面)
	 * <p>
	 * <code>checkWeatherInfo</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @return
	 */
	@RequestMapping(value = "/checkweather")
	public String checkWeatherInfo() {
		List<Area> aList = areaService.findAllArea();
		logger.info("：：：正在检查缺少的数据：：：");
		for (Area area : aList) {
			List<Weather> wist = weatherService.findWeatherByAreaId(area.getAreaId());
			if (wist.size() != 7) {
				try {
					List<Weather> list = WeatherUtil.getWeatherInfo(area);
					weatherService.batchAddWeatherInfo(list);
				} catch (IOException e) {
					logger.error("流的读取错误", e);
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * 存入天气信息
	 * <p>
	 * <code>insertWeatherInfo</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param map
	 * @return
	 * @throws InterruptedException
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/changeWeatherAll")
	public String insertWeatherInfo() throws InterruptedException {
		Map<Integer, List<Area>> map = new HashMap<Integer, List<Area>>();
		// 清空表
		weatherService.truncateTable("tb_weather");
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
			Runnable weatherThread = new WeatherThread(map.get(i), weatherService);
			Thread thread = new Thread(weatherThread);
			thread.start();
			while (thread.isAlive()) {
				thread.sleep(10);
			}
		}
		return null;
	}
}

class WeatherThread implements Runnable {
	List<Weather> weatherList = null;
	private List<Area> areaList = null;
	private WeatherService weatherService;
	private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

	public WeatherThread(List<Area> areaList, WeatherService weatherService) {
		this.weatherService = weatherService;
		this.areaList = areaList;
	}

	/**
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {
			synchronized (areaList) {
				for (Area area : areaList) {
					weatherList = WeatherUtil.getWeatherInfo(area); // weatherList只是7个(7天)
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

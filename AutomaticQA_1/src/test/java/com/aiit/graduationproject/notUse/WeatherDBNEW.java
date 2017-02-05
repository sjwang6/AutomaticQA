package com.aiit.graduationproject.notUse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aiit.graduationproject.entity.Area;
import com.aiit.graduationproject.entity.Weather;
import com.aiit.graduationproject.service.AreaService;
import com.aiit.graduationproject.service.WeatherService;
import com.aiit.graduationproject.utils.WeatherUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml","classpath:spring/applicationContext-mvc.xml"})
public class WeatherDBNEW {
	
	@Autowired
	private WeatherService weatherService;
	
	@Autowired
	private AreaService areaService;
	
	@SuppressWarnings("unused")
	private  static final org.slf4j.Logger logger = LoggerFactory.getLogger(WeatherDBNEW.class);
	List<Weather> weaList = null;
	static Map<Integer,List<Area>> map = new HashMap<Integer, List<Area>>();
	@Test
	public void test(){
//		weatherService.truncateTable("tb_weather");
		Map<Integer, List<Area>> amap = getData();
		synchronized (amap) {
			for (int i =0;i < 6;i++) {
				for (final Area area : amap.get(i)) {
					new Thread(){
						public void run() {
							try {
								weaList = WeatherUtil.getWeatherInfo(area);
								weatherService.batchAddWeatherInfo(weaList);
							} catch (IOException e) {
								e.printStackTrace();
							}
						};
					}.start();
				}
			}
		}
	}

	public Map<Integer, List<Area>> getData(){
		List<Area> areaList = areaService.findAllArea();
		int size = areaList.size();
		List<Area> list = null;
		for (int i = 0; i < size; i+=500) {
			if(i<size){
				list = areaService.findAreaByIndexAndLastPos(i+1, i+500);
			}else{
				list = areaService.findAreaByIndexAndLastPos(i+1, size);
			}
			map.put(i/500, list);
		}
		return map;
	}
	
}

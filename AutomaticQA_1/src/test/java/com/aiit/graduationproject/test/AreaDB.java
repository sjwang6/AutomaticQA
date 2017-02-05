/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.test;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aiit.graduationproject.entity.Area;
import com.aiit.graduationproject.entity.Province;
import com.aiit.graduationproject.service.AreaService;
import com.aiit.graduationproject.utils.DateUtil;
import com.aiit.graduationproject.utils.MessagesUtils;
import com.aiit.graduationproject.utils.WeatherUtil;

/**
 * DB地区操作
 * <p>
 * <code>AreaDB</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月29日 下午2:08:35
 * @since 1.0
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml","classpath:spring/applicationContext-mvc.xml"})
public class AreaDB {

	@Autowired
	private AreaService areaService;
	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(AreaDB.class);
	
	@Test
	public void test() {
		try {
			List<Province> provinceList = WeatherUtil.getProvinceInfo(MessagesUtils.getProperty(MessagesUtils.weather_baseUrl)+MessagesUtils.getProperty(MessagesUtils.weather_baseUrl_next_node));
			for (int i = 0; i < provinceList.size(); i++) {
				System.out.println(provinceList.get(i).getProvinceName()+":::"+provinceList.get(i).getProvinceUrl());
			}
			List<Area> areaList = WeatherUtil.getAreaInfo(provinceList);
			System.out.println(areaList.size());
			logger.info("areaService:::"+areaService);
//			areaService.batchAddAreaInfo(areaList,"tb_area");
			logger.info("开始新增各地区的信息:::地区总数:::" + areaList.size());
			logger.info("开始新增各地区的信息:::结束时间:::" + DateUtil.getLocationDate());
			logger.info("初始化地区信息完成！总数量：" + areaList.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

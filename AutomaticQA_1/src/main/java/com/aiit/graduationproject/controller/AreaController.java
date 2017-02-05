/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aiit.graduationproject.entity.Area;
import com.aiit.graduationproject.entity.Province;
import com.aiit.graduationproject.service.AreaService;
import com.aiit.graduationproject.utils.DateUtil;
import com.aiit.graduationproject.utils.MessagesUtils;
import com.aiit.graduationproject.utils.WeatherUtil;

/**
 * 获取地区信息
 * <p>
 * <code>AreaController</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月29日 上午11:00:43
 * @since 1.0
 * @version 1.0
 */
@Controller
public class AreaController {

	/**
	 * 注入
	 */
	@Autowired
	private AreaService areaService;

	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(AreaController.class);

	/**
	 * 存入初始化地区信息（名称+地址）
	 * <p>
	 * <code>getWeatherInfo</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/initArea")
	public void insertAreaInfo() {
		logger.info("开始新增各地区的信息:::开始时间:::" + DateUtil.getLocationDate());
		try {
			List<Province> provinceList = WeatherUtil
					.getProvinceInfo(MessagesUtils.getProperty(MessagesUtils.weather_baseUrl)
							+ MessagesUtils.getProperty(MessagesUtils.weather_baseUrl_next_node));
			// for (int i = 0; i < provinceList.size(); i++) {
			// System.out.println(provinceList.get(i).getProvinceName()+":::"+provinceList.get(i).getProvinceUrl());
			// }
			List<Area> areaList = WeatherUtil.getAreaInfo(provinceList);
			// System.out.println(areaList.size());
			// logger.info("areaService:::"+areaService);
			areaService.batchAddAreaInfo(areaList, "tb_area");
			logger.info("开始新增各地区的信息:::地区总数:::" + areaList.size());
			logger.info("开始新增各地区的信息:::结束时间:::" + DateUtil.getLocationDate());
			logger.info("初始化地区信息完成！总数量：" + areaList.size());
			// map.put("areaInfo", "初始化地区信息完成！总数量：" + areaList.size());
		} catch (IOException e) {
			logger.error("Jsoup解析数据超时！", e);
			e.printStackTrace();
		}
	}
}

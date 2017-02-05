/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiit.graduationproject.dao.AreaDao;
import com.aiit.graduationproject.entity.Area;
import com.aiit.graduationproject.service.AreaService;

/**
 * 地区接口实现类
 * <p>
 * <code>AreaServiceImpl</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月29日 上午9:59:58
 * @since 1.0
 * @version 1.0
 */
@Service
public class AreaServiceImpl implements AreaService {

	/**
	 * 注入
	 */
	@Autowired
	private AreaDao areaDao;

	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(AreaServiceImpl.class);

	/**
	 * @see com.aiit.graduationproject.service.AreaService#batchAddAreaInfo(java.util.List,java.lang.String)
	 */
	public void batchAddAreaInfo(List<Area> areaList, String tableName) {
		// 清空表
		areaDao.truncateTable(tableName);
		logger.info("清空:::" + tableName + ":::表OK！");
		areaDao.batchAddAreaInfo(areaList);
	}
	//
	// /**
	// * @see
	// com.aiit.graduationproject.service.AreaService#truncateTable(java.lang.String)
	// */
	// public void truncateTable(String tableName) {
	// areaDao.truncateTable(tableName);
	// logger.info("清空:::"+tableName+":::表OK！");
	// }

	/**
	 * @see com.aiit.graduationproject.service.AreaService#findAllArea()
	 */
	public List<Area> findAllArea() {
		return areaDao.findAllArea();
	}

	/**
	 * @see com.aiit.graduationproject.service.AreaService#findAreaByIndexAndLastPos(int,
	 *      int)
	 */
	public List<Area> findAreaByIndexAndLastPos(int indexPos, int lastPos) {
		return areaDao.findAreaByIndexAndLastPos(indexPos, lastPos);
	}
}

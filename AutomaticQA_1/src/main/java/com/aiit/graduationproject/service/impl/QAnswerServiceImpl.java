/**
 * Copyright 2017 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiit.graduationproject.dao.QAnswerDao;
import com.aiit.graduationproject.entity.QAnswer;
import com.aiit.graduationproject.service.QAnswerService;

/**
 * 问答对接口实现
 * <p>
 * <code>QAnswerServiceImpl</code>
 * </p>
 *
 * @author sjwang6
 * @time 2017年1月16日 上午11:02:29
 * @since 1.0
 * @version 1.0
 */
@Service
public class QAnswerServiceImpl implements QAnswerService {

	/**
	 * 注入
	 */
	@Autowired
	private QAnswerDao qAnswerDao;

	/**
	 * @see com.aiit.graduationproject.service.QAnswerService#batchAddQAnswer(java.util.List)
	 */
	public void batchAddQAnswer(List<QAnswer> qAnswers) {

		qAnswerDao.batchAddQAnswer(qAnswers);
	}

}

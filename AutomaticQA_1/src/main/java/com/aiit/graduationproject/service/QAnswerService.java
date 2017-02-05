/**
 * Copyright 2017 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.service;

import java.util.List;

import com.aiit.graduationproject.entity.QAnswer;

/**
 * 问答对
 * <p>
 * <code>QAnswerService</code>
 * </p>
 *
 * @author sjwang6
 * @time 2017年1月16日 上午10:58:47
 * @since 1.0
 * @version 1.0
 */
public interface QAnswerService {

	/**
	 * 批量添加问答对到数据库
	 * <p>
	 * <code>batchAddQAnswer</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param qAnswers
	 */
	public void batchAddQAnswer(List<QAnswer> qAnswers);
}

/**
 * Copyright 2017 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aiit.graduationproject.entity.QAnswer;

/**
 * QA问答对文件 整合 mybatis 实现接口
 * <p>
 * <code>QAnswerDao</code>
 * </p>
 *
 * @author sjwang6
 * @time 2017年1月16日 上午11:00:55
 * @since 1.0
 * @version 1.0
 */
public interface QAnswerDao {

	/**
	 * 批量添加问答对到数据库
	 * <p>
	 * <code>batchAddQAnswer</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param qAnswers
	 */
	public void batchAddQAnswer(@Param("qAnswers") List<QAnswer> qAnswers);
}

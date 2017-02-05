/**
 * Copyright 2017 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aiit.graduationproject.entity.QAnswer;
import com.aiit.graduationproject.service.QAnswerService;
import com.aiit.graduationproject.utils.QADataUtil;

/**
 * <p>
 * <code>QAnswerDB</code>
 * </p>
 *
 * @author sjwang6
 * @time 2017年1月3日 下午3:50:29
 * @since 1.0
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml","classpath:spring/applicationContext-mvc.xml"})
public class QAnswerDB {
	/**
	 * 注入
	 */
	@Autowired
	private QAnswerService qAnswerService;
	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(QAnswerDB.class);
	
	@Test
	public void test() throws InterruptedException{
		List<QAnswer> qAnswers = QADataUtil.getContentFromTxt();
		if(qAnswers != null){
			qAnswerService.batchAddQAnswer(qAnswers);
			logger.info("存入数据库成功！:::总数量:::"+qAnswers.size());
		}
	}
}
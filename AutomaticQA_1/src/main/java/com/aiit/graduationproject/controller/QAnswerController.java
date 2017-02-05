/**
 * Copyright 2017 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.controller;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aiit.graduationproject.entity.QAnswer;
import com.aiit.graduationproject.service.QAnswerService;
import com.aiit.graduationproject.utils.MessagesUtils;
import com.aiit.graduationproject.utils.QADataUtil;

/**
 * 对本地文件的问答对进行处理
 * <p>
 * <code>QAnswerController</code>
 * </p>
 *
 * @author sjwang6
 * @time 2017年1月16日 下午2:23:47
 * @since 1.0
 * @version 1.0
 */
@Controller
public class QAnswerController {

	static String dir = MessagesUtils.getProperty(MessagesUtils.pos_location_jsoup_files);
	/**
	 * 注入
	 */
	private QAnswerService qAnswerService;

	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(QAnswerController.class);

	/**
	 * 将本地磁盘的问答对QA.txt解析并存入数据库
	 * <p>
	 * <code>getQAnswer</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @return
	 */
	@RequestMapping(value = "/qAnswer")
	public String getQAnswer() {
		List<QAnswer> qAnswers = QADataUtil.getContentFromTxt();
		if (qAnswers != null) {
			qAnswerService.batchAddQAnswer(qAnswers);
			logger.info("存入数据库成功！:::总数量:::" + qAnswers.size());
		}
		return null;
	}

	/**
	 * 解析本地磁盘中的html文件，获取其中的内容
	 * <p>
	 * <code>getXMLForJsoupInfo</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @return
	 */
	@RequestMapping(value = "/setXml")
	public String getXMLForJsoupInfo() {
		File file = new File(dir);
		String[] dirlist = file.list();
		for (int i = 0; i < dirlist.length; i++) {
			File file2 = new File(dir + "\\" + dirlist[i]);
			System.out.println(file2.getPath());
		}
		return null;
	}
}

/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aiit.graduationproject.entity.QAnswer;

/**
 * 获取文件的内容
 * <p>
 * <code>QADataUtil</code>
 * </p>
 *
 * @author sjwang6
 * @time 2017年1月10日 下午1:56:40
 * @since 1.0
 * @version 1.0
 */
public class QADataUtil {

	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(QADataUtil.class);

	/**
	 * 读取TXT的内容
	 * <p>
	 * <code>getContentFromTxt</code>
	 * </p>
	 * 
	 * @author sjwang6
	 */
	public static List<QAnswer> getContentFromTxt() {
		String path_qa_file = MessagesUtils.getProperty(MessagesUtils.file_qa_path);
		List<QAnswer> qAnswers = new ArrayList<QAnswer>();
		try {
			List<String> content = getTextFromTXT(path_qa_file);
			for (int i = 0, size = content.size(); i < size; i++) {
				QAnswer qAnswer = new QAnswer();
				String[] con = content.get(i).split("\u0020\u0020");
				qAnswer.setQuestion(con[0]);
				qAnswer.setAnswer(con[1]);
				qAnswers.add(i, qAnswer);
			}
		} catch (FileNotFoundException e) {
			logger.error("路径：：：" + path_qa_file + "：：：不存在", e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("文件写入出错", e);
			e.printStackTrace();
		}
		return qAnswers;
	}

	/**
	 * 获取TXT内容
	 * <p>
	 * <code>getTextFromTXT</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param string
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static List<String> getTextFromTXT(String url) throws IOException {
		List<String> sList = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader(new File(url)));
		String content = null;
		while ((content = reader.readLine()) != null) {
			sList.add(content);
		}
		return sList;
	}

}

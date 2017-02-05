/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件类操作工具
 * <p>
 * <code>FileUtil</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月29日 上午9:23:04
 * @since 1.0
 * @version 1.0
 */
public class FileUtil {

	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

	/**
	 * 写入文件
	 * <p>
	 * <code>setFile</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param content
	 *            需要写入文件的内容
	 * @param url
	 * @return
	 */
	@SuppressWarnings("resource")
	public static boolean setFile(String content, String url) {
		boolean flag = false;
		File file = new File(url);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			if (file.exists()) {
				file.mkdir();
			}
			bw.append(content);
			flag = true;
			logger.info("写入文件success！文件路径：" + content + url);
		} catch (IOException e) {
			flag = false;
			logger.error("写入文件error！", e);
		}
		return flag;
	}
}

/**
 * Copyright ${year} Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 爬去网页上的数据信息，以文件的形式存入F://jsoup/info/
 * <p>
 * <code>JsoupInfoUtil</code>
 * </p>
 *
 * @author sjwang6
 * @time 2017年1月11日 下午4:00:10
 * @since 1.0
 * @version 1.0
 */
public class JsoupInfoUtil {
	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(JsoupInfoUtil.class);

	static int startNum = StringUtils.StringCastInteger(MessagesUtils.getProperty(MessagesUtils.start_num));
	static int endNum = StringUtils.StringCastInteger(MessagesUtils.getProperty(MessagesUtils.end_num));
	static String dir = MessagesUtils.getProperty(MessagesUtils.pos_location_jsoup_files);
	static String webUrl = MessagesUtils.getProperty(MessagesUtils.web_baike_url);

	/**
	 * 下载文件的同时改名
	 * <p>
	 * <code>getWebHtmlInfoAndUpdateFileName</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param num
	 *            下载文件的单个名称
	 * @param startnum
	 *            单次下载文件的最小值
	 * @param endnum
	 *            单次下载文件的最大值 startnum~endnum 形成文件夹
	 * @param dir
	 *            本地磁盘基本路径
	 * @throws Exception
	 */
	public static void getWebHtmlInfoAndUpdateFileName(int num, int startnum, int endnum, String dir) throws Exception {
		String context = "";
		String baseUrl = dir + startnum + "~" + endnum + "\\";
		logger.info("正在链接网页：：：" + webUrl + num + ".html：：：：下载！");
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(webUrl + num + ".html").openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(20000);
			connection.setReadTimeout(20000);
			if (connection.getResponseCode() == 200) {
				logger.info("正在向:::::" + dir + num + ".html:::::存入！");
				String con = "";
				InputStream is = connection.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				while ((con = br.readLine()) != null) {
					context += con;
				}
				Document doc = Jsoup.parse(context);
				Elements elements = doc.getElementsByClass("lemmaWgt-lemmaTitle-title").select("h1");
				String titleName = elements.text();
				File file2 = checkExist(baseUrl + titleName + ".html");
				BufferedWriter bw = new BufferedWriter(new FileWriter(file2, true));
				bw.append(context);
				bw.flush();
				is.close();
				bw.close();
			}
			logger.info("success！");
		} catch (MalformedURLException e) {
			logger.error("URL连接出错", e);
			e.printStackTrace();
		} catch (ProtocolException e) {
			logger.error("返回的数据量超过临界值", e);
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			logger.error("编码出错", e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("IO流出错", e);
			e.printStackTrace();
		}

	}

	/**
	 * 判断文件及目录是否存在，若不存在则创建文件及目录
	 * 
	 * @param filepath
	 * @return
	 * @throws Exception
	 */
	public static File checkExist(String filepath) throws Exception {
		File file = new File(filepath);
		if (file.exists()) {// 判断文件目录的存在
			if (file.isDirectory()) {// 判断文件的存在性
			} else {
				file.createNewFile();// 创建文件
			}
		} else {
			File file2 = new File(file.getParent());
			file2.mkdirs();
			if (file.isDirectory()) {

			} else {
				file.createNewFile();// 创建文件
			}
		}
		return file;
	}

	/**
	 * 下载前想清空数据
	 * <p>
	 * <code>deleteAllFile</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param startNum
	 * @param endNum
	 */
	public static void deleteAllFile(int startNum, int endNum) {
		String baseUrl = MessagesUtils.getProperty(MessagesUtils.pos_location_jsoup_files);
		File file = new File(baseUrl + startNum + "~" + endNum + "\\");
		String[] files = file.list();
		if (files != null) {
			for (int j = 0; j < files.length; j++) {
				new File(file.getPath() + "\\" + files[j]).delete();
			}
			logger.info("删除完成！:文件夹：：" + startNum + "~" + endNum + "::总条数：：：" + files.length + "：：：");
		} else {
			logger.info("删除未完成:::文件夹：：" + startNum + "~" + endNum + "::是空！：：：");
			return;
		}

	}

	/**
	 * 删除特定的数据
	 * <p>
	 * <code>deleteAllFile</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param startNum
	 * @param endNum
	 */
	public static void deleteFileName(int startnum, int endnum) {
		String base = dir + "\\" + startnum + "~" + endnum + "\\";
		File file = new File(base);
		String[] fileName = file.list();
		for (int i = 0; i < fileName.length; i++) {
			File file2 = new File(base + fileName[i]);
			if (fileName[i].length() <= 5 && file2.length() / 1024 > 100) {
				file2.delete();
				logger.info("此时.html的大小超过100K,删除！");
			}
		}
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		// deleteAllFile(startNum, endNum);
		// // 下载数据
		// new Thread() {
		// public void run() {
		// for (int i = startNum; i <= endNum; i++) {
		// try {
		// getWebHtmlInfoAndUpdateFileName(i, startNum, endNum, dir);
		// deleteFileName(startNum, endNum); // 删除空白的
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// };
		// }.start();
		try {
			getXMLForJsoupInfo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		logger.info("花费时间：：：" + (endTime - startTime));
	}

	public static void getXMLForJsoupInfo() throws IOException {
		File file = new File(dir);
		String[] dirlist = file.list();
		for (int i = 0; i < dirlist.length; i++) {
			if (!dirlist[i].contains(".zip")) {
				File file2 = new File(dir + "\\" + dirlist[i] + "\\");
				String[] filelist = file2.list();
				for (int j = 0; j < filelist.length; j++) {
					// 每个文件
					File file3 = new File(dir + dirlist[i] + "\\" + filelist[j]);
					Document doc = Jsoup.parse(file3, "UTF-8");
					Elements elements = doc.getElementsByClass("lemmaWgt-lemmaTitle-title").select("h1");
					String titleName = elements.text();
					String contents = doc.getElementsByClass("para").text();
					String t = titleName + ":::" + contents + "\n";
					FileUtil.setFile(t, "D:\\dd.txt");
				}
			}
		}
	}

}

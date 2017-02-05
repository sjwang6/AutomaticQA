/**
 * Copyright ${year} Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.notUse;

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

import com.aiit.graduationproject.utils.MessagesUtils;

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
	
	static String dir = MessagesUtils.getProperty(MessagesUtils.pos_location_jsoup_files);
	static String webUrl = MessagesUtils.getProperty(MessagesUtils.web_baike_url);
	static String dir1 = "F:\\jsoup\\newInfo\\";
	
	/**
	 * 爬去网页信息，顺便存入文件中
	 * <p>
	 * <code>getWebHtmlInfo</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param num 下载文件的单个名称
	 * @param startnum 单次下载文件的最小值
	 * @param endnum 单次下载文件的最大值  startnum~endnum 形成文件夹
	 * @param dir 本地磁盘路径
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * webUrl 网页数据路径
	 */
	public static void getWebHtmlInfo(int num,int startnum, int endnum,String dir) {
		File file = new File(dir + num+".html");
		if(file.exists()){
			file.mkdir();
		}
		logger.info("正在链接网页：：："+webUrl+num+".html：：：：下载！");
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(webUrl+num+".html").openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(20000);
			connection.setReadTimeout(20000);
			if(connection.getResponseCode() == 200){
				logger.info("正在向:::::"+dir+num+".html:::::存入！");
				String con = "";
				InputStream is = connection.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));				
				BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
				while((con = br.readLine()) != null){
					bw.write(con);
					bw.newLine();
				}
				bw.flush();
				is.close();
				bw.close();
			}
			logger.info("success！");
		} catch (MalformedURLException e) {
			logger.error("URL连接出错",e);
			e.printStackTrace();
		} catch (ProtocolException e) {
			logger.error("返回的数据量超过临界值",e);
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			logger.error("编码出错",e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("IO流出错",e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 下载前想清空数据
	 * <p>
	 * <code>deleteFile</code>
	 * </p>
	 * 
	 * @author sjwang6
	 */
	public static void deleteAllFile() {
		String baseUrl = MessagesUtils.getProperty(MessagesUtils.pos_location_jsoup_files);
		File file = new File(baseUrl);
		String[] files = file.list();
		if(files.length > 0){
			String[] files2;
			for (int i = 0; i < files.length; i++) {
				File file2 = new File(baseUrl+"\\"+files[i]);
				files2 = file2.list();
				if(files2.length > 0){
					for (int j = 0; j < files2.length; j++) {
						new File(file2.getPath()+"\\"+files2[j]);
					}
				}
				logger.info("删除完成！:文件夹：："+files[i]+"::总条数：：："+files2.length+"：：：");
			}
		}else{
			logger.info(baseUrl+"：：：为空！");
			return ;
		}
	}
	
	/**
	 * 改文件的名称
	 * <p>
	 * <code>updateFileName</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @throws IOException 
	 */
	public static void updateFileName(String baseUrl) throws IOException{
		File file = new File(baseUrl);
		String[] files = file.list();
		if(files.length > 0){
			for (int i = 0; i < files.length; i++) {
				File file2 = new File(file.getPath()+"\\"+files[i]);
//				System.out.println(file.getPath()+"\\"+files[i] +":::"+ new File(file.getPath()+"\\"+files[i]).length()/1024);
				//开始解析，取出文件名称，更新名称
				Document doc = Jsoup.parse(file2,"UTF-8");
//				System.out.println(doc.title()); //直接获取title
				Elements elements = doc.getElementsByClass("lemmaWgt-lemmaTitle-title").select("h1");
				String titleName = elements.text();
//				System.out.println(elements.text());
				File newFile = new File(file.getPath()+"\\"+titleName+".html");
				//修改名称
				if(file2.renameTo(newFile)){
					logger.info("文件名修改成功！：：："+newFile.getPath());
				}else{
					logger.error("文件名修改失败！：：："+newFile.getPath());
				}
			}
		}else{
			logger.info(baseUrl+"：：：为空！");
			return;
		}
	}

	/**
	 * 删除小于5K的文件，因为该文件中没有内容
	 * <p>
	 * <code>deleteFileBySize</code>
	 * </p>
	 * 
	 * @author sjwang6
	 */
	public static void deleteFileBySize(){
		String baseUrl = MessagesUtils.getProperty(MessagesUtils.pos_location_jsoup_files);
		File file = new File(baseUrl);
		String[] files = file.list();
		if(files.length > 0){
			for (int i = 0; i < files.length; i++) {
				File file2 = new File(baseUrl+"\\"+files[i]);
//				logger.info(baseUrl+"\\"+files[i]+":::"+file2.length()/1024);
				if(file2.length()/1024 <= 5){
					file2.delete();
				}
			}
		}else{
			logger.info(baseUrl+"：：：为空！");
			return ;
		}
	}
	
	/**
	 * 下载文件的同时改名
	 * <p>
	 * <code>getWebHtmlInfoAndUpdateFileName</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param num 下载文件的单个名称
	 * @param startnum 单次下载文件的最小值
	 * @param endnum 单次下载文件的最大值  startnum~endnum 形成文件夹
	 * @param dir 本地磁盘基本路径
	 * @throws Exception 
	 */
	public static void getWebHtmlInfoAndUpdateFileName(int num,int startnum, int endnum,String dir) throws Exception {
		String context = "";
		String baseUrl = dir + startnum + "~" + endnum + "\\";
		logger.info("正在链接网页：：："+webUrl+num+".html：：：：下载！");
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(webUrl+num+".html").openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(20000);
			connection.setReadTimeout(20000);
			if(connection.getResponseCode() == 200){
				logger.info("正在向:::::"+dir+num+".html:::::存入！");
				String con = "";
				InputStream is = connection.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));				
				while((con = br.readLine()) != null){
					context += con;
				}
				Document doc = Jsoup.parse(context);
				Elements elements = doc.getElementsByClass("lemmaWgt-lemmaTitle-title").select("h1");
				String titleName = elements.text();
//				File file2 = new File(baseUrl+titleName+".html");
				File file2 = checkExist(baseUrl+titleName+".html");
				BufferedWriter bw = new BufferedWriter(new FileWriter(file2,true));
				bw.append(context);
				bw.flush();
				is.close();
				bw.close();
			}
			logger.info("success！");
		} catch (MalformedURLException e) {
			logger.error("URL连接出错",e);
			e.printStackTrace();
		} catch (ProtocolException e) {
			logger.error("返回的数据量超过临界值",e);
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			logger.error("编码出错",e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("IO流出错",e);
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 判断磁盘中的文件是否全部改名
	 * <p>
	 * <code>judgeFileNameEqualsContext</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param dirUrl 磁盘上的文件存放地址
	 * @return
	 * @throws IOException 
	 */
	public static boolean judgeFileNameEqualsContext(String dirUrl) throws IOException{
		boolean flag = false;
		//1、根据dirUrl获取文件的名称
		File file = new File(dirUrl);
		String[] files = file.list();
		for (int i = 1; i < files.length; i++) {
			String name = files[i]; //文件夹名称
			File file2 = new File(file.getPath()+"\\"+name);
			String[] files2 = file2.list();
//			System.out.println("files:"+files2.length);
			for (int j = 0; j < files2.length; j++) {
				String fileName = file2.getPath()+"\\"+files2[j]; //目标文件地址
				int filename = files2[j].indexOf(".html");
//				System.out.println(files2[j]+filename);
				Document doc = Jsoup.parse(new File(fileName),"UTF-8");
				Elements elements = doc.getElementsByClass("lemmaWgt-lemmaTitle-title").select("h1");
				String titleName = elements.text(); //所需的内容
				//先判断是否已经存在，相当于titleName = files2[j].substring(0, filename)？如果存在直接删除
				//然后再改名称
				if(!files2[j].substring(0, filename).equals(titleName)){
//						System.out.println(files2[j].substring(0, filename)+"==="+titleName);
					String newfilesName = file2.getPath()+"\\"+ titleName + ".html";
//						System.out.println(fileName+":::"+newfilesName);
					//修改名称
					if(new File(fileName).renameTo(new File(newfilesName))){
//							logger.info("文件名修改成功！：：："+newfilesName);
						flag = true;
					}else{
//							logger.error("文件名修改失败！：：："+newfilesName);
						flag = false;
					}
				}
			}
		}
		return flag;
	}
	
	/**
	* 判断文件及目录是否存在，若不存在则创建文件及目录
	* @param filepath
	* @return
	* @throws Exception
	*/
	public static File checkExist(String filepath) throws Exception{
		File file=new File(filepath);
		if (file.exists()) {//判断文件目录的存在
//			System.out.println("文件夹存在！");
			if(file.isDirectory()){//判断文件的存在性
//				System.out.println("文件存在！");
			}else{
				file.createNewFile();//创建文件
//				System.out.println("文件不存在，创建文件成功！" );
			}
		}else {
//			System.out.println("文件夹不存在！");
			File file2=new File(file.getParent());
			file2.mkdirs();
//			System.out.println("创建文件夹成功！");
			if(file.isDirectory()){
//				System.out.println("文件存在！");
			}else{
				file.createNewFile();//创建文件
//				System.out.println("文件不存在，创建文件成功！" );
			}
		}
		return file;
	}
	
	/**
	 * 判断全局文件是否已存在相同的文件
	 * <p>
	 * <code>judgeExistFileName</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param name
	 * @return
	 * @throws IOException 
	 */
	public static boolean judgeExistFileName() throws IOException{
		boolean flag = false;
		String url = MessagesUtils.getProperty(MessagesUtils.pos_location_jsoup_files);
		File file = new File(url);
		String[] files = file.list();
		for (int i = 1; i < files.length; i++) {
			File file2 = new File(url+"\\"+files[i]);
			String[] files2 = file2.list();
			for (int j = 0; j < files2.length; j++) {
				Document doc = Jsoup.parse(new File(url+"\\"+files[i]+"\\"+files2[j]),"UTF-8");
				Elements elements = doc.getElementsByClass("lemmaWgt-lemmaTitle-title").select("h1");
				String titleName = elements.text(); //所需的内容
				int num = files2[j].indexOf(".html");
				File file3 = new File(url+"\\"+files[i]+"\\"+files2[j]);
				System.out.println(titleName+"::"+files2[j].substring(0, num));
				if(!titleName.equals(files2[j].substring(0, num))){
					file3.delete();
					logger.info("success");
					flag = true;
				}
			}
		}
		return flag;
	}
	
	//判断文件中总共存入了几次。。多余的删除掉
	
	public static void main(String[] args) {
//		deleteAllFile(new File(dir));
		long startTime = System.currentTimeMillis();
//		下载数据
//		new Thread(){
//			public void run() {	
//				for (int i = 13066; i <= 20000; i++) {
//					try {
//						getWebHtmlInfoAndUpdateFileName(i,10000,20000,dir);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			};
//		}.start();
		try {
			judgeFileNameEqualsContext(dir);
//			judgeExistFileName();
		} catch (IOException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		logger.info("花费时间：：："+(endTime - startTime));
	}
	
}

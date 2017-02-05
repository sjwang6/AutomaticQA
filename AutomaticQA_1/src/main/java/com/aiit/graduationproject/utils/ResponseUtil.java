package com.aiit.graduationproject.utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {

	public static void write(HttpServletResponse response, Object o) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(o.toString());
		out.flush();
		out.close();
	}

	// public static void write1(HttpServletResponse response,Object o)throws
	// Exception{
	// response.setContentType("text/html;charset=utf-8");
	// PrintWriter out=response.getWriter();
	// out.println(o);
	// out.flush();
	// out.close();
	// }
}

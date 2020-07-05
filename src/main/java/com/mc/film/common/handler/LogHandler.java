package com.mc.film.common.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Mr.Cheng
 * @since 2020/6/15
 */
public class LogHandler {

	/**
	 * 获取异常输出到日志文件
	 *
	 * @param e
	 * @return
	 */
	public static String getExceptionMsg(Exception e) {

		StringWriter sw = null;
		PrintWriter pw = null;

		try {
			sw = new StringWriter();
			pw = new PrintWriter(sw);
			// 将出错的栈信息输出到 printWriter 中
			e.printStackTrace(pw);
			pw.flush();
		} finally {
			if (sw != null) {
				try {
					sw.close();
				} catch (IOException ioException) {
					ioException.printStackTrace(pw);
				}
			}
			if (pw != null) {
				pw.close();
			}
		}
		return sw.toString();
	}
}

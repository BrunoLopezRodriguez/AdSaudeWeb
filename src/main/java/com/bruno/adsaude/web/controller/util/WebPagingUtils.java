package com.bruno.adsaude.web.controller.util;

import javax.servlet.http.HttpServletRequest;

public class WebPagingUtils {

	public static final Integer getCurrentPage(HttpServletRequest request) {
		String pageStr = request.getParameter(ParameterNames.PAGE);
		int page = 1;
		try  {
			page = Integer.valueOf(pageStr);
		} catch (NumberFormatException pe) {					
		}
		return page;
	}
	
	public static final Integer getTotalPages(int totalResults, int pageSize) {
		return (int) Math.ceil((double) totalResults / (double) pageSize);
	}
	
	/**
	 * For test only
	 * @param args
	 */
/*	public static void main(String args[]) {
		System.out.println(getTotalPages(23, 10));
		System.out.println(getTotalPages(20, 10));
	}
*/
	
}

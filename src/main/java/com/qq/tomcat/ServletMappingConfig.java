/**
 * 
 * @Date:2019年11月5日
 * 
 */
package com.qq.tomcat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liupan
 *
 */
public class ServletMappingConfig {

	public static List<ServletMapping> servletMappingList = new ArrayList<ServletMapping>();

	static {
		servletMappingList.add(new ServletMapping("findGirl", "/girl", "com.qq.tomcat.FindGirlServlet"));
		servletMappingList.add(new ServletMapping("helloWorld", "/world", "com.qq.tomcat.HelloWorldServlet"));
	}
}

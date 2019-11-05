/**
 * 
 * @Date:2019年11月5日
 * 
 */
package com.qq.tomcat;

import java.io.IOException;

/**
 * @author liupan
 *
 */
public class FindGirlServlet extends MyServlet {

	@Override
	public void doGet(MyRequest myRequest, MyResponse myResponse) {

		try {
			myResponse.write("get girl ...");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void doPost(MyRequest myRequest, MyResponse myResponse) {
		try {
			myResponse.write("post girl ...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

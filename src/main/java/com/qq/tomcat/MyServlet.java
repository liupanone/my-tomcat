/**
 * 
 * @Date:2019年11月5日
 * 
 */
package com.qq.tomcat;

/**
 * @author liupan
 *
 */
public abstract class MyServlet {

	public abstract void doGet(MyRequest myRequest, MyResponse myResponse);

	public abstract void doPost(MyRequest myRequest, MyResponse myResponse);

	public void service(MyRequest myRequest, MyResponse myResponse) {
		if (myRequest.getMethod().equalsIgnoreCase("POST")) {
			doPost(myRequest, myResponse);
		} else if (myRequest.getMethod().equalsIgnoreCase("GET")) {
			doGet(myRequest, myResponse);
		}
	}
}

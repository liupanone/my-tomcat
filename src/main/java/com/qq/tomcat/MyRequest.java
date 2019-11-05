/**
 * 
 * @Date:2019年11月5日
 * 
 */
package com.qq.tomcat;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author liupan
 *
 */
public class MyRequest {

	private String url = "/404";
	private String method = "";

	public MyRequest(InputStream inputStream) throws IOException {
		String httpRequest = "";
		byte[] httpRequestBytes = new byte[1024];
		int length = 0;
		if ((length = inputStream.read(httpRequestBytes)) > 0) {
			httpRequest = new String(httpRequestBytes, 0, length);
			// System.out.println(httpRequest);
		}

		// System.out.println("[MyRequest] httpRequest: " + httpRequest);

		String httpHead = httpRequest.split("\n")[0];
		// System.out.println("[MyRequest] httpHead: " + httpHead);

		try {
			url = httpHead.split("\\s")[1];
			method = httpHead.split("\\s")[0];
		} catch (Exception e) {
			System.out.println("unrecognized request");
		}

		System.out.println(this);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public String toString() {
		return method + " " + url;
	}
}

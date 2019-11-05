/**
 * 
 * @Date:2019年11月5日
 * 
 */
package com.qq.tomcat;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author liupan
 *
 */
public class MyResponse {

	private OutputStream outputStream;

	public MyResponse(OutputStream outputStream){
		this.outputStream = outputStream;
	}

	public void write(String content) throws IOException {

		StringBuffer httpReponse = new StringBuffer();
		httpReponse.append("HTTP/1.1 200 OK\n").append("Content-Type: text/html\n").append("\r\n")
				.append("<html><body>").append(content).append("</body></html>");

		outputStream.write(httpReponse.toString().getBytes());
		outputStream.close();
	}
}

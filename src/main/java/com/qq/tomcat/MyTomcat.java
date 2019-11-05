/**
 * 
 * @Date:2019年11月5日
 * 
 */
package com.qq.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liupan
 *
 */
public class MyTomcat {

	private int port = 8080;

	private Map<String, String> urlServletMapping = new HashMap<String, String>();

	public MyTomcat(int port) {
		this.port = port;
	}

	public void start() {
		initServletMapping();

		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("MyTomcat is start ...");

			while (true) {
				Socket socket = serverSocket.accept();

				InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();

				MyRequest myRequest = new MyRequest(inputStream);
				MyResponse myResponse = new MyResponse(outputStream);

				dispatch(myRequest, myResponse);
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}

	}

	private void initServletMapping() {
		for (ServletMapping servletMapping : ServletMappingConfig.servletMappingList) {
			urlServletMapping.put(servletMapping.getUrl(), servletMapping.getClazz());
		}
	}

	private void dispatch(MyRequest myRequest, MyResponse myResponse) {
		String clazz = urlServletMapping.get(myRequest.getUrl());
		if (clazz == null) {
			System.out.println("unknown url: " + myRequest.getUrl());
			return;
		}

		try {
			Class<MyServlet> myServletClass = (Class<MyServlet>) Class.forName(clazz);
			MyServlet myServlet = myServletClass.newInstance();

			myServlet.service(myRequest, myResponse);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MyTomcat(8080).start();
	}
}

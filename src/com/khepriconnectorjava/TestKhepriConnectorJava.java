package com.khepriconnectorjava;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tech.khepri.KhepriAnswer;
import tech.khepri.KhepriApi;

/**
 * Servlet implementation class TestKhepriConnectorJava
 */
@WebServlet("/TestKhepriConnectorJava")
public class TestKhepriConnectorJava extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestKhepriConnectorJava() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "http://test-khepridevelba-1t8aalo9fz0t1-723475646.eu-west-1.elb.amazonaws.com";
		String passwd = "213e71dd6e9f354de2c42eee366d4263";
		response.setContentType("text/html");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	       
		response.getWriter().append("<h1>Hello World!</h1>");
		
		response.getWriter().append("<h1>Init!</h1>");
		KhepriApi.init(url, passwd);
		response.getWriter().append(url + " - " + passwd);
		try {
			KhepriAnswer answer = KhepriApi.ask(3);
			response.getWriter().append("<h1>Answer!</h1>");
			response.getWriter().append("Answer: <pre>" + answer.getInfos());
			
		} catch (Exception e) {
			// TODO: handle exception
			response.getWriter().append("<h2>Error: " + e.getMessage()+ "</h2>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

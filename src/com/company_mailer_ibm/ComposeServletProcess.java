package com.company_mailer_ibm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ComposeServletProcess extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		
		String receiver=request.getParameter("to");
		String subject=request.getParameter("subject");
		String message=request.getParameter("message");
		message=message.replaceAll("\n","<br/>");
		String email=(String)request.getSession(false).getAttribute("email");
		
		int i=ComposeDao.save(email, receiver, subject, message);
		if(i>0){
			request.setAttribute("msg","Message Successfully Sent");
			request.getRequestDispatcher("ComposeServlet").forward(request, response);
		}
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();

	}

}


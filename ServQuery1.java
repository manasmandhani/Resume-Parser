

import java.io.IOException;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServQuery1
 */

public class ServQuery1 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am here");
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		
		PrintWriter writer = response.getWriter();
		String skill = request.getParameter("skill");
		String position = request.getParameter("position type");
		Long experience = Long.parseLong(request.getParameter("quantity"));
		String language = request.getParameter("language");
		
		ArrayList<String> list= new ArrayList<String>();
		
		System.out.println("skill is " + skill);
		
		if(skill != null){
			list = Queries.createQuery1(skill);
		}
		
		if(position != null){
			list = Queries.createQuery2(position);
		}
		
		if(experience != null && language != null){
			list = Queries.createQuery6(experience, language);
		}
		
		session.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Display.jsp");
		dispatcher.forward(request, response);
		writer.close();
	}
	
}

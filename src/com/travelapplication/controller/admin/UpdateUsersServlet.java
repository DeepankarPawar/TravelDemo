package com.travelapplication.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.travelapplication.entity.Users;
import com.travelapplication.services.UserServices;

/**
 * Servlet implementation class UpdateUsersServlet
 */
@WebServlet("/admin/UpdateUsersServlet")
public class UpdateUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserServices us=new UserServices();
		Users oldUser=new Users();
		oldUser.setEmail(request.getParameter("email"));
		oldUser.setFullName(request.getParameter("fullName"));
		oldUser.setPassword(request.getParameter("password"));
		oldUser.setUser_id(new Integer(request.getParameter("userId").toString()));
		//us.createUser(newUser);
		Users emailUser=us.getUsersByEmail(request.getParameter("email"));
		
		if(emailUser!=null && emailUser.getUser_id()==oldUser.getUser_id())
		{	
		us.update(oldUser);	
		request.setAttribute("message"," User "+oldUser.getEmail()+" has been updated");
		List<Users> allUsers=us.getAll();
		request.setAttribute("users",allUsers);
		request.getRequestDispatcher("/admin/ListUsers.jsp").forward(request, response);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

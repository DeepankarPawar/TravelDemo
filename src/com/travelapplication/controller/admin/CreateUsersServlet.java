package com.travelapplication.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.travelapplication.DAO.UserDAO;
import com.travelapplication.entity.Users;
import com.travelapplication.services.UserServices;

/**
 * Servlet implementation class CreateUsersServlet
 */
@WebServlet("/admin/CreateUsersServlet")
public class CreateUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserServices us=new UserServices();
		Users newUser=new Users();
		newUser.setEmail(request.getParameter("email"));
		newUser.setFullName(request.getParameter("fullName"));
		newUser.setPassword(request.getParameter("password"));
		if(us.getUsersByEmail(request.getParameter("email"))!=null)
		{us.createUser(newUser);
		
		request.setAttribute("message","New User has been added");
		List<Users> allUsers=us.getAll();
		request.setAttribute("users",allUsers);
		request.getRequestDispatcher("/admin/ListUsers.jsp").forward(request, response);
		}
		else{//response.getWriter().append("Served at: ").append(request.getContextPath());
			request.setAttribute("messageFor","User with email"+request.getParameter("email")+" already Exists");
			request.getRequestDispatcher("/admin/message.jsp").forward(request, response);
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

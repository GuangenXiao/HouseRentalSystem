package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.User;
import Service.IUserService;
import Service.UserService;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession httpSession =request.getSession();
		User u =(User) httpSession.getAttribute("user");
		if(u==null)
		{
		response.setContentType("text/html;charset=utf-8");
		request.getRequestDispatcher("/SecurityServlet").forward(request, response);
		return ;
		}

		String location  = request.getParameter("uLocation");
		String Description  = request.getParameter("uDescription");
		String Email = request.getParameter("uEmail");
		String PhoneNumber  = request.getParameter("uPhoneNumber");
		String Password  = request.getParameter("uPassword");
		String Id  = request.getParameter("uId");
		String Name  = request.getParameter("uName");
		boolean val =false;
		try {
		Integer uerId=	Integer.parseInt(Id);
		if( uerId==u.getuId())val=true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		if(val!=true) {
			response.setContentType("text/html;charset=utf-8");
			request.getRequestDispatcher("/SecurityServlet").forward(request, response);
			return ;
		}
		User Uinfo = new User.Builder().uId(u.getuId()).Build();
		
		if(!Name.equals(u.getuName())) {Uinfo.setuName(Name);}
		
		if(!Password.equals(u.getuPassword())) {Uinfo.setuPassword(Password );}
		
		if(!PhoneNumber.equals(u.getuPhoneNumber())) {Uinfo.setuPhoneNumber(PhoneNumber);}
		
		if(!Email.equals(u.getuEmail())) {Uinfo.setuEmail(Email);}
		
		if(!Description.equals(u.getuDescription())) {Uinfo.setuDescription(Description);}
		
		if(!location.equals(u.getuLocation())) {Uinfo.setuLocation(location);}
		
		IUserService us = new UserService();
		Integer n= us.updateUser(Uinfo);
		if(n>=1) {
			response.getWriter().write("<script   language=javascript>alert('Modify Successfully');</script>");
			response.sendRedirect("/HRsys/LogoutServlet");
		}
		else 
		{
			response.getWriter().write("<script   language=javascript>alert('Modify Fail');'</script>");
			response.sendRedirect("/HRsys/index.jsp");
		}
		
	}

}

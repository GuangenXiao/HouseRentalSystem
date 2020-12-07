package Controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class SearchUserServlet
 */
@WebServlet("/SearchUserServlet")
public class SearchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String info = request.getParameter("UserInfo");
		String type = request.getParameter("UserTypeSelect");
		if(info==null&&type==null)
		{
			response.sendRedirect(request.getContextPath()+"/searchUsers.jsp");
			return ;
		}
		if(info.length()<=0&&type.length()<=0)
		{
			response.sendRedirect(request.getContextPath()+"/searchUsers.jsp");
			return ;
		}
		ArrayList<User> userlist =null;
		IUserService ius= new UserService();
		System.out.print(info);
	  userlist = ius.findUsers(info,type);
	  System.out.println(info+userlist);
	  request.setAttribute("userlist", userlist);
	  request.getRequestDispatcher("/searchUsers.jsp").forward(request, response);
	}

}

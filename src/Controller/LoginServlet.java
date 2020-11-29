package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.House;
import Entity.User;
import Service.UserService;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String userId = request.getParameter("userName");
		String password = request.getParameter("passWord");
		StringBuffer msg = new StringBuffer();
		if(userId==null||password==null){
			msg.append("user Id or password can't be empty");
			request.setAttribute("msg", msg.toString());
			doGet(request, response);
			return;
		}
		if(userId.length()<=0||password.length()<=0)
		{
			msg.append("user Id or password can't be empty");
			request.setAttribute("msg", msg.toString());
			doGet(request, response);
			return;
		}
		if(!Util.Validator.isNumber(userId))
		{
			msg.append("user Id should be number");
			request.setAttribute("msg", msg.toString());
			doGet(request, response);
			return;
		}
		User u =new User.Builder()
				.uId(Integer.parseInt(userId))
				.uPassword(password)
				.Build();
		UserService service =new UserService();
		User uResult =service.UserLogin(u);
		System.out.println(uResult);
		if(uResult==null)
		{
			msg.append("No Suitable User");
			System.out.println("No Suitable User");
			request.setAttribute("msg", msg.toString());
			doGet(request, response);
			return ;
			
		}
		else
		{
			
			if(!u.getuPassword().equals(uResult.getuPassword())){
				msg.append("Incorrect password");
				System.out.println("Incorrect password");
				request.setAttribute("msg", msg.toString());
				doGet(request, response);
				return;}
			if(uResult.getuStatus()==false){
				msg.append("Baned");
				System.out.println("banded");
				request.setAttribute("msg", msg.toString());
				doGet(request, response);
				return;}
			msg.append(":"+uResult.getuName());
			String time= request.getParameter("autologin");
			HttpSession httpSession =request.getSession();
			httpSession.setAttribute("user", uResult);
			if(time!=null)
			{
			Cookie cookie = new Cookie("autologin",uResult.getuId()+"-"+uResult.getuPassword());
			cookie.setMaxAge(Integer.parseInt(time));
			cookie.setPath("/HRsys");
			response.addCookie(cookie);
			}
			System.out.println("login Successfully");
			request.setAttribute("msg", msg.toString());
			response.sendRedirect("/HRsys/index.jsp");
	}
		}
	}


package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.House;
import Service.HouseService;
import Service.IHouseService;

/**
 * Servlet implementation class SearchHouseServlet
 */
@WebServlet("/SearchHouseServlet")
public class SearchHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchHouseServlet() {
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
		response.setContentType("text/html;charset=utf-8");
		String housetype = request.getParameter("HouseTypeSelect");
		String houseinfo = request.getParameter("HouseInfo");
		Integer  index =null;
		if(housetype!=null)
		{
			String [] parts= housetype.split("---");
			index = Integer.parseInt(parts[0]); 
			if(index==0)index=null;
		}
		if(index==null&&houseinfo.length()<=0) 
		{
			response.sendRedirect(request.getContextPath()+"/searchlist.jsp");
			return ;
		}
		System.out.println(index);
		System.out.println(houseinfo);
		
		
		HttpSession session = request.getSession();
		IHouseService hs = new HouseService();
		ArrayList<House> list =hs.findHouses(houseinfo,index);
		System.out.println(list);
		session.setAttribute("houselist", list);
		response.sendRedirect(request.getContextPath()+"/searchlist.jsp");
	}

}

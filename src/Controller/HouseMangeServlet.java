package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.HouseService;

import Service.IHouseService;

/**
 * Servlet implementation class HouseMangeServlet
 */
@WebServlet("/HouseMangeServlet")
public class HouseMangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HouseMangeServlet() {
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
		String houseID=request.getParameter("houseId");
		IHouseService ihs = new HouseService();
		boolean flag = false;
		
		try {
			flag = ihs.deleteHouse(Integer.parseInt(houseID));
		}catch (Exception e) {
			// TODO: handle exception
		}		
		if(flag) {
			response.getWriter().write("<script   language=javascript>alert('Modify Successfully');</script>");
			response.sendRedirect("/HRsys/index.jsp");
		}
		else 
		{
			response.getWriter().write("<script   language=javascript>alert('Modify Fail');'</script>");
			response.sendRedirect("/HRsys/mangerHouse.jsp?houseId="+houseID);
		}
	}

}

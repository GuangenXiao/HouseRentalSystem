package Controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Rental;
import Entity.User;
import Service.HouseService;
import Service.RentService;
import Util.Converter;
import Util.ConverterFactory;

/**
 * Servlet implementation class RentServlet
 */
@WebServlet("/RentServlet")
public class RentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		Integer hID=Integer.parseInt(request.getParameter("ID"));
		User user = (User)request.getSession().getAttribute("user");
	    Integer ID=user.getuId();
	    Date StartDate=null;
	    Date EndDate=null;
		try {
			
			ConverterFactory  cf = new ConverterFactory();
			Converter c = cf.getConverter("DATE");
			StartDate = c.convertString(request.getParameter("StartDate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ConverterFactory  cf = new ConverterFactory();
			Converter c = cf.getConverter("DATE");
			EndDate = c.convertString(request.getParameter("EndDate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer money=Integer.parseInt(request.getParameter("money"));
		StringBuffer msg = new StringBuffer();
		if(ID==null) {
			msg.append("You must log in before you rent a house");
			request.setAttribute("msg", msg.toString());
			doGet(request, response);
			return;
		}
		if(StartDate==null||EndDate==null||money==null) {
			msg.append("The required information is incomplete!");
			request.setAttribute("msg", msg.toString());
			doGet(request, response);
			return;
		}
		Rental rent=new Rental();
		rent.setrUId(ID);
		rent.setrHId(hID);
		rent.setrStart(StartDate);
		rent.setrEnd(EndDate);
		rent.setrPrice(money);
		RentService service=new RentService();
		Boolean result=service.insertRent(rent);
		if(result==true) {
			msg.append("You have successfully send a rent message to owner,please wait for reply");
			request.setAttribute("msg", msg.toString());
			doGet(request, response);
			return;
		}else {
			msg.append("Error!");
			request.setAttribute("msg", msg.toString());
			doGet(request, response);
			return;
		}
	}

}

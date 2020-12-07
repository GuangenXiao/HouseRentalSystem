package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.RentService;

/**
 * Servlet implementation class SearchRentalSerclet
 */
@WebServlet("/SearchRentalSerclet")
public class SearchRentalSerclet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchRentalSerclet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acc="accpet";
		String rej="reject";
		String choose=request.getParameter("choose");
		String RentalId=request.getParameter("rentalId");
		if(choose.equals(acc)){
			RentService service=new RentService();
			Boolean result=service.updateRental(Integer.parseInt(RentalId));
		}else if(choose.equals(rej)){
			RentService service=new RentService();
			Boolean result=service.deteleRental(Integer.parseInt(RentalId));
		}
		response.sendRedirect("/HRsys/index.jsp");
	}

}

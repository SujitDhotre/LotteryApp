package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.loteryDao;


/**
 * Servlet implementation class WinnerController
 */
@WebServlet("/WinnerController")
public class WinnerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WinnerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
//		String email=request.getParameter("email");;
	String number=request.getParameter("number");
		
	
			
			
			try {
				
				 Random rand = new Random(); 
			    
			      int upperbound = 100;
			      
			      int int_random = rand.nextInt(upperbound);
			   int n=   Integer.parseInt(number);
			      
				if(loteryDao.Winner( number) && n==int_random  ){
					pw.print("<a href='Home.html'>Back</a>");
					pw.write("<h1>Winner.........!</h1>");
				
				}
				else
				{
					
					pw.print("<a href='Home.html'>Back</a>");
					pw.write("<h1>Better Luck Next Time</h1>");

					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}

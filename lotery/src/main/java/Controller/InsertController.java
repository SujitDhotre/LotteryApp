package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bo.lotery;
import Dao.loteryDao;


/**
 * Servlet implementation class InsertController
 */
@WebServlet("/InsertController")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String number=request.getParameter("number");
		
		
		
	
		lotery em=new lotery();
		em.setNumber(number);
		
		
		
		int status =loteryDao.insert(em);
		if(status>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("home.html");
			rd.forward(request, response);
		}
		else
		{

			pw.print("<h1>Number is already Exist</h1>");
			pw.print("<a href='Home.html'>Back</a>");
		}
	}

}



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet("/Deletedeliveryman")
public class Deletedeliveryman extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out =response.getWriter() ; 
	int ID =Integer.parseInt(request.getParameter("id-input"))  ;
			
int rs = studentDao.removeDeliveryman(ID) ; 

		if(rs>0){
		response.sendRedirect("viewdelivery") ; 	
		}else {
			out.print("data not deleted") ; 
		}
	}

}



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out =response.getWriter() ; 
	String name =request.getParameter("search") ; 
	List<cus> list =studentDao.GetAlluser1(name); 
	if(list!=null) {
		out.print("<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Login Interface</title>\r\n"

				+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">\r\n"
				+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\" crossorigin=\"anonymous\"></script>\r\n");
		out.print(" <style>\r\n" + "        body {\r\n" + "    font-family: Arial, sans-serif;\r\n"
				+ "    justify-content: center;\r\n" + "    align-items: center;\r\n" + "    height: 100vh;\r\n"
				+ "    margin: 0;\r\n" + "    background-color: #f4f4f4;\r\n" + "}\r\n" + "\r\n"
				+ ".search-container {\r\n" + "    display: flex;\r\n" + "    align-items: center;\r\n"
				+ "    background-color: #fff;\r\n" + "    border-radius: 5px;\r\n"
				+ "    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\r\n" + "    padding: 10px;\r\n" + "}\r\n"
				+ "\r\n" + ".search-input {\r\n" + "    border: none;\r\n" + "    padding: 10px;\r\n"
				+ "    outline: none;\r\n" + "    font-size: 16px;\r\n" + "    flex: 1;\r\n" + "}\r\n" + "\r\n"
				+ ".search-button {\r\n" + "    background-color: #007BFF;\r\n" + "    color: white;\r\n"
				+ "    border: none;\r\n" + "    padding: 10px 20px;\r\n" + "    cursor: pointer;\r\n"
				+ "    border-radius: 0 5px 5px 0;\r\n" + "    font-size: 16px;\r\n"
				+ "    transition: background-color 0.3s;\r\n" + "}\r\n" + "\r\n" + ".search-button:hover {\r\n"
				+ "    background-color: #0056b3;\r\n" + "}\r\n" + "\r\n" + "    </style>\r\n" + "</head>");
		out.print("<body>");
		out.print("  <div style=\"display: flex; justify-content: center; align-items: center;\">\r\n" + "");
		out.print(" <form action = 'searchServlet' method = 'post'>" + "<div class=\"search-container\">\r\n"
				+ "        <input type=\"text\" name='search' placeholder=\"Search...\" class=\"search-input\">\r\n"
				+ "        <button type=\"submit\" class=\"search-button\" value ='search'>Search</button>\r\n" + "    </div>"
				+ "</form>");

		out.print("</div>");
		out.print("<div>");
		out.print("<table class=\"table table-dark table-striped-columns\" border ='1'><tr><th>customername</th><th>customerphone</th><th>CustomerId</th><th>ItemId</th><th>ItemDetails</th><th>Charge</th><th>Email</th><th>Delete</th></tr>");

		for(cus c : list) {  
			 out.print("<tr><td>"+c.getCustomerName()+"</td><td>"+c.getCustomerPhone()+"</td><td>"+c.getCustomerId()+"</td><td>"+c.getItemId()+"</td><td>"+c.getItemDetails()+"</td><td>"+c.getCharge()+"</td><td>"+c.getEmail()+"</td><td><a href='deleteservelet?customerid="+c.getCustomerId()+"'>Delete</a></td> </tr>");   
		}
		out.print("</table>");
     	out.print("</div>");
		out.print("</body>");
		out.print("</html>");
		out.print("<a style ='color:black;' href = 'viewservlet'>home page </a>");

	} else {
		out.print("<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
		+ "    <title>Login Interface</title>\r\n"

				+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">\r\n"
				+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\" crossorigin=\"anonymous\"></script>\r\n");
		out.print(" <style>\r\n" + "        body {\r\n" + "    font-family: Arial, sans-serif;\r\n"
				+ "    justify-content: center;\r\n" + "    align-items: center;\r\n" + "    height: 100vh;\r\n"
				+ "    margin: 0;\r\n" + "    background-color: #f4f4f4;\r\n" + "}\r\n" + "\r\n"
				+ ".search-container {\r\n" + "    display: flex;\r\n" + "    align-items: center;\r\n"
				+ "    background-color: #fff;\r\n" + "    border-radius: 5px;\r\n"
				+ "    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\r\n" + "    padding: 10px;\r\n" + "}\r\n"
				+ "\r\n" + ".search-input {\r\n" + "    border: none;\r\n" + "    padding: 10px;\r\n"
				+ "    outline: none;\r\n" + "    font-size: 16px;\r\n" + "    flex: 1;\r\n" + "}\r\n" + "\r\n"
				+ ".search-button {\r\n" + "    background-color: #007BFF;\r\n" + "    color: white;\r\n"
				+ "    border: none;\r\n" + "    padding: 10px 20px;\r\n" + "    cursor: pointer;\r\n"
				+ "    border-radius: 0 5px 5px 0;\r\n" + "    font-size: 16px;\r\n"
				+ "    transition: background-color 0.3s;\r\n" + "}\r\n" + "\r\n" + ".search-button:hover {\r\n"
				+ "    background-color: #0056b3;\r\n" + "}\r\n" + "\r\n" + "    </style>\r\n" + "</head>");
		out.print("<body>");
		out.print("  <div style=\"display: flex; justify-content: center; align-items: center;\">\r\n" + "");
		out.print(" <form action = 'searchservlet' method = 'post'>" + "<div class=\"search-container\">\r\n"
				+ "        <input type=\"text\" name='search' placeholder=\"Search...\" class=\"search-input\">\r\n"
				+ "        <button type=\"submit\" class=\"search-button\">Search</button>\r\n" + "    </div>"
				+ "</form>");

		out.print("</div>");
		out.print("<div>");
		out.print(
				"<table class=\"table table-dark table-striped-columns\" border ='1'><tr><th>id</th><th>name</th><th>Age</th><th>class</th><th>Branch</th><th>caste</th><th>gender</th><th>date of birth</th><th>year</th><th>session</th><th>password</th><th>Approved</th><th>edit</th><th>delete</th><th>Approved status</th></tr>");

		out.print("No user found");

		out.print("</table>");
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
		out.print("<a style ='color:black;' href = 'viewservlet'>home page </a>");

	}
} 	
	}



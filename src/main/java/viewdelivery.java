

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/viewdelivery")
public class viewdelivery extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out =response.getWriter() ; 
List<Del> li = studentDao.GetAllCustomer() ; 

	out.print("<!DOCTYPE html>\r\n"
			+ "<html lang=\"en\">\r\n"
			+ "<head>\r\n"
			+ "    <meta charset=\"UTF-8\">\r\n"
			+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
			+ "    <title>Scrollspy Example</title> \r\n"
			+ "    <!-- Bootstrap CSS -->\r\n"
			+ "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\r\n"
			+ "\r\n"  );
		out.print("<style type=\"text/css\">\r\n"
				+ "  body {  background-image: url(\"delete.jpeg\"); \r\n"
				+"     background-size:100% 120%; }  "
				+ "</style>") ; 
				out.print( "</head>\r\n"
				
			+ "<body data-spy=\"scroll\" data-target=\"#list-example\" data-offset=\"0\">\r\n"
			+ "\r\n"
			+ "    <div class=\"scrollspy-example\" style=\"position: color :white ;  relative; height: 400px; width: 65%;overflow-y: scroll; margin-top: 20px; \">\r\n"
			+ "       \r\n"
			+ "                    <h1>DELIVERY MAN LIST</h1>\r\n"
			+ "        <p><!DOCTYPE html>\r\n"
			+ "            <html lang=\"en\">\r\n"
			+ "            <head>\r\n"
			+ "                <style>\r\n"
			+ "                    body {\r\n"
			+ "                        font-family: Arial, sans-serif;\r\n"
			+ "                        /background-color: #f0f0f0;/\r\n"
			+ "                        margin: 0;\r\n"
			+ "                        padding: 20px;\r\n"
			+ "                    }\r\n"
			+ "                    \r\n"
			+ "                    .scrollspy-example{\r\n"
			+ "                        \r\n"
			+ "                    }\r\n"
			+ "                    .container {\r\n"
			+ "                        max-width: 920px;\r\n"
			+ "                        margin: 0 auto;\r\n"
			+ "                        margin-left: 0px;\r\n"
			+ "                        background-color: silver;\r\n"
			+ "                        padding: 20px;\r\n"
			+ "                        border-radius: 8px;\r\n"
			+ "                        box-shadow: 0 0 10px rgba(0, 0, 0, 0);\r\n"
			+"                         opacity:0.9;  "
			+ "                    }\r\n"
			+ "                    h1 {\r\n"
			+ "                        color: #ff0000;\r\n"
			+ "                        text-align: center;\r\n"
			+ "                        margin-bottom: 20px;\r\n"
			+ "                    }\r\n"
			+ "                    .table-container {\r\n"
			+ "                        margin-bottom: 20px;\r\n"
			+ "                        border: 1px solid #ccc;\r\n"
			+ "                    }\r\n"
			+ "                    table {\r\n"
			+ "                        width: 100%;\r\n"
			+ "                        border-collapse: collapse;\r\n"
			+ "                    }\r\n"
			+ "                    th, td {\r\n"
			+ "                        border: 1px solid #ccc;\r\n"
			+ "                        padding: 8px;\r\n"
			+ "                        text-align: left;\r\n"
			+ "                    }\r\n"
			+ "                    th {\r\n"
			+ "                        background-color: #f2f2f2;\r\n"
			+ "                        position: sticky;\r\n"
			+ "                        top: 0;\r\n"
			+ "                    }\r\n"
			+ "                    tr:nth-child(even) {\r\n"
			+ "                        background-color: #f9f9f9;\r\n"
			+ "                    }\r\n"
			+ "                    .button {\r\n"
			+ "                        display: inline-block;\r\n"
			+ "                        padding: 10px 20px;\r\n"
			+ "                        font-size: 16px;\r\n"
			+ "                        cursor: pointer;\r\n"
			+ "                        text-align: center;\r\n"
			+ "                        text-decoration: none;\r\n"
			+ "                        outline: none;\r\n"
			+ "                        color: #fff;\r\n"
			+ "                        background-color: #0000ff;\r\n"
			+ "                        border: none;\r\n"
			+ "                        border-radius: 5px;\r\n"
			+ "                    }\r\n"
			+ "                    .button:hover {\r\n"
			+ "                        background-color: #0000cc;\r\n"
			+ "                    }\r\n"
			+ "                    .remove-section {\r\n"
			+ "                        margin-top: 20px;\r\n"
			+ "                        margin-left: 840px;\r\n"
			+ "                        \r\n"
			+ "                    }\r\n"
			+ "                    .remove-section h2 {\r\n"
			+ "                        color: #ff0000;\r\n"
			+ "                    }\r\n"
			+ "                    .remove-section label {\r\n"
			+ "                        color: blue;\r\n"
			+ "                        font-weight: bold;\r\n"
			 + "     font-size : 25px "
			+ "                    }\r\n"
			+ "                    .remove-section input {\r\n"
			+ "                        margin: 10px 0;\r\n"
			+ "                        padding: 5px;\r\n"
			+"width : 250px ; " 
			+"height : 40px ;"
			+ "                    }\r\n"
			+ "                    .delete-button {\r\n"
			+ "                        background-color: #ff0000;\r\n"
			+ "                        margin-top: 20px;\r\n"
			+ "                        \r\n"
			+ "                    }\r\n"
			+ "                    .back-button {\r\n"
			+ "                        background-color: #ffc0cb;\r\n"
			+ "                        color: #000;\r\n"
			+ "                        margin-left: 100px;\r\n"
			+ "                    }\r\n"
			+ "                   \r\n"
			+ "                </style>\r\n"
			+ "            </head>\r\n"
			+ "            <body>\r\n"
			+ "                <div class=\"container\">\r\n"
			+ "                    <div class=\"table-container\">\r\n" ) ; 
	out.print("<table class=\"table table-dark table-striped-columns\" border ='1'><tr><th>ID_No</th><th>Name</th><th>customer phone</th><th>Password</th><th>Address</th><th>Id proof</th><th>Id proof Number</th></tr>");

	for(Del c : li) {
		   out.print("<tr><td>"+c.getD_id()+"</td><td>"+c.getName()+"</td><td>"+c.getPhoneno()+"</td><td>"+c.getPassword()+"</td><td>"+c.getAddress()+"</td><td>"+c.getIdproof()+"</td><td>"+c.getIdproofno()+"</td></tr>");  
	}
		   out.print("</table>") ;
	
	out.print("                </div>\r\n"
			+ "                  \r\n"
			+ "                </body>\r\n"
			+ "            </div>\r\n"
			+ "        </div>\r\n"
			+ "        </html></p>\r\n"
			+ "    <button class=\"button\"><a text-decoration :none ; color :red ;   href=\"viewdelivery\">REFRESH</a></button>\r\n"
			+ "<form action ='Deletedeliveryman' method = 'post'>"
			+ "<div class=\"remove-section\">\r\n"
			+ "            <h2>REMOVE DELIVERY MAN</h2>\r\n"
			+ "            <label for=\"id-input\">ID NUMBER</label>\r\n"
			+ "            <input type=\"number\" id=\"id-input\" name=\"id-input\">\r\n"
			+ "            <br>\r\n"
			+ "            <button class=\"button delete-button\">DELETE</button>\r\n"
			+ "            <button class=\"button back-button\"><a href=\"afteradminlogin.html\">BACK</button>\r\n"
			+ "    </div>\r\n"
			+"   </form>"
			+ "\r\n"
			
			+ "    <script>\r\n"
			+ "        // Initialize scrollspy\r\n"
			+ "        $('body').scrollspy({ target: '#list-example' });\r\n"
			+ "    </script>\r\n"
			+ "</body>\r\n"
			+ "</html>") ; 
}
	}





import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Random;

import javax.naming.ldap.Rdn;

import org.apache.catalina.ha.backend.Sender;
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response) ; ;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html"); 
	int ch =Integer.parseInt(request.getParameter("ch"));
	if(ch==1) {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter() ;
		String adminname ="admin" ; 
		String adminpassword ="admin@123" ; 
		String name = request.getParameter("name") ;
		String password =request.getParameter("password") ;
		if((adminname==name && adminpassword==password) || (adminname.equals(name) && adminpassword.equals(password))) {
		response.sendRedirect("afteradminlogin.html") ; 
		}else {
			out.print("login failed") ; 
		}
	}else if(ch==2) {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String customerName=request.getParameter("customerName");
        String customerPhone=request.getParameter("customerPhone");
        int customerId=Integer.parseInt( request.getParameter("customerId"));
        int itemId=Integer.parseInt( request.getParameter("itemId"));
        String itemDetails=request.getParameter("itemDetails");
        int charge=Integer.parseInt( request.getParameter("charge"));
        String email=request.getParameter("email");
 int rs = studentDao.register(customerName,customerPhone ,customerId,itemId,itemDetails,charge,email) ; 
 if (rs>0) {
out.print("<!DOCTYPE html>\r\n"
		+ "<html lang=\"en\">\r\n"
		+ "<head>\r\n"
		+ "<meta charset=\"UTF-8\">\r\n"
		+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
		+ "<title>Add Customer</title>\r\n"
		+ "<link rel=\"stylesheet\" href=\"homestyle.css\">\r\n"
		+ "    <style>\r\n"
		+ "        /* Style for the modal background */\r\n"
		+ "        .modal {\r\n"
		+ "            display: block; /* Show the modal */\r\n"
		+ "            position: fixed;\r\n"
		+ "            z-index: 1;\r\n"
		+ "            padding-top: 100px;\r\n"
		+ "            left: 0;\r\n"
		+ "            top: 0;\r\n"
		+ "            width: 100%;\r\n"
		+ "            height: 100%;\r\n"
		+ "            overflow: auto;\r\n"
		+ "            background-color: rgba(0,0,0,1); /* Black background with opacity */\r\n"
		+ "        }\r\n"
		+ "\r\n"
		+ "        /* Style for the modal content */\r\n"
		+ "        .modal-content {\r\n"
		+ "            background-color: #fefefe;\r\n"
		+ "            margin: auto;\r\n"
		+ "            padding: 20px;\r\n"
		+ "            border: 1px solid #888;\r\n"
		+ "            width: 60%;\r\n"
		+ "            position: relative;\r\n"
		+ "        }\r\n"
		+ "\r\n"
		+ "        /* The close button */\r\n"
		+ "        .close {\r\n"
		+ "            color: #aaa;\r\n"
		+ "            float: right;\r\n"
		+ "            font-size: 28px;\r\n"
		+ "            font-weight: bold;\r\n"
		+ "        }\r\n"
		+ "\r\n"
		+ "        .close:hover,\r\n"
		+ "        .close:focus {\r\n"
		+ "            color: black;\r\n"
		+ "            text-decoration: none;\r\n"
		+ "            cursor: pointer;\r\n"
		+ "        }\r\n"
		+ "    </style>\r\n"
		+ "\r\n"
		+ "<!-- Link to external CSS file -->\r\n"
		+ "</head>\r\n"
		+ "<body>\r\n"
		+ "	<div class=\"form-container\">\r\n"
		+ "		<h2>ADD CUSTOMER</h2>\r\n"
		+ "		<form id=\"customerForm\" action =\"loginservlet\" method =\"post\">\r\n"
		+ "			<table>\r\n"
		+ "\r\n"
		+ "				<tr>\r\n"
		+ "					<td class=\"label\">CUSTOMER NAME</td>\r\n"
		+ "					<td><input type=\"text\" id=\"customerName\" name=\"customerName\"></td>\r\n"
		+ "				</tr>\r\n"
		+ "\r\n"
		+ "				<tr>\r\n"
		+ "					<td class=\"label\">CUSTOMER PHONE NO</td>\r\n"
		+ "					<td><input type=\"text\" id=\"customerPhone\" name=\"customerPhone\"></td>\r\n"
		+ "				</tr>\r\n"
		+ "\r\n"
		+ "				<tr>\r\n"
		+ "					<td class=\"label\">ID.NO</td>\r\n"
		+ "					<td><input type=\"text\" id=\"customerId\" name=\"customerId\"></td>\r\n"
		+ "				</tr>\r\n"
		+ "\r\n"
		+ "				<tr>\r\n"
		+ "					<td class=\"label\">ITEM ID</td>\r\n"
		+ "					<td><input type=\"text\" id=\"itemId\" name=\"itemId\"></td>\r\n"
		+ "				</tr>\r\n"
		+ "\r\n"
		+ "				<tr>\r\n"
		+ "					<td class=\"label\">ITEM DETAILS</td>\r\n"
		+ "					<td><input type=\"text\" id=\"itemDetails\" name=\"itemDetails\"></td>\r\n"
		+ "				</tr>\r\n"
		+ "\r\n"
		+ "				<tr>\r\n"
		+ "					<td class=\"label\">CHARGE</td>\r\n"
		+ "					<td><input type=\"number\" id=\"charge\" name=\"charge\"></td>\r\n"
		+ "				</tr>\r\n"
		+ "\r\n"
		+ "				<tr>\r\n"
		+ "					<td class=\"label\">EMAIL ID</td>\r\n"
		+ "					<td><input type=\"email\" id=\"email\" name=\"email\"></td>\r\n"
		+ "				</tr>\r\n"
		+ "\r\n"
		+ "\r\n"
		+ "\r\n"
		+ "			</table>\r\n"
		+ "			<div class=\"button-container\">\r\n"
		+ "			  <input type = \"hidden\" name = \"ch\" value = \"2\">\r\n"
		+ "				<button type=\"submit\">SUBMIT</button>\r\n"
		+ "				<div id=\"myModal\" class=\"modal\">\r\n"
		+ "  <div class=\"modal-content\">\r\n"
		+ "    <span class=\"close\">&times;</span>\r\n"
		+ "    <p>Added succesfully</p>\r\n"
		+ "  </div>\r\n"
		+ "</div>\r\n"
		+ "				\r\n"
		+ "				<button type=\"button\" class=\"cancel\"><a href=\"afteradminlogin.html\">CANCEL</a></button>\r\n"
		+ "			</div>\r\n"
		+ "		</form>\r\n"
		+ "		<div class=\"success-message\" id=\"successMessage\">Customer data\r\n"
		+ "			updated successfully</div>\r\n"
		+ "	</div>\r\n"
		+ "<script type=\"text/javascript\">\r\n"
		+ "    // Get the modal\r\n"
		+ "    var modal = document.getElementById(\"myModal\");\r\n"
		+ "\r\n"
		+ "    // Get the close button\r\n"
		+ "    var closeBtn = document.getElementsByClassName(\"close\")[0];\r\n"
		+ "\r\n"
		+ "    // Close the modal when the close button is clicked\r\n"
		+ "    closeBtn.onclick = function() {\r\n"
		+ "        modal.style.display = \"none\";\r\n"
		+ "    }\r\n"
		+ "\r\n"
		+ "    // Close the modal when clicking anywhere outside the modal content\r\n"
		+ "    window.onclick = function(event) {\r\n"
		+ "        if (event.target == modal) {\r\n"
		+ "            modal.style.display = \"none\";\r\n"
		+ "        }\r\n"
		+ "    }\r\n"
		+ "</script>\r\n"
		+ "\r\n"
		+ "</body>\r\n"
		+ "</html>") ; 
//RequestDispatcher re =request.getRequestDispatcher("afteradminlogin.html") ;
//re.include(request, response) ;
}else {
out.print(""
		+ "<link rel=\"stylesheet\" href=\"homestyle.css\">\r\n"
		+ "    <style>\r\n"
		+ "        /* Style for the modal background */\r\n"
		+ "        .modal {\r\n"
		+ "            display: block; /* Show the modal */\r\n"
		+ "            position: fixed;\r\n"
		+ "            z-index: 1;\r\n"
		+ "            padding-top: 100px;\r\n"
		+ "            left: 0;\r\n"
		+ "            top: 0;\r\n"
		+ "            width: 100%;\r\n"
		+ "            height: 100%;\r\n"
		+ "            overflow: auto;\r\n"
		+ "            background-color: rgba(0,0,0,1); /* Black background with opacity */\r\n"
		+ "        }\r\n"
		+ "\r\n"
		+ "        /* Style for the modal content */\r\n"
		+ "        .modal-content {\r\n"
		+ "            background-color: silver;\r\n"
		+ "            margin: auto;\r\n"
		+ "            padding: 20px;\r\n"
		+ "            border: 1px solid #888;\r\n"
		+ "            width: 60%;\r\n"
		+ "            position: relative;\r\n"
		+ "        }\r\n"
		+ "\r\n"
		+ "        /* The close button */\r\n"
		+ "        .close {\r\n"
		+ "            color: #aaa;\r\n"
		+ "            float: right;\r\n"
		+ "            font-size: 28px;\r\n"
		+ "            font-weight: bold;\r\n"
		+ "        }\r\n"
		+ "\r\n"
		+ "        .close:hover,\r\n"
		+ "        .close:focus {\r\n"
		+ "            color: black;\r\n"
		+ "            text-decoration: none;\r\n"
		+ "            cursor: pointer;\r\n"
		+ "        }\r\n"
		+ "    </style>\r\n"
		+ "\r\n"
		+ "<!-- Link to external CSS file -->\r\n"
		+ "</head>\r\n"
		+ "<body>\r\n"
		+ "	<div class=\"form-container\">\r\n"
		+ "		<h2>ADD CUSTOMER</h2>\r\n"
		+ "		<form id=\"customerForm\" action =\"loginservlet\" method =\"post\">\r\n"
		+ "			<table>\r\n"
		+ "\r\n"
		+ "				<tr>\r\n"
		+ "					<td class=\"label\">CUSTOMER NAME</td>\r\n"
		+ "					<td><input type=\"text\" id=\"customerName\" name=\"customerName\"></td>\r\n"
		+ "				</tr>\r\n"
		+ "\r\n"
		+ "				<tr>\r\n"
		+ "					<td class=\"label\">CUSTOMER PHONE NO</td>\r\n"
		+ "					<td><input type=\"text\" id=\"customerPhone\" name=\"customerPhone\"></td>\r\n"
		+ "				</tr>\r\n"
		+ "\r\n"
		+ "				<tr>\r\n"
		+ "					<td class=\"label\">ID.NO</td>\r\n"
		+ "					<td><input type=\"text\" id=\"customerId\" name=\"customerId\"></td>\r\n"
		+ "				</tr>\r\n"
		+ "\r\n"
		+ "				<tr>\r\n"
		+ "					<td class=\"label\">ITEM ID</td>\r\n"
		+ "					<td><input type=\"text\" id=\"itemId\" name=\"itemId\"></td>\r\n"
		+ "				</tr>\r\n"
		+ "\r\n"
		+ "				<tr>\r\n"
		+ "					<td class=\"label\">ITEM DETAILS</td>\r\n"
		+ "					<td><input type=\"text\" id=\"itemDetails\" name=\"itemDetails\"></td>\r\n"
		+ "				</tr>\r\n"
		+ "\r\n"
		+ "				<tr>\r\n"
		+ "					<td class=\"label\">CHARGE</td>\r\n"
		+ "					<td><input type=\"number\" id=\"charge\" name=\"charge\"></td>\r\n"
		+ "				</tr>\r\n"
		+ "\r\n"
		+ "				<tr>\r\n"
		+ "					<td class=\"label\">EMAIL ID</td>\r\n"
		+ "					<td><input type=\"email\" id=\"email\" name=\"email\"></td>\r\n"
		+ "				</tr>\r\n"
		+ "\r\n"
		+ "\r\n"
		+ "\r\n"
		+ "			</table>\r\n"
		+ "			<div class=\"button-container\">\r\n"
		+ "			  <input type = \"hidden\" name = \"ch\" value = \"2\">\r\n"
		+ "				<button type=\"submit\">SUBMIT</button>\r\n"
		+ "				<div id=\"myModal\" class=\"modal\">\r\n"
		+ "  <div class=\"modal-content\">\r\n"
		+ "    <span class=\"close\">&times;</span>\r\n"
		+ "    <p>customer id invalid</p>\r\n"
		+ "  </div>\r\n"
		+ "</div>\r\n"
		+ "				\r\n"
		+ "				<button type=\"button\" class=\"cancel\"><a href=\"afteradminlogin.html\">CANCEL</a></button>\r\n"
		+ "			</div>\r\n"
		+ "		</form>\r\n"
			+ "<script type=\"text/javascript\">\r\n"
		+ "    // Get the modal\r\n"
		+ "    var modal = document.getElementById(\"myModal\");\r\n"
		+ "\r\n"
		+ "    // Get the close button\r\n"
		+ "    var closeBtn = document.getElementsByClassName(\"close\")[0];\r\n"
		+ "\r\n"
		+ "    // Close the modal when the close button is clicked\r\n"
		+ "    closeBtn.onclick = function() {\r\n"
		+ "        modal.style.display = \"none\";\r\n"
		+ "    }\r\n"
		+ "\r\n"
		+ "    // Close the modal when clicking anywhere outside the modal content\r\n"
		+ "    window.onclick = function(event) {\r\n"
		+ "        if (event.target == modal) {\r\n"
		+ "            modal.style.display = \"none\";\r\n"
		+ "        }\r\n"
		+ "    }\r\n"
		+ "</script>\r\n"
		+ "\r\n"
		+ "</body>\r\n"
		+ "</html>");
}

	}else if(ch==3) {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter() ;
	 
		int D_id =Integer.parseInt(request.getParameter("D_id")) ; 
		String name =request.getParameter("name") ;
		String phoneno =request.getParameter("phone") ; 
		String password =request.getParameter("password") ; 
		String Address =request.getParameter("address") ; 
		String idproof =request.getParameter("id_proof") ; 
		String idproofno =request.getParameter("id_proof_number") ; 
  int rs =studentDao.AddDeliveryman(D_id ,name ,phoneno ,password,Address,idproof,idproofno) ; 	
	if(rs>0) {
		out.print("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Delivery Man Detail</title>\r\n"
				+ " <style type=\"text/css\">\r\n"
				+ " body {\r\n"
				+ "    background-image: url(\"Delievery.jpeg\"); \r\n"
				+ "    background-size: cover;\r\n"
				+ "    font-family: Arial, sans-serif;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".container {\r\n"
				+ "    width: 400px;\r\n"
				+ "   margin-top: 0;\r\n"
				+ "    margin-left: 20px;\r\n"
				+ "    padding: 10px;\r\n"
				+ " \r\n"
				+ "    border-radius: 10px;\r\n"
				+ "  \r\n"
				+ "    \r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".container2 {\r\n"
				+ "    width: 400px;\r\n"
				+ "\r\n"
				+ "     margin-left: 800px;\r\n"
				+ "    padding: 10px;\r\n"
				+ "  \r\n"
				+ "    border-radius: 10px;\r\n"
				+ " \r\n"
				+ "    \r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "h1 {\r\n"
				+ "    margin-left: 100px;\r\n"
				+ "    color: limegreen;\r\n"
				+ "    font-size: 24px;\r\n"
				+ "    text-shadow: 1px 1px 1px black;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "label {\r\n"
				+ "    display: block;\r\n"
				+ "    font-weight: bold;\r\n"
				+ "    margin-top: 10px;\r\n"
				+ "    color: yellow;\r\n"
				+ "    text-shadow: 1px 1px 1px black;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "input[type=\"text\"], input[type=\"password\"] {\r\n"
				+ "    width: 100%;\r\n"
				+ "    padding: 8px;\r\n"
				+ "    margin-top: 5px;\r\n"
				+ "    margin-bottom: 15px;\r\n"
				+ "    border-radius: 5px;\r\n"
				+ "    border: 1px solid #ccc;\r\n"
				+ "    font-size: 14px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".buttons {\r\n"
				+ "    display: flex;\r\n"
				+ "   \r\n"
				+ "    gap: 20px; \r\n"
				+ "   margin-left: 85px\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "button {\r\n"
				+ "    padding: 10px 40px; \r\n"
				+ "    border: none;\r\n"
				+ "    border-radius: 5px;\r\n"
				+ "    font-weight: bold;\r\n"
				+ "    cursor: pointer;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".submit {\r\n"
				+ "    background-color: blue;\r\n"
				+ "    color: white;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".cancel {\r\n"
				+ "    background-color: gray;\r\n"
				+ "    color: white;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "button:hover {\r\n"
				+ "    opacity: 0.8;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".id_proof1{\r\n"
				+ " width: 100%;\r\n"
				+ "    padding: 8px;\r\n"
				+ "    margin-top: 5px;\r\n"
				+ "    margin-bottom: 15px;\r\n"
				+ "    border-radius: 5px;\r\n"
				+ "    border: 1px solid #ccc;\r\n"
				+ "    font-size: 14px;\r\n"
				+ "}\r\n"
				+ " .modal {\r\n"
				+ "            display: block; /* Show the modal */\r\n"
				+ "            position: fixed;\r\n"
				+ "            z-index: 1;\r\n"
				+ "            padding-top: 100px;\r\n"
				+ "            left: 0;\r\n"
				+ "            top: 0;\r\n"
				+ "            width: 100%;\r\n"
				+ "            height: 100%;\r\n"
				+ "            overflow: auto;\r\n"
				+ "            background-color: rgba(0,0,0,0.9); /* Black background with opacity */\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        /* Style for the modal content */\r\n"
				+ "        .modal-content {\r\n"
				+ "            background-color: #fefefe;\r\n"
				+ "            margin: auto;\r\n"
				+ "            padding: 20px;\r\n"
				+ "            border: 1px solid #888;\r\n"
				+ "            width: 80%;\r\n"
				+ "            position: relative;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        /* The close button */\r\n"
				+ "        .close {\r\n"
				+ "            color: #aaa;\r\n"
				+ "            float: right;\r\n"
				+ "            font-size: 28px;\r\n"
				+ "            font-weight: bold;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .close:hover,\r\n"
				+ "        .close:focus {\r\n"
				+ "            color: black;\r\n"
				+ "            text-decoration: none;\r\n"
				+ "            cursor: pointer;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ " \r\n"
				+ " \r\n"
				+ " </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "     <h1>DELIVERY MAN DETAIL</h1>\r\n"
				+ "     <form action=\"loginservlet\" method=\"POST\">\r\n"
				+ "    <div class=\"container\">\r\n"
				+ "        \r\n"
				+ "           \r\n"
				+ "            <label for=\"id_no\">ID NO</label>\r\n"
				+ "            <input type=\"text\" id=\"D_id\" name=\"D_id\" required><br>\r\n"
				+ "\r\n"
				+ "            <label for=\"name\">NAME</label>\r\n"
				+ "            <input type=\"text\" id=\"name\" name=\"name\" required><br>\r\n"
				+ "\r\n"
				+ "            <label for=\"phone\">PH.NO</label>\r\n"
				+ "            <input type=\"text\" id=\"phone\" name=\"phone\" required><br>\r\n"
				+ "                  \r\n"
				+ "      \r\n"
				+ "\r\n"
				+ "            </div>\r\n"
				+ "         \r\n"
				+ "         \r\n"
				+ "         <div class=\"buttons\">\r\n"
				+ "         <input type =\"hidden\" name = \"ch\" value ='3' >\r\n"
				+ "                <button type=\"submit\" class=\"submit\">SUBMIT</button>\r\n"
				+ "                <button type=\"button\" class=\"cancel\">CANCEL</button>\r\n"
				+ "            </div>\r\n"
				+ "    \r\n"
				+ "    <div class=\"container2\">   \r\n"
				+ "            <label for=\"password\" >PASSWORD</label>\r\n"
				+ "            <input type=\"password\" id=\"password\" name=\"password\" required><br>\r\n"
				+ "\r\n"
				+ "            <label for=\"address\">ADDRESS</label>\r\n"
				+ "            <input type=\"text\" id=\"address\" name=\"address\" required><br>\r\n"
				+ "\r\n"
				+ "            <label for=\"id_proof\">ID PROOF</label>\r\n"
				+ "           <select id=\"id_proof\" class =\"id_proof1\" name=\"id_proof\" required=\"required\">\r\n"
				+ "                <option value=\"\">Select ID Proof</option>\r\n"
				+ "                <option value=\"aadhaar\">Aadhaar Card</option>\r\n"
				+ "                <option value=\"pan\">PAN Card</option>\r\n"
				+ "                 <option value=\"driving_license\">Driving License</option>\r\n"
				+ "            </select><br>\r\n"
				+ "\r\n"
				+ "            <label for=\"id_proof_number\">ID PROOF NUMBER</label>\r\n"
				+ "            <input type=\"text\" id=\"id_proof_number\" name=\"id_proof_number\" required><br>\r\n"
				+ "    </div>\r\n"
				+ "            \r\n"
				+ "           <div id=\"myModal\" class=\"modal\">\r\n"
				+ "  <div class=\"modal-content\">\r\n"
				+ "    <span class=\"close\">&times;</span>\r\n"
				+ "    <p>Added succesfully</p>\r\n"
				+ "  </div>\r\n"
				+ "</div>\r\n"
				+ "\r\n"
				+ "<script type=\"text/javascript\">\r\n"
				+ "    // Get the modal\r\n"
				+ "    var modal = document.getElementById(\"myModal\");\r\n"
				+ "\r\n"
				+ "    // Get the close button\r\n"
				+ "    var closeBtn = document.getElementsByClassName(\"close\")[0];\r\n"
				+ "\r\n"
				+ "    // Close the modal when the close button is clicked\r\n"
				+ "    closeBtn.onclick = function() {\r\n"
				+ "        modal.style.display = \"none\";\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    // Close the modal when clicking anywhere outside the modal content\r\n"
				+ "    window.onclick = function(event) {\r\n"
				+ "        if (event.target == modal) {\r\n"
				+ "            modal.style.display = \"none\";\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "</script>\r\n"
				+ "           \r\n"
				+ "        \r\n"
				+ "\r\n"
				+ "             </form>\r\n"
				+ "</body>\r\n"
				+ "</html>") ;
	}else {
		out.print("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Delivery Man Detail</title>\r\n"
				+ " <style type=\"text/css\">\r\n"
				+ " body {\r\n"
				+ "    background-image: url(\"Delievery.jpeg\"); \r\n"
				+ "    background-size: cover;\r\n"
				+ "    font-family: Arial, sans-serif;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".container {\r\n"
				+ "    width: 400px;\r\n"
				+ "   margin-top: 0;\r\n"
				+ "    margin-left: 20px;\r\n"
				+ "    padding: 10px;\r\n"
				+ " \r\n"
				+ "    border-radius: 10px;\r\n"
				+ "  \r\n"
				+ "    \r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".container2 {\r\n"
				+ "    width: 400px;\r\n"
				+ "\r\n"
				+ "     margin-left: 800px;\r\n"
				+ "    padding: 10px;\r\n"
				+ "  \r\n"
				+ "    border-radius: 10px;\r\n"
				+ " \r\n"
				+ "    \r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "h1 {\r\n"
				+ "    margin-left: 100px;\r\n"
				+ "    color: limegreen;\r\n"
				+ "    font-size: 24px;\r\n"
				+ "    text-shadow: 1px 1px 1px black;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "label {\r\n"
				+ "    display: block;\r\n"
				+ "    font-weight: bold;\r\n"
				+ "    margin-top: 10px;\r\n"
				+ "    color: yellow;\r\n"
				+ "    text-shadow: 1px 1px 1px black;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "input[type=\"text\"], input[type=\"password\"] {\r\n"
				+ "    width: 100%;\r\n"
				+ "    padding: 8px;\r\n"
				+ "    margin-top: 5px;\r\n"
				+ "    margin-bottom: 15px;\r\n"
				+ "    border-radius: 5px;\r\n"
				+ "    border: 1px solid #ccc;\r\n"
				+ "    font-size: 14px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".buttons {\r\n"
				+ "    display: flex;\r\n"
				+ "   \r\n"
				+ "    gap: 20px; \r\n"
				+ "   margin-left: 85px\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "button {\r\n"
				+ "    padding: 10px 40px; \r\n"
				+ "    border: none;\r\n"
				+ "    border-radius: 5px;\r\n"
				+ "    font-weight: bold;\r\n"
				+ "    cursor: pointer;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".submit {\r\n"
				+ "    background-color: blue;\r\n"
				+ "    color: white;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".cancel {\r\n"
				+ "    background-color: gray;\r\n"
				+ "    color: white;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "button:hover {\r\n"
				+ "    opacity: 0.8;\r\n"
				+ "}\r\n"
				+ "\r\n"
			
				+ ".id_proof1{\r\n"
				+ " width: 100%;\r\n"
				+ "    padding: 8px;\r\n"
				+ "    margin-top: 5px;\r\n"
				+ "    margin-bottom: 15px;\r\n"
				+ "    border-radius: 5px;\r\n"
				+ "    border: 1px solid #ccc;\r\n"
				+ "    font-size: 14px;\r\n"
				+ "}\r\n"
				+ " .modal {\r\n"
				+ "            display: block; /* Show the modal */\r\n"
				+ "            position: fixed;\r\n"
				+ "            z-index: 1;\r\n"
				+ "            padding-top: 100px;\r\n"
				+ "            left: 0;\r\n"
				+ "            top: 0;\r\n"
				+ "            width: 100%;\r\n"
				+ "            height: 100%;\r\n"
				+ "            overflow: auto;\r\n"
				+ "            background-color: rgba(0,0,0,0.9); /* Black background with opacity */\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        /* Style for the modal content */\r\n"
				+ "        .modal-content {\r\n"
				+ "            background-color: #fefefe;\r\n"
				+ "            margin: auto;\r\n"
				+ "            padding: 20px;\r\n"
				+ "            border: 1px solid #888;\r\n"
				+ "            width: 80%;\r\n"
				+ "            position: relative;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        /* The close button */\r\n"
				+ "        .close {\r\n"
				+ "            color: #aaa;\r\n"
				+ "            float: right;\r\n"
				+ "            font-size: 28px;\r\n"
				+ "            font-weight: bold;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .close:hover,\r\n"
				+ "        .close:focus {\r\n"
				+ "            color: black;\r\n"
				+ "            text-decoration: none;\r\n"
				+ "            cursor: pointer;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ " \r\n"
				+ " \r\n"
				+ " </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "     <h1>DELIVERY MAN DETAIL</h1>\r\n"
				+ "     <form action=\"loginservlet\" method=\"POST\">\r\n"
				+ "    <div class=\"container\">\r\n"
				+ "        \r\n"
				+ "           \r\n"
				+ "            <label for=\"id_no\">ID NO</label>\r\n"
				+ "            <input type=\"text\" id=\"D_id\" name=\"D_id\" required><br>\r\n"
				+ "\r\n"
				+ "            <label for=\"name\">NAME</label>\r\n"
				+ "            <input type=\"text\" id=\"name\" name=\"name\" required><br>\r\n"
				+ "\r\n"
				+ "            <label for=\"phone\">PH.NO</label>\r\n"
				+ "            <input type=\"text\" id=\"phone\" name=\"phone\" required><br>\r\n"
				+ "                  \r\n"
				+ "      \r\n"
				+ "\r\n"
				+ "            </div>\r\n"
				+ "         \r\n"
				+ "         \r\n"
				+ "         <div class=\"buttons\">\r\n"
				+ "         <input type =\"hidden\" name = \"ch\" value ='3' >\r\n"
				+ "                <button type=\"submit\" class=\"submit\">SUBMIT</button>\r\n"
				+ "                <button type=\"button\" class=\"cancel\">CANCEL</button>\r\n"
				+ "            </div>\r\n"
				+ "    \r\n"
				+ "    <div class=\"container2\">   \r\n"
				+ "            <label for=\"password\" >PASSWORD</label>\r\n"
				+ "            <input type=\"password\" id=\"password\" name=\"password\" required><br>\r\n"
				+ "\r\n"
				+ "            <label for=\"address\">ADDRESS</label>\r\n"
				+ "            <input type=\"text\" id=\"address\" name=\"address\" required><br>\r\n"
				+ "\r\n"
				+ "            <label for=\"id_proof\">ID PROOF</label>\r\n"
				+ "           <select id=\"id_proof\" class =\"id_proof1\" name=\"id_proof\" required=\"required\">\r\n"
				+ "                <option value=\"\">Select ID Proof</option>\r\n"
				+ "                <option value=\"aadhaar\">Aadhaar Card</option>\r\n"
				+ "                <option value=\"pan\">PAN Card</option>\r\n"
				+ "                 <option value=\"driving_license\">Driving License</option>\r\n"
				+ "            </select><br>\r\n"
				+ "\r\n"
				+ "            <label for=\"id_proof_number\">ID PROOF NUMBER</label>\r\n"
				+ "            <input type=\"text\" id=\"id_proof_number\" name=\"id_proof_number\" required><br>\r\n"
				+ "    </div>\r\n"
				+ "            \r\n"
				+ "           <div id=\"myModal\" class=\"modal\">\r\n"
				+ "  <div class=\"modal-content\">\r\n"
				+ "    <span class=\"close\">&times;</span>\r\n"
				+ "    <p>Id Number invalid</p>\r\n"
				+ "  </div>\r\n"
				+ "</div>\r\n"
				+ "\r\n"
				+ "<script type=\"text/javascript\">\r\n"
				+ "    // Get the modal\r\n"
				+ "    var modal = document.getElementById(\"myModal\");\r\n"
				+ "\r\n"
				+ "    // Get the close button\r\n"
				+ "    var closeBtn = document.getElementsByClassName(\"close\")[0];\r\n"
				+ "\r\n"
				+ "    // Close the modal when the close button is clicked\r\n"
				+ "    closeBtn.onclick = function() {\r\n"
				+ "        modal.style.display = \"none\";\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    // Close the modal when clicking anywhere outside the modal content\r\n"
				+ "    window.onclick = function(event) {\r\n"
				+ "        if (event.target == modal) {\r\n"
				+ "            modal.style.display = \"none\";\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "</script>\r\n"
				+ "           \r\n"
				+ "        \r\n"
				+ "\r\n"
				+ "        <div class=\"popup\">\r\n"
				+ "            <p>id invalid </p>\r\n"
				+ "            <button>OK</button>\r\n"
				+ "        </div>\r\n"
				+ "           </form>\r\n"
				+ "</body>\r\n"
				+ "</html>") ; 
	}
		
 	}
	}


	
}

<%@page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delivery Form</title>
    <link rel="stylesheet" href="product.css">
</head>
<body>
    <div class="container">
        <div class="form-box">
            <h1 style="background-color: skyblue;" class="title">PRODUCT</h1>
            <form action="" method="post">
                <label for="delivery-man-id">DELIVERY MAN ID</label>
                <select id="delivery-man-id">
                    <option value=""></option>
                </select>
                
                <label for="name">NAME</label>
                <input type="text" id="name">
                
                <label for="mobile">MOBILE.NO</label>
                <input type="text" id="mobile">
                
                <label for="customer-id">CUSTOMER ID</label>
                <select id="customer-id"> 
                    <%    
                    studentDao dao =new studentDao() ; 
                    List<Del> list = dao.GetAllCustomer() ; 
 
                    for (Del c : list) { 
                    %>
                        <option value="<%= c.getD_id() %>"><%= c.getD_id() %></option>
                    <%  
                    } 
                    %>
                </select>
                
                <label for="item-id">ITEM ID</label>
                <input type="text" id="item-id">
                
                <label for="type-of-parcel">TYPE OF PARCEL</label>
                <input type="text" id="type-of-parcel">
                
                <label for="address">ADDRESS</label>
                <input type="text" id="address">
                
                <div class="button-group">
                    <button type="submit">SUBMIT</button>
                    <button type="reset"><a href="afteradminlogin.html">CANCEL</a></button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>

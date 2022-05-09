<%@ page import="java.util.List" %>
<%@ page import="Entities.User" %>
<!doctype html>
<html lang="en">
<head>
    <title>Home Page</title>
    <%
        response.getWriter().write("Welcome " + request.getAttribute("firstname") + " " + request.getAttribute("lastname"));
        request.setAttribute("email", request.getAttribute("email"));
        request.setAttribute("password", request.getAttribute("password"));
        System.out.println("STRING EMAIL: "  + request.getAttribute("email"));
        System.out.println("STRING PASSWORD: "  + request.getAttribute("password"));
    %>
    <% String email = (String) request.getAttribute("email"); %>
    <br>
    <hr/>
</head>
<body>
<form method="post" action="/my-app/create-appointment-servlet">
    <div class="container" style="padding: 50px 0; margin-left: 500px">
        <input name="appointment-name" placeholder="Appointment Name" style="margin-top: 15px;">
        <br>
        <br>
        <button type="submit" style="margin-top: 15px;">Create Appointment</button>
    </div>
</form>
<hr/>
<form method="post" action="/my-app/doctor-appointment-list">
    <div class="container" style="padding: 50px 0; margin-left: 500px">
        <input type="hidden" name="email" value=<%=email %> />
        <br>
        <br>
        <button type="submit" style="margin-top: 15px;">My Appointments</button>
    </div>
</form>
</body>
</html>
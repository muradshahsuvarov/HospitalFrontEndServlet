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
    %>
    <br>
    <hr/>
</head>
<body>
<form method="post" action="/my-app/search-doc-ser-servlet">
    <div class="container" style="padding: 50px 0; margin-left: 500px">
        <input name="search-params" placeholder="Doctor Name" style="margin-top: 15px;">
        <br>
        <br>
        <hr/>
        <button type="submit" style="margin-top: 15px;">Search Doctor</button>
    </div>
</form>
<hr/>
<form method="post" action="/my-app/my-book-servlet">
    <div class="container" style="padding: 50px 0; margin-left: 500px">
        <input name="search-params" placeholder="Service Name" style="margin-top: 15px;">
        <br>
        <br>
        <button type="submit" style="margin-top: 15px;">Search Appointments</button>
    </div>
</form>
</body>
</html>
<%@ page import="java.util.List" %>
<%@ page import="Entities.User" %>
<!doctype html>
<html lang="en">
<head>
    <title>Search Results...</title>
    <%

        response.getWriter().write("Search results...");

    %>
    <br>
    <hr/>
    <%
        List<String> bookings = (List) request.getAttribute("services");
    %>
    <table>
      <tr>
        <th>Book Name</th>
        <th>Doctor Email</th>
        <th>Datetime</th>
      </tr>
        <%for (String booking : bookings){%>
           <form method="post" action="/my-app/book-appointment-servlet">
                <tr>
                    <% String app_name = (String)booking.split(",")[0]; %>
                    <% String app_owner_email = (String)booking.split(",")[2]; %>

                    <td><input type="hidden" name="appointment-name" value=<%=app_name %> /><%=app_name %></td>
                    <td><input type="hidden" name="appointment-owner-email" value=<%=app_owner_email %> /><%=app_owner_email %></td>
                    <td><%=booking.split(",")[4] %></td>
                    <td><button type="submit" style="margin-top: 15px;">Book</button></td>
                </tr>
           </form>
        <% } %>
    </table>
</head>
<body>
</body>
</html>
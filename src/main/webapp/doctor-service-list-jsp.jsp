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
        List<String> bookings = (List) request.getAttribute("appointments");
    %>
    <table>
      <tr>
        <th>Book Name</th>
        <th>Patient Email<th>
        <th>Doctor Email</th>
        <th>IsBooked</th>
        <th>Datetime</th>
      </tr>
        <%for (String booking : bookings){%>
           <form method="post" action="/my-app/book-appointment-servlet">
                <tr>
                    <% String app_name = (String)booking.split(",")[0]; %>
                    <% String app_patient_email = (String)booking.split(",")[1]; %>
                    <% String app_owner_email = (String)booking.split(",")[2]; %>
                    <% String app_is_booked = (String)booking.split(",")[3]; %>
                    <% String app_datetime = (String)booking.split(",")[4]; %>

                    <td><%=app_name %></td>
                    <td><%=app_patient_email %></td>
                    <td><%=app_owner_email %></td>
                    <td><%=app_is_booked %></td>
                    <td><%=app_datetime %></td>
                </tr>
           </form>
        <% } %>
    </table>
</head>
<body>
</body>
</html>
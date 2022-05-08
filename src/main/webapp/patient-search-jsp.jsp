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
        List<String> doctors = (List) request.getAttribute("doctors");
    %>
    <table>
      <tr>
        <th>Doctor Email</th>
        <th>Doctor First Name</th>
        <th>Doctor Last Name</th>
        <th>Specialization</th>
      </tr>
        <%for (String doctor : doctors){%>
                <tr>
                    <td><%=doctor.split(",")[0] %></td>
                    <td><%=doctor.split(",")[1] %></td>
                    <td><%=doctor.split(",")[2] %></td>
                    <td><%=doctor.split(",")[3] %></td>
                </tr>
        <% } %>
    </table>
</head>
<body>
</body>
</html>
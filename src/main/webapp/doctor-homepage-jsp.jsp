<%@ page import="java.util.List" %>
<%@ page import="Entities.User" %>
<!doctype html>
<html lang="en">
<head>
    <title>Home Page</title>
    <%

        response.getWriter().write("First Message");

    %>
    <br>
    <hr/>
    <%
        List<User> users = (List) request.getAttribute("users");
        User firstUser = users.get(0);
    %>
    <b><%= "Welcome " + firstUser.getName() + " " + firstUser.getSurname() %></b>
    <table>
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
      </tr>
        <%for (User user : users){%>
                <tr>
                    <td><%=user.getName() %></td>
                    <td><%=user.getSurname() %></td>
                </tr>
        <% } %>
    </table>
</head>
<body>
<h1>Hello JSP</h1>
</body>
</html>
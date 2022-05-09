package Frontend;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("my-book-servlet")
public class BookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String auth_email = req.getParameter("email");
        String auth_password = req.getParameter("password");
        String search_params = req.getParameter("search-params"); // Is a key


        req.setAttribute("email", auth_email);
        req.setAttribute("password", auth_password);
        req.setAttribute("search-params", search_params);
        getServletContext().getRequestDispatcher("/book-list-serv").forward(req, resp);


    }
}

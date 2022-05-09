package Frontend;

import Entities.MainFunctions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("book-list-serv")
public class BookListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (MainFunctions._authedAccout == null){

            resp.getWriter().write("Search Failed!\n");

        }else {
            System.out.println("Search: Authed");
            System.out.println("Search Param: " + req.getParameter("search-params"));
            ArrayList<String> _services = MainFunctions._authedAccout.SearchAppointment(req.getParameter("search-params"));
            if (_services != null) {
                req.setAttribute("services", _services);
                getServletContext().getRequestDispatcher("/patient-appointments-jsp.jsp").forward(req, resp);
            }else {
                resp.getWriter().write("Couldn't find any doctors named " + req.getParameter("search-params") + "\n");
            }
        }

    }
}

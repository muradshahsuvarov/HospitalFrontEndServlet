package Frontend;

import Entities.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static Entities.MainFunctions.AuthenticateUser;

@WebServlet("patient-search-serv")
public class PatientSearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account _authAccount = AuthenticateUser(req.getParameter("email"), req.getParameter("password"));
        if (_authAccount == null){

            resp.getWriter().write("Search Failed!\n");

        }else {
            System.out.println("Search: Authed");
            ArrayList<String> _doctors = _authAccount.SearchDoctors(req.getParameter("search-params"));
            if (_doctors != null) {
                req.setAttribute("doctors", _doctors);
                getServletContext().getRequestDispatcher("/patient-search-jsp.jsp").forward(req, resp);
            }else {
                resp.getWriter().write("Couldn't find any doctors named " + req.getParameter("search-params") + "\n");
            }
        }

    }
}

package Frontend;

import Entities.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static Entities.MainFunctions.AuthenticateUser;

@WebServlet("patient-acc-serv")
public class PatientAccServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String auth_email = req.getParameter("email");
        String auth_password = req.getParameter("password");

        Account _authenticatedAccount = AuthenticateUser(auth_email, auth_password);
        if (_authenticatedAccount.doctor != null) { // The user is doctor
            _authenticatedAccount.CreateSchedule();
        }

        if (_authenticatedAccount.user == null) {

        }else{
            req.setAttribute("firstname", _authenticatedAccount.user.getName());
            req.setAttribute("lastname", _authenticatedAccount.user.getSurname());
            req.setAttribute("email", _authenticatedAccount.user.getEmail());
            req.setAttribute("password", _authenticatedAccount.user.getPassword());
            getServletContext().getRequestDispatcher("/patient-homepage-jsp.jsp").forward(req, resp);
        }

    }
}

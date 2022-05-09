package Frontend;

import Entities.Account;
import org.jetbrains.annotations.NotNull;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

import static Entities.MainFunctions.AuthenticateUser;


@WebServlet(urlPatterns = {"/login-servlet"})
public class LoginServlet extends HttpServlet {

    public Account _authenticatedAccount;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); // Will initialize config files in parent Servlet class
        log("Server started...");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        resp.getWriter().write("Method service\n");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI(); // After the domain
        String params = formatParams(req);
        resp.getWriter().write("Method doGet\nURI " + uri + "\nParams: \n" + params + "\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI(); // After the domain
        String params = formatParams(req);

        _authenticatedAccount = AuthenticateUser(req.getParameter("email"), req.getParameter("password"));

            if (_authenticatedAccount.user == null) {
                resp.getWriter().write("Authentication Failed!\nMethod doPost\nURI " + uri + "\nParams: \n" + params + "\n");
            }else{
                // TODO: Dispatch to either PatientAccServlet or DoctorAccServlet
                req.setAttribute("email", _authenticatedAccount.username);
                req.setAttribute("password", _authenticatedAccount.password);
                resp.getWriter().write("Successful authentication!\nMethod doPost\nURI " + uri + "\nParams: \n" + params + "\n");
                if (_authenticatedAccount.doctor == null && _authenticatedAccount.patient != null) {
                    getServletContext().getRequestDispatcher("/patient-acc-serv").forward(req, resp);
                }else if (_authenticatedAccount.doctor != null && _authenticatedAccount.patient == null) {
                    getServletContext().getRequestDispatcher("/doctor-acc-serv").forward(req, resp);
                }
            }
    }

    @NotNull
    private String formatParams(HttpServletRequest req) {
        return req.getParameterMap()
                .entrySet()
                .stream()
                .map(entry -> {
                    String param = String.join(" and ", entry.getValue());
                    return entry.getKey() + " => " + param;
                })
                .collect(Collectors.joining("\n"));
    }

    @Override
    public void destroy() {
        log("Server destroyed...");
    }
}
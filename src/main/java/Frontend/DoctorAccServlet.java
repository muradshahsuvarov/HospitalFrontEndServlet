package Frontend;

import Entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("doctor-acc-serv")
public class DoctorAccServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<User> users = new ArrayList<User>() {{
            add(new User(
                    "Murad",
                    "Shahsuvarov",
                    "muradshahsuvarov@gmail.com",
                    "muradshahsuvarov@gmail.com",
                    "Muradikov_21",
                    "+994517773924",
                    23,
                    "Male",
                    false,
                    "Hello, I am a patient"));
            add(new User(
                    "Surkhay",
                    "Shahsuvarov",
                    "surkhayshahsuvarov@gmail.com",
                    "surkhayshahsuvarov@gmail.com",
                    "Muradikov_21",
                    "+994507876897",
                    23,
                    "Male",
                    true,
                    "Hello, I am a doctor"));
        }};
        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/doctor-homepage-jsp.jsp").forward(req, resp);
    }
}

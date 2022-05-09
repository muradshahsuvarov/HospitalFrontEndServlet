package Frontend;

import Entities.MainFunctions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("doctor-appointment-list")
public class DoctorAppointsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String auth_email = req.getParameter("email");

        System.out.println("DoctorAppointsServlet.java auth_email: " + auth_email);

        ArrayList<String> _appointments = MainFunctions._authedAccout.SearchAppointmentByEmail(auth_email);
        System.out.println("APPOINTMENTS SIZE: " + _appointments.size());
        req.setAttribute("appointments", _appointments);

        getServletContext().getRequestDispatcher("/doctor-service-list-jsp.jsp").forward(req, resp);


    }
}

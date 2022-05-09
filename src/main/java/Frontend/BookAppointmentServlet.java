package Frontend;

import Entities.MainFunctions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("book-appointment-servlet")
public class BookAppointmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String appointment_name = req.getParameter("appointment-name"); // Is a key
        String appointment_owner_email = req.getParameter("appointment-owner-email");

        System.out.println("Appointment Name: " + appointment_name);
        System.out.println("Appointment Owner Email: " + appointment_owner_email);

        req.setAttribute("appointment-name", appointment_name);


        MainFunctions._authedAccout.BookAppointment(appointment_owner_email,appointment_name);
        resp.getWriter().write("Appointment " + appointment_name +  " booked successfully!\n");

    }
}

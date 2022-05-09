package Frontend;

import Entities.MainFunctions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("create-appointment-servlet")
public class CreateAppointmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    public static  int called = 0;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        called++;
        System.out.println("CREATE HAS BEEN CALLED: " + called);

        String appointment_name = req.getParameter("appointment-name"); // Is a key

        if (MainFunctions._authedAccout.user != null) {
            System.out.println("Auth Doctor Username: " + MainFunctions._authedAccout.doctor.getUsername());
            System.out.println("Auth Specialization: " + MainFunctions._authedAccout.doctor.specialization);
            System.out.println("Auth Specialization: " + MainFunctions._authedAccout.user.getEmail());

            MainFunctions._authedAccout.CreateAppointment(MainFunctions._authedAccout.user.getEmail(), appointment_name);
            resp.getWriter().write("Appointment " + appointment_name +  " created successfully!\n");
        }else{
            resp.getWriter().write("Appointment " + appointment_name +  " creation failed!\n");

        }

    }
}

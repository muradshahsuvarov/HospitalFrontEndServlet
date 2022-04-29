package  Entities;
import Entities.Doctor;
import Entities.Patient;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Registration {

    public Patient patient;
    public Doctor doctor;

    public Registration() { }

    public boolean createAccount() {


        try (PrintWriter writer = new PrintWriter("users.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("Name");
            sb.append(';');
            sb.append("Surname");
            sb.append(";");
            sb.append("Username");
            sb.append(";");
            sb.append("Email");
            sb.append(";");
            sb.append("Password");
            sb.append(";");
            sb.append("Phone");
            sb.append(";");
            sb.append("Age");
            sb.append(";");
            sb.append("Gender");
            sb.append(";");
            sb.append('\n');

            sb.append("1");
            sb.append(',');
            sb.append("Prashant Ghimire");
            sb.append('\n');

            writer.write(sb.toString());

            System.out.println("Registration has been successful!");

            return true;

        } catch (FileNotFoundException e) {
            System.out.println("Registration Failed, Reason: " + e.getMessage());

            return false;
        }

    }

}

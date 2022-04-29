package DbEntities;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PaymentDbEntity extends DbEntity{

    public void CreateTable() {

        try (PrintWriter writer = new PrintWriter("payments.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("PaymentId");
            sb.append(';');
            sb.append("DateTime");
            sb.append(";");
            sb.append("PatientId");
            sb.append(";");
            sb.append("DoctorId");
            sb.append(";");
            sb.append("Amount");
            sb.append(";");
            sb.append("HospitalId");
            sb.append('\n');
            //sb.append(<User Data>)
            writer.write(sb.toString());

            System.out.println("Table has been successfully created!");


        } catch (FileNotFoundException e) {
            System.out.println("Table Creation Failed, Reason: " + e.getMessage());
        }

    }

}

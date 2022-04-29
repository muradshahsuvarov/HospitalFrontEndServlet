package DbEntities;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class BookDbEntity extends DbEntity{

    public void CreateTable(){
        try (PrintWriter writer = new PrintWriter("appointments.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("BookId");
            sb.append(';');
            sb.append("BookName");
            sb.append(';');
            sb.append("PatientId");
            sb.append(';');
            sb.append("DoctorId");
            sb.append(';');
            sb.append("IsBooked");
            sb.append(';');
            sb.append("Datetime");
            sb.append('\n');

            //sb.append(<User Data>)
            sb.append('\n');

            writer.write(sb.toString());

            System.out.println("Table has been successfully created!");


        } catch (FileNotFoundException e) {
            System.out.println("Table Creation Failed, Reason: " + e.getMessage());
        }
    }

}

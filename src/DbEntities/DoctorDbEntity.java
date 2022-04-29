package DbEntities;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DoctorDbEntity extends DbEntity{

    public void CreateTable(){
        try (PrintWriter writer = new PrintWriter("doctors.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("DoctorId");
            sb.append(';');
            sb.append("Specialization");
            sb.append(";");
            sb.append("Photo");
            sb.append(";");
            sb.append("Hospital");
            sb.append(";");
            sb.append("Service");
            sb.append(";");
            sb.append("ScheduleId");
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

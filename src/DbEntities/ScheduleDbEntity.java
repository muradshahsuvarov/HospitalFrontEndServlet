package DbEntities;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ScheduleDbEntity extends DbEntity{

    public void CreateTable() {
        try (PrintWriter writer = new PrintWriter("schedules.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("ScheduleId");
            sb.append(';');
            sb.append("DoctorId");
            sb.append(";");
            sb.append("BookId");
            sb.append('\n');
            //sb.append(<User Data>)
            writer.write(sb.toString());

            System.out.println("Table has been successfully created!");


        } catch (FileNotFoundException e) {
            System.out.println("Table Creation Failed, Reason: " + e.getMessage());
        }
    }

}

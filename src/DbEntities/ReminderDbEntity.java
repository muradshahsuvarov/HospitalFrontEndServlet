package DbEntities;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ReminderDbEntity extends  DbEntity{

    public void CreateTable() {

        try (PrintWriter writer = new PrintWriter("reminders.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("BookId");
            sb.append(';');
            sb.append("DateTime");
            sb.append(";");
            sb.append("ReminderIsEnabled");
            sb.append(";");
            sb.append("NotificationIsSent");
            sb.append('\n');
            //sb.append(<User Data>)
            writer.write(sb.toString());

            System.out.println("Table has been successfully created!");


        } catch (FileNotFoundException e) {
            System.out.println("Table Creation Failed, Reason: " + e.getMessage());
        }

    }

}

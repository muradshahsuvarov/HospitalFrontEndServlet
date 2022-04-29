package DbEntities;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FeedbackDbEntity extends DbEntity{

    public void CreateTable() {
        try (PrintWriter writer = new PrintWriter("feedbacks.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("FeedbackId");
            sb.append(';');
            sb.append("Email");
            sb.append(';');
            sb.append("Description");
            sb.append(';');
            sb.append("Datetime");
            sb.append('\n');

            writer.write(sb.toString());

            System.out.println("Table has been successfully created!");


        } catch (FileNotFoundException e) {
            System.out.println("Table Creation Failed, Reason: " + e.getMessage());
        }
    }

}

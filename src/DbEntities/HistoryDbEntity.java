package DbEntities;

import Entities.Book;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class HistoryDbEntity extends DbEntity{

    public void CreateTable() {
        try (PrintWriter writer = new PrintWriter("history.csv")) {

            StringBuilder sb = new StringBuilder();
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

package DbEntities;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PatientDbEntity extends DbEntity{

    public void CreateTable(){
        try (PrintWriter writer = new PrintWriter("patients.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("PatientId");
            sb.append(';');
            sb.append("Email");
            sb.append('\n');

            writer.write(sb.toString());

            System.out.println("Table has been successfully created!");


        } catch (FileNotFoundException e) {
            System.out.println("Table Creation Failed, Reason: " + e.getMessage());
        }
    }

}

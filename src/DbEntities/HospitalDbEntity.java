package DbEntities;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class HospitalDbEntity extends DbEntity{

    public void CreateTable() {
        try (PrintWriter writer = new PrintWriter("hospitals.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("HospitalId");
            sb.append(';');
            sb.append("HospitalName");
            sb.append(';');
            sb.append("HospitalAddress");
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

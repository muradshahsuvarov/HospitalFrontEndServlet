package DbEntities;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class UserDbEntity extends DbEntity{

    public void CreateTable(){
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
            sb.append("isDoctor");
            sb.append(";");
            sb.append("personalInfo");
            sb.append('\n');
            //sb.append(<User Data>)
            writer.write(sb.toString());

            System.out.println("Table has been successfully created!");


        } catch (FileNotFoundException e) {
            System.out.println("Table Creation Failed, Reason: " + e.getMessage());
        }
    }




}

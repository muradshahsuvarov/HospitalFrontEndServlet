package DbEntities;

import Entities.Patient;
import Entities.User;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PatientDbEntity extends DbEntity{

    List<Patient> patients;

    public PatientDbEntity() {


        patients = new ArrayList<Patient>();

        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("users.csv"));
            long row_number = 0;
            while((line = br.readLine()) != null){
                if (row_number >= 1) {

                    String[] item_row = line.split(";");
                    User row_user = new User(item_row[1],
                            item_row[2],
                            item_row[3],
                            item_row[4],
                            item_row[5],
                            item_row[6],
                            Integer.parseInt(item_row[7]),
                            item_row[8],
                            Boolean.valueOf(item_row[9]),
                            item_row[10]);

                    Patient row_patient = new Patient(row_user);

                    patients.add(row_patient);
                }
                row_number++;
            }
        }catch(Exception e) {

        }

    }

    @Override
    public void PrintData() {
        for (var item : patients) {
            item.print();
        }
    }

    public List<Patient> GetData(){
        return this.patients;
    }

    @Override
    public Boolean DeleteData(String _key) {
        try{
            User _tmpPatient = null;
            System.out.println("patients.size(): " + patients.size());
            for (var patient : patients) {
                System.out.println("Key: " + _key + ", user.email: " + patient.getEmail());
                if (patient.getEmail().equals(_key)) {
                    _tmpPatient = patient;
                    break;
                }
            }

            patients.remove(_tmpPatient);
            CreateTable();

            for (var _patient : patients) {

                StringBuilder _userAccount = new StringBuilder();

                long lineCount_users;
                try (Stream<String> stream = Files.lines(Path.of("users.csv"), StandardCharsets.UTF_8)) {
                    lineCount_users = stream.count();
                }

                _userAccount.append(lineCount_users - 1);
                _userAccount.append(";");
                _userAccount.append(_patient.getEmail());
                _userAccount.append(";");
                _userAccount.append(_patient.getPersonalInfo());


                Boolean user_registration_step = AddRow(_userAccount);


            }


            System.out.println("User " + _tmpPatient.getEmail() + " has been successfully deleted!");
            return true;
        }catch (Exception e){
            System.out.println("User deletion failed!");
            System.out.println("Reason: " + e.toString());
            return false;
        }
    }



    @Override
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



    @Override
    public Boolean AddRow(StringBuilder _row) throws IOException {

        super.AddRow(_row);

        FileWriter fw = new FileWriter("patients.csv", true);
        BufferedWriter bw = new BufferedWriter(fw);

        try (PrintWriter writer = new PrintWriter(bw)) {


            writer.println(_row.toString());

            System.out.println("Table has been successfully created!");

            writer.flush();
            return true;
        }catch(Exception e){
            return false;
        }
    }

}

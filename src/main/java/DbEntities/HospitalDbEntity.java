package DbEntities;

import Entities.Hospital;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class HospitalDbEntity extends DbEntity {

    public List<Hospital> hospitals;

    public HospitalDbEntity() {

        hospitals = new ArrayList<Hospital>();

        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("hospitals.csv"));
            long row_number = 0;
            while((line = br.readLine()) != null){
                if (row_number >= 1) {

                    String[] item_row = line.split(";");

                    Hospital row_hospital = new Hospital(
                            Integer.parseInt(item_row[0]),
                            item_row[1],
                            item_row[2]);

                    hospitals.add(row_hospital);

                }
                row_number++;
            }
        }catch(Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void PrintData() {
        for (var item : hospitals) {
            item.print();
        }
    }

    public List<Hospital> GetData(){
        return this.hospitals;
    }

    @Override
    public Boolean DeleteData(String _key) {
        try{
            Hospital _tmpHospital = null;
            System.out.println("users.size(): " + hospitals.size());
            for (var hospital : hospitals) {
                System.out.println("Key: " + _key + ", hospital.hospitalId: " + hospital.hospitalId);
                if (hospital.hospitalId.equals(_key)) {
                    _tmpHospital = hospital;
                    break;
                }
            }

            hospitals.remove(_tmpHospital);
            CreateTable();

            for (var hospital : hospitals) {

                StringBuilder hospital_sb = new StringBuilder();

                long lineCount_users;
                try (Stream<String> stream = Files.lines(Path.of("users.csv"), StandardCharsets.UTF_8)) {
                    lineCount_users = stream.count();
                }

                hospital_sb.append(lineCount_users - 1);
                hospital_sb.append(";");
                hospital_sb.append(hospital.hospitalName);
                hospital_sb.append(";");
                hospital_sb.append(hospital.hospitalAddress);

                Boolean hospital_registration_step = AddRow(hospital_sb);
            }


            System.out.println("Hospital " + _tmpHospital.hospitalName + " has been successfully deleted!");
            return true;
        }catch (Exception e){
            System.out.println("User deletion failed!");
            System.out.println("Reason: " + e.toString());
            return false;
        }
    }



    public void CreateTable() {
        try (PrintWriter writer = new PrintWriter("hospitals.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("HospitalId");
            sb.append(';');
            sb.append("HospitalName");
            sb.append(';');
            sb.append("HospitalAddress");
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

        FileWriter  fw = new FileWriter("hospitals.csv", true);
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

package DbEntities;

import Entities.Doctor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDbEntity extends DbEntity {

    List<Doctor> doctors;

    public DoctorDbEntity() {


        doctors = new ArrayList<Doctor>();

        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("doctors.csv"));
            long row_number = 0;
            while((line = br.readLine()) != null) {
                if (row_number >= 1) {

                    String[] item_row = line.split(";");


                    // Inflating the hospital object for further operations




                }
                row_number++;
            }
        }catch(Exception e) {
            System.out.println("Doctor Parse Error: " + e);
        }

    }

    public void GetHospitalFromFile(){

        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("hospitals.csv"));
            long row_number = 0;
            while((line = br.readLine()) != null) {
                if (row_number >= 1) {
                    String[] item_row = line.split(";");


                }
                row_number++;
            }
        }catch(Exception e) {
            System.out.println("Doctor Parse Error: " + e);
        }

    }

    @Override
    public void CreateTable(){
        try (PrintWriter writer = new PrintWriter("doctors.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("DoctorId");
            sb.append(';');
            sb.append("Specialization");
            sb.append(";");
            sb.append("Photo");
            sb.append(";");
            sb.append("HospitalId");
            sb.append(";");
            sb.append("ServiceID");
            sb.append(";");
            sb.append("ScheduleId");
            sb.append(";");
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

        FileWriter fw = new FileWriter("doctors.csv", true);
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

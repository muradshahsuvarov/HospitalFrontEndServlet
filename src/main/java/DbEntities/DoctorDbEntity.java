package DbEntities;

import Entities.Doctor;
import Entities.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDbEntity extends DbEntity {

    public List<Doctor> doctors;

    public DoctorDbEntity() {


        doctors = new ArrayList<Doctor>();

        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("doctors.csv"));
            long row_number = 0;
            while((line = br.readLine()) != null) {
                if (row_number >= 1) {

                    String[] item_row = line.split(";");

                    Doctor row_hospital = new Doctor(
                            item_row[1],
                            Integer.parseInt(item_row[2]),
                            Integer.parseInt(item_row[3]),
                            Integer.parseInt(item_row[4]),
                            GetUser(item_row[6]));

                    doctors.add(row_hospital);

                }
                row_number++;
            }
        }catch(Exception e) {
            System.out.println("Doctor Parse Error: " + e);
        }
    }

    public User GetUser(String _email) {

        String line = "";
        User user = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("users.csv"));
            long row_number = 0;
            while((line = br.readLine()) != null) {
                if (row_number >= 1) {

                    String[] item_row = line.split(";");

                    if (item_row[4].equals(_email)) {
                        user = new User(item_row[1],
                                item_row[2],
                                item_row[3],
                                item_row[4],
                                item_row[5],
                                item_row[6],
                                Integer.parseInt(item_row[7]),
                                item_row[8],
                                Boolean.valueOf(item_row[9]),
                                item_row[10]);

                        break;
                    }

                }
                row_number++;
            }
        }catch(Exception e) {
            System.out.println("Doctor Parse Error: " + e);
        }

        return user;
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

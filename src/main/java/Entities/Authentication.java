package Entities;

import DbEntities.DoctorDbEntity;
import DbEntities.PatientDbEntity;
import DbEntities.UserDbEntity;

import java.io.BufferedReader;
import java.io.FileReader;

public class Authentication {

    public UserDbEntity user_db;
    public DoctorDbEntity doctor_db;
    public PatientDbEntity patient_db;

    public Authentication() {

        user_db = new UserDbEntity();
        doctor_db = new DoctorDbEntity();
        patient_db = new PatientDbEntity();

    }


    public Account authenticateAccount(Account _account) {

        String line = "";
        Boolean authenticated = false;


        try {
            BufferedReader br = new BufferedReader(new FileReader("users.csv"));
            long row_number = 0;
            while((line = br.readLine()) != null){
                if (row_number >= 1) {

                    String[] item_row = line.split(";");

                    if (item_row[3].equals(_account.username) && item_row[5].equals(_account.password)) {

                        // Inflate User
                        System.out.println("Inflating user...");
                        _account.user = new User(
                                item_row[1],
                                item_row[2],
                                item_row[3],
                                item_row[4],
                                item_row[5],
                                item_row[6],
                                Integer.parseInt(item_row[7]),
                                item_row[8],
                                Boolean.valueOf(item_row[9]),
                                item_row[10]);
                        _account.user.userId = Integer.parseInt(item_row[0]);

                        if (_account.user.isDoctor) {
                            System.out.println("The user is doctor...");
                            String line_account = "";
                            BufferedReader br_doctor = new BufferedReader(new FileReader("doctors.csv"));
                            long row_number_doctor = 0;
                            while((line_account = br_doctor.readLine()) != null) {
                                if (row_number_doctor >= 1) {

                                    String[] item_row_doctor = line_account.split(";");
                                    if(item_row_doctor[6].equals(_account.user.email)){

                                        _account.doctor = new Doctor(
                                                item_row_doctor[1],
                                                Integer.parseInt(item_row_doctor[2]),
                                                Integer.parseInt(item_row_doctor[3]),
                                                Integer.parseInt(item_row_doctor[4]),
                                                _account.user);

                                        _account.doctor.doctorId = Integer.parseInt(item_row_doctor[0]);

                                        if (_account.doctor.scheduleId != null) {
                                            _account.doctor.scheduleId = Integer.parseInt(item_row_doctor[5]);
                                        }

                                        authenticated = true;
                                        System.out.println("Doctor account was filled successfully");
                                        break;
                                    }
                                }

                                row_number_doctor++;
                            }

                        }else{
                            System.out.println("The user is patient...");
                            String line_account = "";
                            BufferedReader br_patient = new BufferedReader(new FileReader("patients.csv"));
                            long row_number_patient = 0;
                            while((line_account = br_patient.readLine()) != null) {
                                if (row_number_patient >= 1) {

                                    String[] item_row_patient = line_account.split(";");
                                    if(item_row_patient[1].equals(_account.user.email)){

                                        _account.patient = new Patient(_account.user);
                                        _account.patient.patientId = Integer.parseInt(item_row_patient[0]);
                                        _account.patient.email = item_row_patient[1];

                                        authenticated = true;
                                        System.out.println("Patient account was filled successfully");
                                        break;
                                    }
                                }

                                row_number_patient++;
                            }

                        }

                        System.out.println("User account was filled successfully");
                        break;
                    }
                }
                row_number++;
            }

            if (authenticated) {
                System.out.println("Successfully authenticated!");
                _account.isAuthenticated = true;


                return _account;
            }else{
                System.out.println("Unsuccessful authentication!");
                _account.isAuthenticated = false;

                return _account;
            }
        }catch(Exception e) {
            System.out.println("Auth ERROR: " + e);
        }


        return null;
    }

}

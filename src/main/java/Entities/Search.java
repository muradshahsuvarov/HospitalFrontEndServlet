package Entities;

import DbEntities.BookDbEntity;
import DbEntities.DoctorDbEntity;
import DbEntities.HospitalDbEntity;

import java.util.ArrayList;

public class Search {

    public DoctorDbEntity doctor_db;
    public HospitalDbEntity hospital_db;
    public BookDbEntity book_db;

    public Search() { }

    public ArrayList<String> getMedicalServices(String _serviceName) {
        book_db = new BookDbEntity();
        for (var iterator_service : book_db.bookings) {
            if (iterator_service.bookName.contains(_serviceName)) {

                ArrayList<String> _searchedService =  new ArrayList<String>();
                StringBuilder sb = new StringBuilder();
                sb.append(iterator_service.bookName);
                sb.append(",");
                sb.append(iterator_service.patientEmail);
                sb.append(",");
                sb.append(iterator_service.doctorEmail);
                sb.append(",");
                sb.append(String.valueOf(iterator_service.isBooked));
                sb.append(",");
                sb.append(iterator_service.dateTime);

                _searchedService.add(sb.toString());


                System.out.print("\nSearch Results: ");
                System.out.print("\nBook Name: " + iterator_service.bookName);

                return _searchedService;
            }
        }

        return null;
    }

    public ArrayList<String> getDoctors(String _name) {
        doctor_db = new DoctorDbEntity();
        for (var iterator_doctor : doctor_db.doctors) {
            if ((iterator_doctor.name + " " + iterator_doctor.surname).contains(_name)) {

                ArrayList<String> _searchedDoctor =  new ArrayList<String>();
                StringBuilder sb = new StringBuilder();
                sb.append(iterator_doctor.email);
                sb.append(",");
                sb.append(iterator_doctor.name);
                sb.append(",");
                sb.append(iterator_doctor.surname);
                sb.append(",");
                sb.append(iterator_doctor.specialization);

                _searchedDoctor.add(sb.toString());

                System.out.println("\nSearch Results: ");
                System.out.println("\nDoctor First Name: " + iterator_doctor.name);
                System.out.println("\nDoctor Last Name: " + iterator_doctor.surname);
                System.out.println("\nDoctor Specialization: " + iterator_doctor.specialization);

                return _searchedDoctor;
            }
        }

        return null;
    }


    public ArrayList<String> getHospitals(String _hospitalName) {
        for (var iterator_hospital : hospital_db.hospitals) {
            if (iterator_hospital.hospitalName.contains(_hospitalName)) {

                ArrayList<String> _searchedHospital =  new ArrayList<String>();
                StringBuilder sb = new StringBuilder();
                sb.append(iterator_hospital.hospitalName);
                sb.append(",");
                sb.append(iterator_hospital.hospitalAddress);

                _searchedHospital.add(sb.toString());


                System.out.println("\nSearch Results: ");
                System.out.println("\nHospital Name: " + iterator_hospital.hospitalName);
                System.out.println("\nHospital Address: " + iterator_hospital.hospitalAddress);
            }
        }

        return null;
    }
}

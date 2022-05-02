package Entities;

import DbEntities.DoctorDbEntity;
import DbEntities.HospitalDbEntity;
import DbEntities.ServiceDbEntity;

public class Search {

    public DoctorDbEntity doctor_db;
    public HospitalDbEntity hospital_db;
    public ServiceDbEntity service_db;

    public Search() { }

    public void getMedicalService(String _serviceName) {

        for (var iterator_service : service_db.services) {
            if (iterator_service.serviceName.contains(_serviceName) || iterator_service.serviceDescription.contains(_serviceName)) {
                System.out.print("\nSearch Results: ");
                System.out.print("\nService Name: " + iterator_service.serviceName);
                System.out.print("\nService Description: " + iterator_service.serviceDescription);
                System.out.print("\nService Price: " + iterator_service.price);
                System.out.print("\nService Currency: " + iterator_service.currency);

                break;
            }
        }
    }

    public void getDoctor(String _name) {
        for (var iterator_doctor : doctor_db.doctors) {
            if ((iterator_doctor.name + " " + iterator_doctor.surname).contains(_name)) {
                System.out.println("\nSearch Results: ");
                System.out.println("\nDoctor First Name: " + iterator_doctor.name);
                System.out.println("\nDoctor Last Name: " + iterator_doctor.surname);
                System.out.println("\nDoctor Specialization: " + iterator_doctor.specialization);

                break;
            }
        }
    }


    public void getHospital(String _hospitalName) {
        for (var iterator_hospital : hospital_db.hospitals) {
            if (iterator_hospital.hospitalName.contains(_hospitalName)) {
                System.out.println("\nSearch Results: ");
                System.out.println("\nHospital Name: " + iterator_hospital.hospitalName);
                System.out.println("\nHospital Address: " + iterator_hospital.hospitalAddress);
            }
        }
    }
}

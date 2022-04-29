package Entities;

import DbEntities.*;
import Entities.Doctor;
import Entities.Hospital;

public class Search {

    public DoctorDbEntity doctorDbEntity;
    public HospitalDbEntity hospitalDbEntity;

    public Search() { }

    public void getMedicalService(String _serviceName) {
        // TODO: Find the service based on the name
    }

    public void getHospital(String _hospitalName) {
        // TODO: Get hospitals based on the name. Note: one-to-many
    }
}

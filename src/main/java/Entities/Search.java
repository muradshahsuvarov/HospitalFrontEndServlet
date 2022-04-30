package Entities;

import DbEntities.DoctorDbEntity;
import DbEntities.HospitalDbEntity;

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

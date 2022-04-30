package Entities;

import DbEntities.DoctorDbEntity;
import DbEntities.PatientDbEntity;
import DbEntities.UserDbEntity;

public class Authentication {

    public UserDbEntity user_db;
    public DoctorDbEntity doctor_db;
    public PatientDbEntity patient_db;

    public Authentication() {

        user_db = new UserDbEntity();
        doctor_db = new DoctorDbEntity();
        patient_db = new PatientDbEntity();

    }


    public Boolean authenticateAccount(Account _account) {
        return false;
    }

}

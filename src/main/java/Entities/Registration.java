package  Entities;

import DbEntities.DoctorDbEntity;
import DbEntities.PatientDbEntity;
import DbEntities.UserDbEntity;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Registration {

    public Patient patient;
    public Doctor doctor;

    public UserDbEntity user_db;
    public DoctorDbEntity doctor_db;
    public PatientDbEntity patient_db;

    public Registration() {
        user_db = new UserDbEntity();
        doctor_db = new DoctorDbEntity();
        patient_db = new PatientDbEntity();
    }

    public boolean createUserAccount(User _user) throws IOException {

        StringBuilder _userAccount = new StringBuilder();

        long lineCount_users;
        try (Stream<String> stream = Files.lines(Path.of("users.csv"), StandardCharsets.UTF_8)) {
            lineCount_users = stream.count();
        }

        _userAccount.append(lineCount_users - 1);
        _userAccount.append(";");
        _userAccount.append(_user.name);
        _userAccount.append(";");
        _userAccount.append(_user.surname);
        _userAccount.append(";");
        _userAccount.append(_user.username);
        _userAccount.append(";");
        _userAccount.append(_user.email);
        _userAccount.append(";");
        _userAccount.append(_user.password);
        _userAccount.append(";");
        _userAccount.append(_user.phone);
        _userAccount.append(";");
        _userAccount.append(_user.age);
        _userAccount.append(";");
        _userAccount.append(_user.gender);
        _userAccount.append(";");
        _userAccount.append(_user.isDoctor);
        _userAccount.append(";");
        _userAccount.append(_user.personalInfo);

        return user_db.AddRow(_userAccount);
    }

    public boolean createDoctorAccount(Doctor _doctor) throws IOException {

        StringBuilder _doctorAccount = new StringBuilder();

        long lineCount_users;
        try (Stream<String> stream = Files.lines(Path.of("doctors.csv"), StandardCharsets.UTF_8)) {
            lineCount_users = stream.count();
        }

        _doctorAccount.append(lineCount_users - 1);
        _doctorAccount.append(";");
        _doctorAccount.append(_doctor.specialization);
        _doctorAccount.append(";");
        _doctorAccount.append(_doctor.photo);
        _doctorAccount.append(";");
        _doctorAccount.append(_doctor.hospital.hospitalId);
        _doctorAccount.append(";");
        _doctorAccount.append(_doctor.service.serviceId);
        _doctorAccount.append(";");
        _doctorAccount.append(_doctor.schedule.scheduleId);
        _doctorAccount.append(";");
        _doctorAccount.append(_doctor.email);

        return doctor_db.AddRow(_doctorAccount);
    }


    public boolean createPatientAccount(Patient _patient) throws IOException {

        StringBuilder _patientAccount = new StringBuilder();

        long lineCount_users;
        try (Stream<String> stream = Files.lines(Path.of("patients.csv"), StandardCharsets.UTF_8)) {
            lineCount_users = stream.count();
        }

        _patientAccount.append(lineCount_users - 1);
        _patientAccount.append(";");
        _patientAccount.append(_patient.getEmail());

        return patient_db.AddRow(_patientAccount);
    }

}
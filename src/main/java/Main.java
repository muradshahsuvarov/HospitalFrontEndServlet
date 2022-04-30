import DbEntities.*;
import Entities.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        GenerateTables();
        //RegisterAccount(true);
        //DeleteUser("surikshahsuvarov@gmail.com");
        //DeletePatient("surikshahsuvarov@gmail.com");

    }

    public static void RegisterAccount(@NotNull Boolean _isDoctor) throws IOException {

        Registration _registration = new Registration();

        User user_1 = new User(
                "Surkhay",
                "Shahsuvarov",
                "surkayshahsuvarov@gmail.com",
                "surkayshahsuvarov@gmail.com",
                "admin123",
                "+994517773924",
                23,
                "Male",
                true,
                "Hello, I am a patient");

        if (_isDoctor) {

            Hospital hospital_1 = new Hospital(0,"Saint Louis Hospital", "Saint Louis");
            StringBuilder hospital_1_sb = new StringBuilder();
            hospital_1_sb.append(hospital_1.hospitalId);
            hospital_1_sb.append(";");
            hospital_1_sb.append(hospital_1.hospitalName);
            hospital_1_sb.append(";");
            hospital_1_sb.append(hospital_1.hospitalAddress);

            HospitalDbEntity hospital_db = new HospitalDbEntity();
            hospital_db.AddRow(hospital_1_sb);

            Service service_1 = new Service(
                    0,
                    "Cardio Treatments",
                    "Treatment of cardiovascular systems",
                    200,
                    "USD"
            );

            Doctor doctor_1 = new Doctor("Cardiologist",
                    234534,
                    hospital_1,
                    service_1,
                    user_1);
            Schedule schedule_1 = new Schedule(1);

            doctor_1.schedule = schedule_1;

            service_1.email = doctor_1.getEmail();

            ServiceDbEntity service_db = new ServiceDbEntity();

            StringBuilder service_1_sb = new StringBuilder();
            service_1_sb.append(service_1.serviceId);
            service_1_sb.append(";");
            service_1_sb.append(doctor_1.getEmail());
            service_1_sb.append(";");
            service_1_sb.append(service_1.serviceName);
            service_1_sb.append(";");
            service_1_sb.append(service_1.serviceDescription);
            service_1_sb.append(";");
            service_1_sb.append(service_1.price);
            service_1_sb.append(";");
            service_1_sb.append(service_1.currency);

            service_db.AddRow(service_1_sb);

            Boolean registration_user_status = _registration.createUserAccount(user_1);
            Boolean registration_doctor_status = _registration.createDoctorAccount(doctor_1);

            if (!registration_user_status || !registration_doctor_status)
                System.out.println("Registration was not successful!");
            else
                System.out.println("Registration was successful!");

        }else {

            Patient patient_1 = new Patient(user_1);

             Boolean registration_user_status = _registration.createUserAccount(user_1);
             Boolean registration_patient_status = _registration.createPatientAccount(patient_1);

            if (!registration_user_status || !registration_patient_status)
                System.out.println("Registration was not successful!");
            else
                System.out.println("Registration was successful!");

        }

    }

    public static void Authenticate() {

    }

    public static void DeleteUser(String _key){
        UserDbEntity user_db = new UserDbEntity();
        user_db.DeleteData(_key);
    }

    public static void DeleteDoctor(String _key) {
        DoctorDbEntity doctor_db = new DoctorDbEntity();
        doctor_db.DeleteData(_key);
    }

    public static void DeletePatient(String _key) {
        PatientDbEntity patient_db = new PatientDbEntity();
        patient_db.DeleteData(_key);
    }

    public static void GenerateTables(){

        BookDbEntity book_db = new BookDbEntity();
        DoctorDbEntity doctor_db = new DoctorDbEntity();
        FeedbackDbEntity feedback_db = new FeedbackDbEntity();
        HistoryDbEntity history_db = new HistoryDbEntity();
        PatientDbEntity patient_db = new PatientDbEntity();
        PaymentDbEntity payment_db = new PaymentDbEntity();
        ReminderDbEntity reminder_db = new ReminderDbEntity();
        ScheduleDbEntity schedule_db = new ScheduleDbEntity();
        UserDbEntity user_db = new UserDbEntity();
        ServiceDbEntity service_db = new ServiceDbEntity();
        HospitalDbEntity hospital_db = new HospitalDbEntity();

        List<DbEntity> dbEntityList = new ArrayList<DbEntity>();

        dbEntityList.add(book_db);
        dbEntityList.add(doctor_db);
        dbEntityList.add(feedback_db);
        dbEntityList.add(history_db);
        dbEntityList.add(patient_db);
        dbEntityList.add(payment_db);
        dbEntityList.add(reminder_db);
        dbEntityList.add(schedule_db);
        dbEntityList.add(user_db);
        dbEntityList.add(service_db);
        dbEntityList.add(hospital_db);

        for (var item : dbEntityList) {
            item.CreateTable();
        }

    }

}

import DbEntities.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        GenerateTables();
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


        for (var item : dbEntityList) {
            item.CreateTable();
        }

    }

}

package Entities;

import DbEntities.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.stream.Stream;

public class Account {

    public String username;
    public String password;
    public Boolean isAuthenticated;

    public User user;
    public Doctor doctor;
    public Patient patient;

    public DoctorDbEntity doctor_db;
    public ServiceDbEntity service_db;
    public ScheduleDbEntity schedule_db;
    public BookDbEntity book_db;
    public HistoryDbEntity historyDbEntity;

    public Account(String _username, String _password) {
        this.username = _username;
        this.password = _password;
    }


    public void AddToHistory(String _description) throws IOException {

        historyDbEntity = new HistoryDbEntity();
        StringBuilder history_sb = new StringBuilder();

        long lineCount_history;
        try (Stream<String> stream = Files.lines(Path.of("history.csv"), StandardCharsets.UTF_8)) {
            lineCount_history = stream.count();
        }

        history_sb.append(lineCount_history);
        history_sb.append(this.username);
        history_sb.append(_description);
        history_sb.append(LocalDateTime.now());
        historyDbEntity.AddRow(history_sb);

    }
    public void SearchDoctor(String _key) throws IOException {
        if (isAuthenticated) {

            System.out.println("Doctor Set Size: " + doctor_db.doctors.size());
            System.out.println("Service Set Size: " + service_db.services.size());

            Search _search = new Search();
            _search.getDoctor(_key);
            _search.getMedicalService(_key);

            AddToHistory("Doctor " + _key + " is being searched...");
        }
    }

    // Using doctor
    public void SearchHospital(String _key) throws IOException {
        if (isAuthenticated) {

            System.out.println("Doctor Set Size: " + doctor_db.doctors.size());
            System.out.println("Service Set Size: " + service_db.services.size());

            Search _search = new Search();
            _search.getHospital(_key);

            AddToHistory("Hospital " + _key + " is being searched...");
        }
    }

    public void BookAppointment(String _ownerEmail, String _bookName) throws IOException {


        if (this.isAuthenticated && doctor == null && patient != null) {

            book_db = new BookDbEntity();
            schedule_db = new ScheduleDbEntity();

            Boolean updateScheduleDb = false;

            for (var iterator_booking : book_db.bookings) {
                if (iterator_booking.doctorEmail.contains(_ownerEmail) && iterator_booking.bookName.contains(_bookName)) {
                    System.out.println("Book " + _bookName + " exists!");

                    iterator_booking.patientEmail = username;
                    iterator_booking.isBooked = true;
                    updateScheduleDb = true;
                    System.out.println("Appointment " + _bookName + " has been successfully booked!");
                    AddToHistory("Appointment " + _bookName + " has been successfully booked!");
                    break;
                }
            }

            if (updateScheduleDb == true) {

                book_db.CreateTable();

                for (var iterator_booking : book_db.bookings) {

                    StringBuilder book_sb = new StringBuilder();
                    book_sb.append(iterator_booking.bookId);
                    book_sb.append(";");
                    book_sb.append(iterator_booking.bookName);
                    book_sb.append(";");
                    book_sb.append(iterator_booking.patientEmail);
                    book_sb.append(";");
                    book_sb.append(iterator_booking.doctorEmail);
                    book_sb.append(";");
                    book_sb.append(iterator_booking.isBooked);
                    book_sb.append(";");
                    book_sb.append(iterator_booking.dateTime);

                    book_db.AddRow(book_sb);
                }

            }

        }

    }

    public void CancelAppointment(String _bookName) throws IOException {

        AddToHistory("Appointment " + _bookName + " has been successfully cancelled!");

    }

    public void CreateSchedule() throws IOException {

        if (this.isAuthenticated && doctor != null && patient == null) {

            long lineCount;
            try (Stream<String> stream = Files.lines(Path.of("schedules.csv"), StandardCharsets.UTF_8)) {
                lineCount = stream.count();
            }


            ScheduleDbEntity schedule_db = new ScheduleDbEntity();
            StringBuilder schedule_sb = new StringBuilder();
            schedule_sb.append((int)lineCount - 1);
            schedule_sb.append(";");
            schedule_sb.append(doctor.email);
            schedule_db.AddRow(schedule_sb);

            AddToHistory("Schedule with Id = " + ((int)lineCount - 1) + " has been successfully created!");
        }

    }

    public void CreateAppointment(String _ownerEmail, String _bookName) throws IOException {

        if (this.isAuthenticated && doctor != null && patient == null) {

            schedule_db = new ScheduleDbEntity();

            for (var iterator_schedule : schedule_db.schedules) {
                if (iterator_schedule.ownerEmail.contains(_ownerEmail)) {
                    System.out.println("Schedule " + _ownerEmail + " exists!");
                    book_db = new BookDbEntity();
                    long lineCount;
                    try (Stream<String> stream = Files.lines(Path.of("medical_treatment_bookings.csv"), StandardCharsets.UTF_8)) {
                        lineCount = stream.count();
                    }
                    StringBuilder book_sb = new StringBuilder();
                    book_sb.append(lineCount);
                    book_sb.append(";");
                    book_sb.append(_bookName);
                    book_sb.append(";");
                    book_sb.append("null");
                    book_sb.append(";");
                    book_sb.append(doctor.email);
                    book_sb.append(";");
                    book_sb.append(false);
                    book_sb.append(";");
                    book_sb.append(LocalDateTime.now());
                    book_db.AddRow(book_sb);

                    System.out.println("Book " + _bookName + " has been successfully added!");
                    AddToHistory("Book " + _bookName + " has been successfully added!");
                }
            }
        }
    }

    public void DeleteSchedule() throws IOException {
        AddToHistory("Schedule has been successfully deleted!");
    }
}

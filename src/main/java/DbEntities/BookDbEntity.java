package DbEntities;

import Entities.Book;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BookDbEntity extends DbEntity {

    List<Book> bookings;


    public BookDbEntity(){

        bookings = new ArrayList<Book>();

        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("medical_treatment_bookings.csv"));
            long row_number = 0;
            while((line = br.readLine()) != null){
                if (row_number >= 1) {

                    String[] item_row = line.split(";");
                    Book row_book = new Book(
                            Integer.parseInt(item_row[0]),
                            item_row[2],
                            item_row[3],
                            item_row[4],
                            Boolean.valueOf(item_row[5]),
                            LocalDateTime.parse(item_row[6],DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

                    bookings.add(row_book);
                }
                row_number++;
            }
        }catch(Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void PrintData() {
        for (var item : bookings) {
            item.print();
        }
    }

    public List<Book> GetData(){
        return this.bookings;
    }

    @Override
    public Boolean DeleteData(String _key) {
        try{
            Book _tmpBooking = null;
            System.out.println("bookings.size(): " + bookings.size());
            for (var booking : bookings) {
                System.out.println("Key: " + _key + ", booking.bookId: " + booking.bookId);
                if (booking.bookId == Integer.parseInt(_key)) {
                    _tmpBooking = booking;
                    break;
                }
            }

            bookings.remove(_tmpBooking);
            CreateTable();

            for (var booking : bookings) {

                StringBuilder bookins_sb = new StringBuilder();

                long lineCount_users;
                try (Stream<String> stream = Files.lines(Path.of("medical_treatment_bookings.csv"), StandardCharsets.UTF_8)) {
                    lineCount_users = stream.count();
                }

                bookins_sb.append(lineCount_users - 1);
                bookins_sb.append(";");
                bookins_sb.append(booking.bookName);
                bookins_sb.append(";");
                bookins_sb.append("" + booking.patientEmail);
                bookins_sb.append(";");
                bookins_sb.append("" + booking.doctorEmail);
                bookins_sb.append(";");
                bookins_sb.append("" + booking.isBooked);
                bookins_sb.append(";");
                bookins_sb.append("" + booking.dateTime);

                Boolean booking_registration_step = AddRow(bookins_sb);
            }


            System.out.println("Hospital " + _tmpBooking.bookName + " has been successfully deleted!");
            return true;
        }catch (Exception e){
            System.out.println("User deletion failed!");
            System.out.println("Reason: " + e.toString());
            return false;
        }
    }

    public void CreateTable(){
        try (PrintWriter writer = new PrintWriter("medical_treatment_bookings.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("BookId");
            sb.append(';');
            sb.append("BookName");
            sb.append(';');
            sb.append("PatientEmail");
            sb.append(';');
            sb.append("DoctorEmail");
            sb.append(';');
            sb.append("IsBooked");
            sb.append(';');
            sb.append("Datetime");
            sb.append('\n');

            writer.write(sb.toString());

            System.out.println("Table has been successfully created!");


        } catch (FileNotFoundException e) {
            System.out.println("Table Creation Failed, Reason: " + e.getMessage());
        }
    }


    @Override
    public Boolean AddRow(StringBuilder _row) throws IOException {

        super.AddRow(_row);

        FileWriter  fw = new FileWriter("medical_treatment_bookings.csv", true);
        BufferedWriter bw = new BufferedWriter(fw);

        try (PrintWriter writer = new PrintWriter(bw)) {


            writer.println(_row.toString());

            System.out.println("Table has been successfully created!");

            writer.flush();
            return true;
        }catch(Exception e){
            return false;
        }
    }

}

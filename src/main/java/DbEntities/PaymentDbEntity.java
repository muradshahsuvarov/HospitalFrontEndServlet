package DbEntities;

import Entities.Payment;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PaymentDbEntity extends DbEntity{

    List<Payment> payments;

    public PaymentDbEntity() {

        payments = new ArrayList<Payment>();


        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("payments.csv"));
            long row_number = 0;
            while((line = br.readLine()) != null){
                if (row_number >= 1) {

                    String[] item_row = line.split(";");

                    Payment row_payments = new Payment(
                            Integer.parseInt(item_row[0]),
                            Integer.parseInt(item_row[1]),
                            Integer.parseInt(item_row[2]),
                            Integer.parseInt(item_row[3]),
                            Integer.parseInt(item_row[4]),
                            LocalDateTime.parse(item_row[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

                    payments.add(row_payments);

                }
                row_number++;
            }
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void PrintData() {
        for (var item : payments) {
            item.print();
        }
    }

    public List<Payment> GetData(){
        return this.payments;
    }

    @Override
    public Boolean DeleteData(String _key) {
        try{
            Payment _tmpPayment = null;
            System.out.println("payments.size(): " + payments.size());
            for (var payment : payments) {
                System.out.println("Key: " + _key + ", payment.hospitalId: " + payment.paymentId);
                if (payment.paymentId == Integer.parseInt(_key)) {
                    _tmpPayment = payment;
                    break;
                }
            }

            payments.remove(_tmpPayment);
            CreateTable();

            for (var payment : payments) {

                StringBuilder payment_sb = new StringBuilder();

                long lineCount_users;
                try (Stream<String> stream = Files.lines(Path.of("payments.csv"), StandardCharsets.UTF_8)) {
                    lineCount_users = stream.count();
                }

                payment_sb.append(lineCount_users - 1);
                payment_sb.append(';');
                payment_sb.append(payment.paymentId);
                payment_sb.append(";");
                payment_sb.append(payment.doctorId);
                payment_sb.append(";");
                payment_sb.append(payment.amount);
                payment_sb.append(";");
                payment_sb.append(payment.hospitalId);

                Boolean payment_registration_step = AddRow(payment_sb);
            }


            System.out.println("Payment " + _tmpPayment.paymentId + " has been successfully deleted!");
            return true;
        }catch (Exception e){
            System.out.println("User deletion failed!");
            System.out.println("Reason: " + e.toString());
            return false;
        }
    }

    public void CreateTable() {

        try (PrintWriter writer = new PrintWriter("payments.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("PaymentId");
            sb.append(';');
            sb.append("PatientId");
            sb.append(";");
            sb.append("DoctorId");
            sb.append(";");
            sb.append("Amount");
            sb.append(";");
            sb.append("HospitalId");
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

        FileWriter  fw = new FileWriter("payments.csv", true);
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

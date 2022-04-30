package DbEntities;

import Entities.Feedback;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FeedbackDbEntity extends DbEntity{

    List<Feedback> feedbacks;

    public FeedbackDbEntity() {

        feedbacks = new ArrayList<Feedback>();

        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("feedbacks.csv"));
            long row_number = 0;
            while((line = br.readLine()) != null){
                if (row_number >= 1) {

                    String[] item_row = line.split(";");

                    Feedback row_feedback = new Feedback(
                            Integer.parseInt(item_row[0]),
                            Integer.parseInt(item_row[1]),
                            Integer.parseInt(item_row[2]),
                            item_row[3],
                            LocalDateTime.parse(item_row[4], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                            );

                    feedbacks.add(row_feedback);

                }
                row_number++;
            }
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void PrintData() {
        for (var item : feedbacks) {
            item.print();
        }
    }

    public List<Feedback> GetData(){
        return this.feedbacks;
    }


    @Override
    public Boolean DeleteData(String _key) {
        try{
            Feedback _tmpFeedback = null;
            System.out.println("feedbacks.size(): " + feedbacks.size());
            for (var hospital : feedbacks) {
                System.out.println("Key: " + _key + ", feedback.feedbackId: " + hospital.feedbackId);
                if (hospital.feedbackId.equals(_key)) {
                    _tmpFeedback = hospital;
                    break;
                }
            }

            feedbacks.remove(_tmpFeedback);
            CreateTable();

            for (var feedback : feedbacks) {

                StringBuilder feedback_sb = new StringBuilder();

                long lineCount_users;
                try (Stream<String> stream = Files.lines(Path.of("feedbacks.csv"), StandardCharsets.UTF_8)) {
                    lineCount_users = stream.count();
                }

                feedback_sb.append(lineCount_users - 1);
                feedback_sb.append(";");
                feedback_sb.append(feedback.patientId);
                feedback_sb.append(";");
                feedback_sb.append(feedback.doctorId);
                feedback_sb.append(";");
                feedback_sb.append(feedback.description);
                feedback_sb.append(";");
                feedback_sb.append(feedback.dateTime);

                Boolean feedback_registration_step = AddRow(feedback_sb);
            }


            System.out.println("Hospital " + _tmpFeedback.feedbackId + " has been successfully deleted!");
            return true;
        }catch (Exception e){
            System.out.println("Feedback deletion failed!");
            System.out.println("Reason: " + e.toString());
            return false;
        }
    }

    public void CreateTable() {
        try (PrintWriter writer = new PrintWriter("feedbacks.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("FeedbackId");
            sb.append(';');
            sb.append("PatientId");
            sb.append(';');
            sb.append("DoctorID");
            sb.append(';');
            sb.append("Description");
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

        FileWriter  fw = new FileWriter("feedbacks.csv", true);
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

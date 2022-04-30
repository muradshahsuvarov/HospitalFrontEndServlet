package DbEntities;

import Entities.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ServiceDbEntity extends  DbEntity{

    List<Service> services;

    public ServiceDbEntity() {

        services = new ArrayList<Service>();

    }

    @Override
    public void PrintData() {
        for (var item : services) {
            item.print();
        }
    }

    public List<Service> GetData(){
        return this.services;
    }



    @Override
    public Boolean DeleteData(String _key) {
        try{
            Service _tmpService = null;
            System.out.println("services.size(): " + services.size());
            for (var service : services) {
                System.out.println("Key: " + _key + ", user.email: " + service.email);
                if (service.email.equals(_key)) {
                    _tmpService = service;
                    break;
                }
            }

            services.remove(_tmpService);
            CreateTable();

            for (var _service : services) {

                StringBuilder service_sb = new StringBuilder();

                long lineCount_users;
                try (Stream<String> stream = Files.lines(Path.of("users.csv"), StandardCharsets.UTF_8)) {
                    lineCount_users = stream.count();
                }

                service_sb.append(lineCount_users - 1);
                service_sb.append(";");
                service_sb.append(_service.serviceId);
                service_sb.append(";");
                service_sb.append(_service.email);
                service_sb.append(";");
                service_sb.append(_service.serviceName);
                service_sb.append(";");
                service_sb.append(_service.serviceDescription);
                service_sb.append(";");
                service_sb.append(_service.price);
                service_sb.append(";");
                service_sb.append(_service.currency);

                Boolean service_registration_step = AddRow(service_sb);


            }


            System.out.println("User " + _tmpService.email + " has been successfully deleted!");
            return true;
        }catch (Exception e){
            System.out.println("User deletion failed!");
            System.out.println("Reason: " + e.toString());
            return false;
        }
    }


    @Override
    public void CreateTable(){
        super.CreateTable();
        try (PrintWriter writer = new PrintWriter("services.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("ServiceId");
            sb.append(';');
            sb.append("Email");
            sb.append(";");
            sb.append("ServiceName");
            sb.append(";");
            sb.append("ServiceDescription");
            sb.append(";");
            sb.append("Price");
            sb.append(";");
            sb.append("Currency");
            sb.append('\n');
            writer.write(sb.toString());

            System.out.println("Table has been successfully created!");

            writer.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Table Creation Failed, Reason: " + e.getMessage());
        }
    }


    @Override
    public Boolean AddRow(StringBuilder _row) throws IOException {

        super.AddRow(_row);

        FileWriter fw = new FileWriter("services.csv", true);
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

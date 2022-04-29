package Entities;

import java.util.List;

public class Service {

    public Integer serviceId;
    public String serviceName;
    public List<String> serviceTags;
    public String serviceDescription;
    public Integer price;

    public Service() { }

    public void viewPrice() { }
    public Integer getPrice() { return this.price; }
    public void setPrice(Integer _price) { this.price = _price; }
}

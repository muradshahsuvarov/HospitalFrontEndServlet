package Entities;

public class Service {

    public String email;
    public Integer serviceId;
    public String serviceName;
    public String serviceDescription;
    public Integer price;
    public String currency;

    public Service(Integer _serviceId,
                   String _serviceName,
                   String _serviceDescription,
                   Integer _price,
                   String _currency) {

        this.serviceId = _serviceId;
        this.serviceName = _serviceName;
        this.serviceDescription = _serviceDescription;
        this.price = _price;
        this.currency = _currency;

    }

    public void viewPrice() { }
    public Integer getPrice() { return this.price; }
    public void setPrice(Integer _price) { this.price = _price; }


    public void print() {

        StringBuilder sb = new StringBuilder();
        sb.append(this.email);
        sb.append(this.serviceId);
        sb.append(this.serviceName);
        sb.append(this.serviceDescription);
        sb.append(this.price);
        sb.append(this.currency);

        System.out.println(sb);
    }


}

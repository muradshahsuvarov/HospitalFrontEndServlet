package Entities;

public class Doctor extends User {

    public Integer doctorId;
    public String specialization;
    public Integer photo;
    public Hospital hospital;
    public Service service;
    public Schedule schedule;

    public Doctor(){ }

    public void viewAppointment(){ }

    public Integer getDoctorId() { return this.doctorId; }

    public String getSpecialization() { return this.specialization; }

    public Integer getPhoto() { return this.photo; }

    public Hospital getHospital() { return this.hospital; }

    public Service getService() { return this.service; }

    public Schedule getSchedule() { return this.schedule; }

    public void setDoctorId(Integer _doctorId) { this.doctorId = _doctorId; }

    public void setSpecialization(String _specialization) { this.specialization = _specialization; }

    public void setService(Service _service) { this.service = _service;}

    public void setPhoto(Integer _photo){ this.photo = _photo; }

    public void setHospital(Hospital _hospital) {this.hospital = _hospital; }

    public void setSchedule(Schedule _schedule) { this.schedule = _schedule;}

}

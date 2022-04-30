package Entities;

public class Doctor extends User {

    public Integer doctorId;
    public String specialization;
    public Integer photo;
    public Integer hospitalId;
    public Integer serviceId;
    public Integer scheduleId;


    public Doctor( String _specialization,
                   Integer _photo,
                   Integer _hospitalId,
                   Integer _serviceId,
                   User _user) {

        super (
                _user.getName(),
                _user.getSurname(),
                _user.getUsername(),
                _user.getEmail(),
                _user.getPassword(),
                _user.getPhone(),
                _user.getAge(),
                _user.getGender(),
                _user.getIsDoctor(),
                _user.getPersonalInfo()
        );

        this.specialization = _specialization;
        this.photo = _photo;
        this.hospitalId = _hospitalId;
        this.serviceId = _serviceId;

    }

    public void viewAppointments() { }

    public Integer getDoctorId() { return this.doctorId; }

    public String getSpecialization() { return this.specialization; }

    public Integer getPhoto() { return this.photo; }

    public Integer getHospitalId() { return this.hospitalId; }

    public Integer getService() { return this.serviceId; }

    public Integer getSchedule() { return this.scheduleId; }

    public void setDoctorId(Integer _doctorId) { this.doctorId = _doctorId; }

    public void setSpecialization(String _specialization) { this.specialization = _specialization; }

    public void setService(Integer _serviceId) { this.serviceId = _serviceId;}

    public void setPhoto(Integer _photo){ this.photo = _photo; }

    public void setHospitalId(Integer _hospitalId) {this.hospitalId = _hospitalId; }

    public void setScheduleId(Integer _scheduleId) { this.scheduleId = _scheduleId;}

}

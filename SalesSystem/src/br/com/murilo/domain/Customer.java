package br.com.murilo.domain;

public class Customer {
    private  String name;
    private Long cpf;
    private Long phoneNumber;
    private String address;
    private Integer number;
    private String city;
    private String state;

    public Customer(String name, Long cpf, Long phoneNumber, String address, Integer number, String city, String state) {
        this.name = name;
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.number = number;
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

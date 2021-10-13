package model;

import java.io.Serializable;

public class Customer implements Serializable {
    private String fullName;
    private String address;
    private String idCode;

    public Customer() {
    }

    public Customer(String fullName, String address, String idCode) {
        this.fullName = fullName;
        this.address = address;
        this.idCode = idCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", idCode='" + idCode + '\'' +
                '}';
    }
}

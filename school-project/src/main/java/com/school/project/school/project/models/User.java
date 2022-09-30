package com.school.project.school.project.models;

public class User {
    private Integer id;
    private String name;
    private String surname;
    private String cnp;
    private String address;
    private String email;
//    private SchoolRole role;

    public User(){
        this.id = 1;
        this.name = "Alexandru";
        this.surname = "Soare";
        this.cnp = "123123123";
        this.address = "The Street";
        this.email = "email@email.com";
    //    this.role = SchoolRole.Admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cnp='" + cnp + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

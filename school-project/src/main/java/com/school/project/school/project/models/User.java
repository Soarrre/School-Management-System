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

}

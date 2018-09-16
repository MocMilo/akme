package org.prezydium.caching.model;


import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "SALARY")
    private int salary;

    @Column(name = "GENDER")
    private Gender gender;



}

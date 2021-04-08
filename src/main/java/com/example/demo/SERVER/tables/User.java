package com.example.demo.SERVER.tables;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    public User(String login, String surname, String name, String father_name, LocalDate birthday){
        this.login = login;
        this.surname=surname;
        this.name=name;
        this.father_name=father_name;
        this.birthday = birthday;
        }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String login;

    @Column
    private String surname;

    @Column
    private String name;

    @Column
    private String father_name;

    @Column
    private LocalDate birthday;

    @CreatedDate
    @Column
    private LocalDate created;

    @LastModifiedDate
    @Column
    private LocalDate updated;

    public User(){}

    public Long getId() {
        return id;
        }

    public String getLogin() {
        return login;
        }

    public String getSurname() {
        return surname;
        }

    public String getName() {
        return name;
        }

    public String getFather_name() {
        return father_name;
        }

    public LocalDate getBirthday() {
        return birthday;
        }

    public LocalDate getCreated() {
        return created;
        }

    public LocalDate getUpdated() {
        return updated;
        }


    public void setId(Long id) {
        this.id = id;
        }

    public void setLogin(String login) {
        this.login = login;
        }

    public void setSurname(String surname) {
        this.surname = surname;
        }

    public void setName(String name) {
        this.name = name;
        }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
        }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        }

    public void setCreated(LocalDate created) {
        this.created = created;
        }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
        }


    @Override
    public String toString() {
        return "User{" +
        "ID=" + id +
        ", Login='" + login + '\'' +
        ", Surname='" + surname + '\'' +
        ", Name='" + name + '\'' +
        ", Father name='" + father_name + '\'' +
        ", Birthday=" + birthday +
        '}';
        }
}
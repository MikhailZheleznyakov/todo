package com.example.demo.SERVER.tables;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "tasks")
public class Task {
    public Task(String name, String description, String success){
        this.name=name;
        this.description=description;
        this.success=success;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "taskid")
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private LocalDate deadline;

    @Column
    private String success;


    @CreatedDate
    @Column
    private LocalDate created;

    @LastModifiedDate
    @Column
    private LocalDate updated;

    public Task(){}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "category_like",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> category;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getSuccess() {
        return success;
    }

    public LocalDate getCreated() {
        return created;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public User getUser() {
        return user;
    }

    public Set<Category> getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", success='" + success + '\'' +
                '}';
    }
}

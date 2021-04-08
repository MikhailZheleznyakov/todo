package com.example.demo.SERVER.tables;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category{
    public Category(String name){
        this.name = name;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "categoryid")
    private Long id;

    @Column
    private String name;

    @CreatedDate
    @Column
    private LocalDate created;

    @LastModifiedDate
    @Column
    private LocalDate updated;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    public Category(){}

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "task_like",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private Set<Task> tasks;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

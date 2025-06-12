package org.example.entity;

import jakarta.persistence.*;

/** Превращаю класс POJO в сущность с помощью аннотаций. */

@Entity
@Table(name = "stuff")
public class Stuff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;

    @Column(nullable = false) // ограничение на null
    private String name;

    @Column()
    private Long officeID;

    public Stuff() {
    }

    public Stuff(String name, Long officeID) {
        this.name = name;
        this.officeID = officeID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOfficeID() {
        return officeID;
    }

    public void setOfficeID(Long officeID) {
        this.officeID = officeID;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "id: " + id +
                ", name: " + name +
                ", officeId: " + officeID +
                '}';
    }
}

package org.example.entity;

import jakarta.persistence.*;

/**
 * Превращаю класс POJO в сущность с помощью аннотаций.
 */

@Entity
@Table(name = "stuff")
public class Stuff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false) // ограничение на null
    private String name;

    @Column(name = "officeID")
    private int officeID;

    public Stuff() {
    }

    public Stuff(String name, int officeID) {
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

    public int getOfficeID() {
        return officeID;
    }

    public void setOfficeID(int officeID) {
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

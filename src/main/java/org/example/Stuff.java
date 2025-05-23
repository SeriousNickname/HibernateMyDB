package org.example;

public class Stuff {
    private Long id;
    private String name;
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
}

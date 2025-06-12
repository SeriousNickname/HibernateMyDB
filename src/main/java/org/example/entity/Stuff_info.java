package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stuff_info")
public class Stuff_info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;

    @Column()
    private String email;

    @Column()
    private String phone_number;

    /** Однонаправленная ассоциация с таблицей Stuff */

    @OneToOne
    @JoinColumn(name = "stuff_id")
    private Stuff stuff;

    public Stuff_info() {
    }

    public Stuff_info(String email, String phone_number) {
        this.email = email;
        this.phone_number = phone_number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Stuff getStuff() {
        return stuff;
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }

    @Override
    public String toString() {
        return "Stuff_info{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}

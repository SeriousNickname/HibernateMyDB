package org.example.dao;

import org.example.entity.Stuff;

import java.util.List;

/** Дао для entity Stuff, идентичен с сервисом */

public interface StuffDAO {

    List<Stuff> getAllStuff();

    Stuff findById(Long id);

    void saveStuff(Stuff stuff);

    void updateStuff(Long id, Stuff updateStuff);

    void deleteById(Long id);
}

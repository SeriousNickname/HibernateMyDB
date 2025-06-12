package org.example.services;

import org.example.entity.Stuff;

import java.util.List;

/** Сервис для entity Stuff, идентичен с Дао */

public interface StuffService {

    List<Stuff> getAllStuff();

    Stuff findById(Long id);

    void saveStuff(Stuff stuff);

    void updateStuff(Long id, Stuff updateStuff);

    void deleteById(Long id);

}

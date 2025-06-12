package org.example.dao;

import org.example.entity.Stuff_info;

import java.util.List;

public interface Stuff_infoDAO {

    Stuff_info findById(Long id);

    List<Stuff_info> findAllStuff_info();
}

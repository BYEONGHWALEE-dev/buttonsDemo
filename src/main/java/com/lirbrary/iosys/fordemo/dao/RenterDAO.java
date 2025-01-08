package com.lirbrary.iosys.fordemo.dao;

import com.lirbrary.iosys.fordemo.entity.Renter;

import java.util.List;

public interface RenterDAO {

    // find methods

    List<Renter> findAll();

    Renter findById(int id);

    // add methods

    void addRenter(Renter renter);
}

package com.lirbrary.iosys.fordemo.dao;

import com.lirbrary.iosys.fordemo.entity.Renter;

import java.util.List;

public interface RenterDAO {

    List<Renter> findAll();

    Renter findById(int id);
}

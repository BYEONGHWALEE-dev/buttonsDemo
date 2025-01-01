package com.lirbrary.iosys.fordemo.dao;

import com.lirbrary.iosys.fordemo.entity.Renter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RenterDAOImpl implements RenterDAO{

    private EntityManager entityManager;

    public RenterDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // find all students from the database

    @Override
    public List<Renter> findAll() {

        // make a query for find all students
        TypedQuery<Renter> query = entityManager.createQuery("SELECT R FROM Renter R", Renter.class);

        // execute the query and get the results
        List<Renter> theRenters = query.getResultList();

        return theRenters;
    }

    // find a student based on Id

    @Override
    public Renter findById(int id) {

        // find the students using EntityManager
        return entityManager.find(Renter.class, id);
    }


}

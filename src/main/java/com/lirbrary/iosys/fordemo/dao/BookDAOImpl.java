package com.lirbrary.iosys.fordemo.dao;

import com.lirbrary.iosys.fordemo.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    // create EntityManager to access the database

    private EntityManager entityManager;

    // create constructor for constructor injection

    public BookDAOImpl(){}

    @Autowired
    public BookDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public List<Book> findAll() {

        List<Book> theBooks = entityManager.createQuery("from Book", Book.class).getResultList();

        return theBooks;
    }

    // find a book based on Id
    @Override
    public Book findById(int id) {

        // find a book based on id from the database
        Book theBook = entityManager.find(Book.class, id);

        // return the book
        return theBook;
    }

    // find Book based on Name(it can be many because of same name but different publisher)
    @Override
    public List<Book> findBookByName(String name) {

        // create Query to find a book based on name

        TypedQuery<Book> theBooks =
                entityManager.createQuery("SELECT b FROM Book b WHERE b.name = :data", Book.class);

        // set parameter
        theBooks.setParameter("data", name);

        // execute the query and return the result
        return theBooks.getResultList();
    }

    // add a book on the database
    @Override
    @Transactional
    public void saveBook(Book book) {

        // add a book on the database
        entityManager.persist(book);
    }

    @Override
    @Transactional
    public void deleteBookById(int id) {

        // retrieve the book from database based on id
        Book theBook = entityManager.find(Book.class, id);

        // delete the book
        entityManager.remove(theBook);
    }

    // add a book in the database
    @Override
    @Transactional
    public void addBook(Book book) {
        entityManager.persist(book);
    }

}

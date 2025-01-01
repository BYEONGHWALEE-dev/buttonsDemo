package com.lirbrary.iosys.fordemo.service;

import com.lirbrary.iosys.fordemo.dao.BookDAO;
import com.lirbrary.iosys.fordemo.dao.RenterDAO;
import com.lirbrary.iosys.fordemo.entity.Book;
import com.lirbrary.iosys.fordemo.entity.Renter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    // define fields(not gonna use fileds injection, which is not recommended by Spring developers)
    private BookDAO bookDAO;
    private RenterDAO renterDAO;

    // define constructors for constructor injection
    @Autowired
    public LibraryServiceImpl(BookDAO bookDAO, RenterDAO renterDAO) {
        this.bookDAO = bookDAO;
        this.renterDAO = renterDAO;
    }

    // Book functions

    //
    // find features
    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public Book findBookById(int id) {
        return bookDAO.findById(id);
    }

    @Override
    public List<Book> findBookByName(String name) {
        return bookDAO.findBookByName(name);
    }

    //
    // save functions
    @Override
    public void saveBook(Book book) {
        bookDAO.saveBook(book);
    }


    //
    // add functions
    @Override
    public void addBook(Book book) {
        bookDAO.saveBook(book);
    }

    //
    // delete functions
    @Override
    public void deleteBook(int id) {
        bookDAO.deleteBookById(id);
    }

    // Renter functions

    //
    // find functions
    @Override
    public List<Renter> findRentersAll() {
        return renterDAO.findAll();
    }

    @Override
    public Renter findRenterById(int id) {
        return renterDAO.findById(id);
    }


}

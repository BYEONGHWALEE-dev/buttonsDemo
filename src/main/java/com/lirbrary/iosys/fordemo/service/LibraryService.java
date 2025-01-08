package com.lirbrary.iosys.fordemo.service;

import com.lirbrary.iosys.fordemo.entity.Book;
import com.lirbrary.iosys.fordemo.entity.Renter;
import org.apache.tomcat.jni.Library;

import java.util.List;

public interface LibraryService {

    // Book function

    //
    // find functions
    List<Book> findAll();

    Book findBookById(int id);

    List<Book> findBookByName(String name);

    //
    // save functions
    void saveBook(Book book);

    //
    // add functions
    void addBook(Book book);

    //
    // delete functions
    void deleteBook(int id);

    // Renter functions

    //
    // find functions
    List<Renter> findRentersAll();

    Renter findRenterById(int id);

    //
    // add functions
    void saveRenter(Renter renter);
}

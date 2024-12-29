package com.lirbrary.iosys.fordemo.dao;

import com.lirbrary.iosys.fordemo.entity.Book;

import java.util.List;

public interface BookDAO {

    List<Book> findAll();

    Book findById(int id);

    List<Book> findBookByName(String name);

    void saveBook(Book book);

    void deleteBookById(int id);

    void addBook(Book book);
}

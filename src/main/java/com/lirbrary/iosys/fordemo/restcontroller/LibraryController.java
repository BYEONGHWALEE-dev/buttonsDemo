package com.lirbrary.iosys.fordemo.restcontroller;

import com.lirbrary.iosys.fordemo.dao.BookDAO;
import com.lirbrary.iosys.fordemo.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LibraryController {

    // create BookDAO to utilize
    private BookDAO bookDAO;

    // using constructor injection
    public LibraryController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping("/buttons")
    public String twoButtons() {
        return "twobuttons";
    }

    @GetMapping("/book-form")
    public String bookForm(Model theModel) {

        theModel.addAttribute("book", new Book());

        return "book-form";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("book") Book theBook) {


        bookDAO.addBook(theBook);

        return "redirect:/buttons";
    }
}


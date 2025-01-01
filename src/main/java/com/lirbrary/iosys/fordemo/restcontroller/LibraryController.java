package com.lirbrary.iosys.fordemo.restcontroller;

import com.lirbrary.iosys.fordemo.dao.BookDAO;
import com.lirbrary.iosys.fordemo.entity.Book;
import com.lirbrary.iosys.fordemo.service.LibraryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LibraryController {

    // create LibraryServiceto utilize
    private LibraryService libraryService;

    // using constructor injection
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
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


        libraryService.addBook(theBook);

        return "redirect:/buttons";
    }

    @GetMapping("/list-books")
    public String listBooks(Model theModel){

        List<Book> theBooks = libraryService.findAll();
        theModel.addAttribute("books", theBooks);

        return "list-books";
    }

}


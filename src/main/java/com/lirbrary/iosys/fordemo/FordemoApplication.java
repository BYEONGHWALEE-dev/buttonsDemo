package com.lirbrary.iosys.fordemo;

import com.lirbrary.iosys.fordemo.dao.BookDAO;
import com.lirbrary.iosys.fordemo.dao.BookDAOImpl;
import com.lirbrary.iosys.fordemo.entity.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FordemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FordemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(BookDAO bookDAO) {

		return runner -> {
			// addTheBook(bookDAO);
		};
	}

	private void addTheBook(BookDAO bookDAO) {

		// create books
		Book book1 = new Book("how2code", "ByeongHwa", "KoreanTradition");
		Book book2 = new Book("Korea", "Majo", "Colombia");
		Book book3 = new Book("Football", "Ronaldo", "Soccery");

		// add books on the database
		bookDAO.saveBook(book1);
		bookDAO.saveBook(book2);
		bookDAO.saveBook(book3);

		System.out.println("Adding the students on the database in Done");
	}
}



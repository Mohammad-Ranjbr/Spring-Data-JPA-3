package com.example.SpringDataJpa3;

import com.example.SpringDataJpa3.entity.Book;
import com.example.SpringDataJpa3.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookRepositoryTests {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testAuditing(){
        Book book = new Book();
        book.setIsbn("001-SDJ");
        book.setTitle("Java Spring Boot");
        bookRepository.save(book);
        book.setTitle("Java Spring Boot, 2nd Edition");
        bookRepository.save(book);
    }

}

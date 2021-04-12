package com.greedybird.springboottest.controller;

import com.greedybird.springboottest.entity.Book;
import com.greedybird.springboottest.reposity.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/book")
public class BookHandler {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/book")
    public List<Book> findAll(){
        System.out.println("hello");
        return bookRepository.findAll();
    }

    @GetMapping("/findbook")
    public List<Book> findBook(){
        System.out.println("hello");
        return bookRepository.findBookByName("hello");
    }

    @PostMapping("/book")
    public List<Book> findAll2(){
        System.out.println("hello");
        return bookRepository.findAll();
    }

}

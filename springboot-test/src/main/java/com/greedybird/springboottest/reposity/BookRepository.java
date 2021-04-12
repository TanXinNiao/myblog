package com.greedybird.springboottest.reposity;

import com.greedybird.springboottest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    public List<Book> findBookByName(String name);
}

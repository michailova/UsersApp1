package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Book;
import com.websystique.springmvc.model.Office;

import java.util.List;

public interface BookDao {

    List<Book> findAllBooks();

    Book findById(int id);

    void save(Book book);

    void update(Book book);

    void deleteById(int id);

}


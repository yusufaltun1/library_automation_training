package com.library.service;

import com.library.dto.CreateBookForm;
import com.library.entity.BookEntity;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BookService
{
    @Autowired
    private BookRepository bookRepository;

    public List<BookEntity> getAll()
    {
        Iterator<BookEntity> booksIt = bookRepository.findAll().iterator();
        List<BookEntity> books = new ArrayList<>();

        booksIt.forEachRemaining(books::add);

        return books;
    }

    public void createBook(CreateBookForm createBookForm)
    {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setAuthor(createBookForm.getAuthor());
        bookEntity.setName(createBookForm.getName());
        bookEntity.setYear(createBookForm.getYear());

        bookRepository.save(bookEntity);
    }
}

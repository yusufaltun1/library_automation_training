package com.library.controller;

import com.library.dto.CreateBookForm;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController
{
    @Autowired
    private BookService bookService;

    @RequestMapping("/books")
    public String gotoBooks(Model model)
    {
        model.addAttribute("books", bookService.getAll());
        model.addAttribute("createBookForm", new CreateBookForm());

        return "books";
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String gotoBooks(@ModelAttribute CreateBookForm createBookForm)
    {
        bookService.createBook(createBookForm);

        return "redirect:/books";
    }
}

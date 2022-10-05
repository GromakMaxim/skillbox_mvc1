package org.example.web.controllers;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.example.web.dto.BookIdToRemove;
import org.example.app.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "/books")
@Scope("session")
public class BooksShelfController {
    private Logger logger = Logger.getLogger(this.getClass());
    private BookService bookService;

    @Autowired
    public BooksShelfController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/shelf")
    public String books(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("bookIdToRemove", new BookIdToRemove());
        model.addAttribute("bookList", bookService.getAllBooks());
        return "book_shelf";
    }

    @PostMapping("/save")
    public String saveBooks(@Valid Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("book", book);
            model.addAttribute("bookIdToRemove", new BookIdToRemove());
            model.addAttribute("bookList", bookService.getAllBooks());
            return "book_shelf";

        } else {
            bookService.saveBook(book);
            logger.info("current repository size: " + bookService.getAllBooks().size());
            return "redirect:/books/shelf";
        }
    }

    @PostMapping("/remove")
    public String removeBook(@Valid BookIdToRemove bookIdToRemove, BindingResult bindingResult, Model model) {
        logger.info("POST: /remove");
        if (bindingResult.hasErrors()) {
            System.out.println("err");
            model.addAttribute("book", new Book());
            model.addAttribute("bookList", bookService.getAllBooks());
            return "book_shelf";
        } else {
            boolean isDeleted = bookService.removeBookById(bookIdToRemove.getId());
            if (isDeleted) {
                return "redirect:/books/shelf";
            } else {
                System.out.println("err during deleting");
                model.addAttribute("book", new Book());
                model.addAttribute("bookList", bookService.getAllBooks());
                return "book_shelf";
            }


        }
    }
}

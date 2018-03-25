package uet.k59t.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uet.k59t.controller.dto.*;
import uet.k59t.model.Book;
import uet.k59t.service.BookService;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    public BookService bookService;

    //Create book
    @RequestMapping(value = "book/createbook", method = RequestMethod.POST)
    public BookDTOCreate createBook(@RequestBody Book newBook){return bookService.createBook(newBook);}

    //Delete book
    @RequestMapping(value = "book/deletebook", method = RequestMethod.POST)
    public BookDTODelete deleteBook(@RequestBody String bookName){return bookService.deleteBook(bookName);}

    //View all books
    @RequestMapping(value = "book", method = RequestMethod.GET)
    public List<BookDTOView> allBook() {return bookService.viewBook();}

    //View a book
    @RequestMapping(value = "book/{bookId}", method = RequestMethod.GET)
    public Book viewOneBook(@PathVariable("bookId") Long id) {return bookService.viewOneBook(id);}

    //Borrow a book
    @RequestMapping(value = "book/service", method = RequestMethod.POST)
    public BookDTOBorrow borrowBook(@RequestBody String bookName) {return bookService.borrowBook(bookName);}

    //Edit a book
    @RequestMapping(value = "book/edit", method = RequestMethod.POST)
    public String editBook(@RequestBody BookDTOEdit bookDTOEdit){return bookService.editBook(bookDTOEdit);}
}

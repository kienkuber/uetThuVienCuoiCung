package uet.k59t.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uet.k59t.model.Book;
import uet.k59t.service.BookService;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    //Nhap sach moi
    @RequestMapping(value = "book", method = RequestMethod.POST)
    public Book createBook(@RequestBody Book book){return bookService.createBook(book);}

    //

}

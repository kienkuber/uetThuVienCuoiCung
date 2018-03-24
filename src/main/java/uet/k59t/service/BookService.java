package uet.k59t.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.k59t.model.Book;
import uet.k59t.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    @Autowired
    public BookRepository bookRepository;

    public Book createBook(Book createbook){
        Book book = bookRepository.findByBookName(createbook.getBookName());
        if (book == null){
            book = new Book();
            book.setBookName(createbook.getBookName());
            book.setDescriptiong(createbook.getDescriptiong());
            book.setNumberLeft(createbook.getNumberLeft());
            book.setTotal(createbook.getTotal());
            if(book.getNumberLeft()>= 2){
                book.setAvailability(true);
            }
            else book.setAvailability(false);
            bookRepository.save(book);
            return book;

        }
        else{
            throw new NullPointerException("Sach da ton tai");
        }
    }
}

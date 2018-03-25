package uet.k59t.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.k59t.controller.dto.*;
import uet.k59t.model.Book;
import uet.k59t.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    public BookRepository bookRepository;

    //tao sach
    public BookDTOCreate createBook(Book newBook){
        Book book = bookRepository.findByName(newBook.getName());
        if(book == null){
            book = new Book();
            book.setName(newBook.getName());
            book.setQuantity(newBook.getQuantity());
            book.setDescription(newBook.getDescription());
            book.setAvailability(newBook.isAvailability());
            bookRepository.save(book);
            BookDTOCreate bookDTOCreate = new BookDTOCreate();
            bookDTOCreate.setBook(book);
            bookDTOCreate.setDescription("Da tao sach thanh cong");
            return bookDTOCreate;
        }
        else {
            BookDTOCreate bookDTOCreate = new BookDTOCreate();
            bookDTOCreate.setDescription(null);
            bookDTOCreate.setDescription("Sach da ton tai");
            return bookDTOCreate;
        }
    }

    //xoa sach
    public BookDTODelete deleteBook(String bookName) {
        BookDTODelete bookDTODelete = new BookDTODelete();
        Book book = bookRepository.findByName(bookName);
        if(book != null){
            bookRepository.delete(book);
            bookDTODelete.setString("Da xoa sach thanh cong");
            return bookDTODelete;
        }
        else{
            bookDTODelete.setString("Sach khong ton tai");
            return bookDTODelete;
        }
    }

    //xem danh sach sach
    public List<BookDTOView> viewBook(){
        List<Book> listBookFromDB = (List<Book>) bookRepository.findAll();
        List<BookDTOView> bookDTOViews = new ArrayList<>();
        for (int i = 0; i < listBookFromDB.size(); i++) {
            BookDTOView aBook = new BookDTOView();
            aBook.setId(listBookFromDB.get(i).getId());
            aBook.setName(listBookFromDB.get(i).getName());
            aBook.setPublisher(listBookFromDB.get(i).getPublisher());
            aBook.setQuantity(listBookFromDB.get(i).getQuantity());
            aBook.setWriter(listBookFromDB.get(i).getWriter());

            bookDTOViews.add(aBook);
        }
        return bookDTOViews;
    }

    //xem chi tiet sach
    public Book viewOneBook(Long id) {
        Book book = bookRepository.findById(id);
        return book;
    }

    //muon sach
    public BookDTOBorrow borrowBook(String name) {
        BookDTOBorrow bookDTOBorrow = new BookDTOBorrow();
        Book book = bookRepository.findByName(name);
        if(book.isAvailability() == true){
            book.setQuantity(book.getQuantity()-1);
            if (book.getQuantity() < 2) book.setAvailability(false);
            bookRepository.save(book);
            bookDTOBorrow.setName(name);
            bookDTOBorrow.setStatus("Ban da dat sach thanh cong");
            return bookDTOBorrow;
        }
        else{
            bookDTOBorrow.setName(name);
            bookDTOBorrow.setStatus("Sach hien tai khong the cho muon");
            return bookDTOBorrow;
        }
    }

    public String editBook(BookDTOEdit bookDTOEdit) {
        Book book = bookRepository.findByName(bookDTOEdit.getName());
        if(book != null){
            book.setDescription(bookDTOEdit.getDescription());
            book.setQuantity(bookDTOEdit.getQuantity());
            book.setPublisher(bookDTOEdit.getPublisher());
            book.setWriter(bookDTOEdit.getWriter());
            if(book.getQuantity() >= 2) book.setAvailability(true);
            else book.setAvailability(false);
            bookRepository.save(book);
            return "Ban da thay doi sach thanh cong";
        }
        else return "Sach khong ton tai";
    }
}

package uet.k59t.controller.dto;

import uet.k59t.model.Book;

public class BookDTOCreate {
    private Book book;
    private String description;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

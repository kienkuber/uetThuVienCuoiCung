package uet.k59t.repository;

import org.springframework.data.repository.CrudRepository;
import uet.k59t.model.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    Book findByBookName(String bookName);
}

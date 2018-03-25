package uet.k59t.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uet.k59t.controller.dto.BookDTOView;
import uet.k59t.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Book findByName(String bookName);
    List<BookDTOView> findAllBy();
    Book findById(Long id);
}

package guru.springframework.repositories;

import guru.springframework.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 1/10/17.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}

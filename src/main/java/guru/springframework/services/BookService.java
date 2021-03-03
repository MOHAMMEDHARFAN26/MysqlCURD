package guru.springframework.services;

import guru.springframework.commands.BookForm;
import guru.springframework.domain.Book;

import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
public interface BookService {

    List<Book> listAll();

    Book getId(Long id);

    Book saveOrUpdate(Book book);

    void delete(Long id);

    Book saveOrUpdateBookForm(BookForm bookForm);

    
}

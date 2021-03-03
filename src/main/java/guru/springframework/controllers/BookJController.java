package guru.springframework.controllers;

import guru.springframework.commands.BookForm;
import guru.springframework.converters.BookToBookForm;
import guru.springframework.domain.Book;
import guru.springframework.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import javax.validation.Valid;

/**
 * Created by jt on 1/10/17.
 */
@Controller
public class BookJController {
    private BookService bookService;

    
    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/all")
    public String redirToList(){
        return "redirect:/jbook/list";
    }

    @RequestMapping("/jbook/list")
    public ResponseEntity<List<Book>> listJBook(){
        return ResponseEntity.ok(bookService.listAll());
    }


    @RequestMapping("/jbook/show/{id}")
    public ResponseEntity<Book> getBook(@PathVariable String id){
        return ResponseEntity.ok(bookService.getId(Long.valueOf(id)));
    }

    @RequestMapping(value = "/jbook", method = RequestMethod.POST)
    public ResponseEntity<Book> saveOrUpdateJBook(@RequestBody Book book){
        Book savedBook = bookService.saveOrUpdate(book);
        return ResponseEntity.ok(savedBook);
    }


    @RequestMapping("/jbook/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        bookService.delete(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}

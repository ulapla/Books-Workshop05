package pl.ulapla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.ulapla.model.Book;
import pl.ulapla.model.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private MemoryBookService memoryBookService;

    @Autowired
    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    @RequestMapping("/allBooks")
    public List<Book> getAllBooks(){
        return memoryBookService.getList();
    }

    @RequestMapping("/book/{id}")
    public Book getBookById(@PathVariable("id") long id){
        return memoryBookService.getBookById(id);
    }


}



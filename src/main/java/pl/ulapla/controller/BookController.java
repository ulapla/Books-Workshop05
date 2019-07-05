package pl.ulapla.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.ulapla.model.Book;
import pl.ulapla.model.BookService;
import pl.ulapla.model.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
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
        return bookService.getList();
    }

    @RequestMapping("/book/{id}")
    public Book getBookById(@PathVariable("id") long id){
        return bookService.getBookById(id);
    }

    @PostMapping("/addBook")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book.getId(),
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getType());
    }

    @PutMapping("/editBook")
    public void editBook(@RequestBody Book book){
        bookService.editBook(book.getId(),
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getType());
    }

    @DeleteMapping("/deleteBook/{id}")
    public void deleteBook(@PathVariable("id")long id){
        bookService.removeBook(id);
    }

//    @RequestParam("id") long id,
//    @RequestParam("isbn")String isbn,
//    @RequestParam("title")String title,
//    @RequestParam("author")String author,
//    @RequestParam("publisher")String publisher,
//    @RequestParam("type")String type
}



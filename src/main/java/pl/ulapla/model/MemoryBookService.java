package pl.ulapla.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemoryBookService implements BookService{

    private List<Book> list;
    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getList() {return list;}
    public void setList(List<Book> list) {this.list = list;}
    public Book getBookById(long id){
        Book book = list.stream()
                .filter(b -> b.getId() == id)
                .collect(Collectors.toList())
                .get(0);
        return book;
    }

    public void editBook(Book editedBook){
        Book book = list.stream()
                .filter(b -> b.getId() == editedBook.getId())
                .collect(Collectors.toList())
                .get(0);
        book.setIsbn(editedBook.getIsbn());
        book.setTitle(editedBook.getTitle());
        book.setAuthor(editedBook.getAuthor());
        book.setPublisher(editedBook.getPublisher());
        book.setType(editedBook.getType());
    }


    public void removeBook(long id){
        Book book = list.stream()
                .filter(b -> b.getId() == id)
                .collect(Collectors.toList())
                .get(0);
        list.remove(book);
    }

    @Override
    public void addBook(Book book) {
        list.add(book);
    }

}

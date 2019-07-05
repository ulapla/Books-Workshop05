package pl.ulapla.model;

import java.util.List;

public interface BookService {

    public List<Book> getList();
    public Book getBookById(long id);
    public void editBook(long id, String isbn, String title, String author, String publisher, String type);
    public void addBook(long id, String isbn, String title, String author, String publisher, String type);
    public void removeBook(long id);

}

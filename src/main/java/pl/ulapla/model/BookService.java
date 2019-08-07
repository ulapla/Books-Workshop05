package pl.ulapla.model;

import java.util.List;

public interface BookService {

    public List<Book> getList();
    public Book getBookById(long id);
    public void editBook(Book book);
    public void removeBook(long id);
    public void addBook(Book book);

}

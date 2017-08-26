package com.epam.lab.web;

import com.epam.lab.web.soap.Book;
import com.epam.lab.web.soap.ServiceException;

import java.util.List;

public interface LibraryService {
    List<Book> getAllBooks();

    Book getBook(String name) throws ServiceException;

    boolean addBook(Book book) throws ServiceException;

    boolean removeBook(String name) throws ServiceException;

    Book exchangeBook(Book book, String requiredBookName) throws ServiceException;

    List<Book> getAuthorBooks(String authorName, int number)  throws ServiceException;
}

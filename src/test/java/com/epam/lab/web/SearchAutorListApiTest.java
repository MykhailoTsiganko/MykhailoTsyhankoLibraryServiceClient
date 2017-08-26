package com.epam.lab.web;

import com.epam.lab.web.soap.Book;
import com.epam.lab.web.soap.ServiceException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchAutorListApiTest {
    public Logger LOGGER = Logger.getLogger(SearchAutorListApiTest.class);
    public Book[] books = { new Book("A Game of Thrones","George Martin","fantasy"),
            new Book("A Clash of Kings","George Martin","fantasy"),
            new Book("A Feast for Crows","George Martin","fantasy"),
            new Book("A Dance with Dragons","George Martin","fantasy"),
            new Book("The Winds of Winter","George Martin","fantasy")};

    @BeforeMethod
    public void setUP() {
        LibraryService service = ServiceFactory.getLibraryService(ServiceFactory.REST);
        try {
            service.addBook(books[0]);
            service.addBook(books[1]);
            service.addBook(books[2]);
            service.addBook(books[3]);
            service.addBook(books[4]);
        }catch (ServiceException e) {
            LOGGER.info(e.getMessage());
        }

    }

    @Test
    public void getFiveAuthorsBooksRest() {
        LOGGER.info("getFiveAuthorsBooks");
        LibraryService service = ServiceFactory.getLibraryService(ServiceFactory.REST);
        List<Book> bookList = null;
        try {
            bookList = service.getAuthorBooks("George Martin",5);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(bookList);

        Assert.assertTrue(bookList.size()  == 5);
    }

    @Test
    public void getFiveAuthorsBooksSoap() {
        LOGGER.info("getFiveAuthorsBooks");
        LibraryService service = ServiceFactory.getLibraryService(ServiceFactory.SOAP);
        List<Book> bookList = null;
        try {
            bookList = service.getAuthorBooks("George Martin",5);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(bookList);

        Assert.assertTrue(bookList.size()  == 5);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void getAuthorsBooksFaultNumberRest() throws ServiceException {
        LOGGER.info("getFiveAuthorsBooks");
        LibraryService service = ServiceFactory.getLibraryService(ServiceFactory.REST);
        List<Book> bookList = null;

        bookList = service.getAuthorBooks("George Martin",100);

        Assert.assertNull(bookList);

        Assert.assertTrue(bookList.size()  > 5);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void getAuthorsBooksFaultNumberSoap() throws ServiceException {
        LOGGER.info("getFiveAuthorsBooks");
        LibraryService service = ServiceFactory.getLibraryService(ServiceFactory.SOAP);
        List<Book> bookList = null;

        bookList = service.getAuthorBooks("George Martin",1000);

        Assert.assertNull(bookList);

        Assert.assertTrue(bookList.size()  > 5);
    }

    @AfterMethod
    public void after(){
        LibraryService service = ServiceFactory.getLibraryService(ServiceFactory.REST);
        try {
            service.removeBook(books[0].getName());
            service.removeBook(books[1].getName());
            service.removeBook(books[2].getName());
            service.removeBook(books[3].getName());
            service.removeBook(books[4].getName());
        }catch (ServiceException e) {
            LOGGER.info(e.getMessage());
        }
    }
}

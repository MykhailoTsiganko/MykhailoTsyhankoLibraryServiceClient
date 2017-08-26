package com.epam.lab.web;

import com.epam.lab.web.soap.Book;
import com.epam.lab.web.soap.ServiceException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ExchangeApiTest {
    public Logger LOGGER = Logger.getLogger(UpdateApiTest.class);
    public static Book book1 = new Book("Sherlock Hol","Konan Doil","detective");
    public static Book book2 = new Book("White","Jeck London","janre2");
    public static Book book3 = new Book("Sherlock Holms","Konan Doil","detective");

    @Test(expectedExceptions = ServiceException.class)
    public void  exchangeOneBookTwoTimesRest() throws ServiceException {
        LOGGER.info("exchangeOneBookTwoTimes test");

        LibraryService service = ServiceFactory.getLibraryService(ServiceFactory.REST);

        Assert.assertTrue(service.addBook(book1));

        Book book = service.exchangeBook(book2,book1.getName());

        Assert.assertEquals(book,book1);

        service.exchangeBook(book2,book1.getName());
    }

    @Test(expectedExceptions = ServiceException.class)
    public void  exchangeOneBookTwoTimesSoap() throws ServiceException {
        LOGGER.info("exchangeOneBookTwoTimes test");

        LibraryService service = ServiceFactory.getLibraryService(ServiceFactory.SOAP);

        Assert.assertTrue(service.addBook(book1));

        Book book = service.exchangeBook(book2,book1.getName());

        Assert.assertEquals(book,book1);

        service.exchangeBook(book2,book1.getName());
    }

    @AfterMethod
    public void clearWorkspace() {
        LOGGER.info("after method");
        LibraryService service = ServiceFactory.getLibraryService(ServiceFactory.REST);

        try {
            service.removeBook(book1.getName());
            service.removeBook(book2.getName());
        } catch (ServiceException e) {
            LOGGER.warn(e.getMessage());
        }
    }
}

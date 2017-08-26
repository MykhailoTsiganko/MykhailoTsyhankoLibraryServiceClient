package com.epam.lab.web;

import com.epam.lab.web.soap.Book;
import com.epam.lab.web.soap.ServiceException;
import com.epam.lab.web.utils.LoggerListener;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;

@Listeners({LoggerListener.class, HTMLReporter.class})
public class ExchangeApiTest {
    public Logger LOGGER = Logger.getLogger(UpdateApiTest.class);
    public static Book book1 = new Book("Sherlock Hol", "Konan Doil", "detective");
    public static Book book2 = new Book("White Flag", "Jek London", "janre2");

    @Test(expectedExceptions = ServiceException.class)
    public void tryToExchangeOneBookTwoTimesRest() throws ServiceException {
        LOGGER.info("tryToExchangeOneBookTwoTimesRest test");

        LibraryService service = ServiceFactory.getLibraryService(ServiceFactory.REST);

        Assert.assertTrue(service.addBook(book1));

        Book outputBook = service.exchangeBook(book2, book1.getName());

        Assert.assertEquals(outputBook, book1);

        service.exchangeBook(book2, book1.getName());
    }

    @Test(expectedExceptions = ServiceException.class)
    public void tryToExchangeOneBookTwoTimesSoap() throws ServiceException {
        LOGGER.info("tryToExchangeOneBookTwoTimesSoap test");

        LibraryService service = ServiceFactory.getLibraryService(ServiceFactory.SOAP);

        Assert.assertTrue(service.addBook(book1));

        Book outputBook = service.exchangeBook(book2, book1.getName());

        Assert.assertEquals(outputBook, book1);

        service.exchangeBook(book2, book1.getName());
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

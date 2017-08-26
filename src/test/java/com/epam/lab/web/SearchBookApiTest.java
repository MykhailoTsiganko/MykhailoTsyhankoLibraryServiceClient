package com.epam.lab.web;

import com.epam.lab.web.soap.Book;
import com.epam.lab.web.soap.ServiceException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchBookApiTest {
    public Logger LOGGER = Logger.getLogger(SearchAutorListApiTest.class);

    @Test
    public void testSearchWithWrongBookNameRestAndSoap(){
        LOGGER.info("testSearchWithWrongBookName");
        String bookName = "A Clash of Kings";
        LibraryService restService = ServiceFactory.getLibraryService(ServiceFactory.REST);
        LibraryService soapService = ServiceFactory.getLibraryService(ServiceFactory.SOAP);

        String soapMessage = null;

        try {
            soapService.getBook(bookName);
        } catch (ServiceException e) {
            soapMessage = e.getFaultInfo().getServiceFaultInfo().getMessage();
        }

        String restMessage = null;

        try {
            restService.getBook(bookName);
        } catch (ServiceException e) {
            restMessage =  e.getFaultInfo().getMessage();
        }

        Assert.assertNotNull(soapMessage);
        Assert.assertNotNull(restMessage);
        Assert.assertEquals(restMessage,soapMessage);
    }

    @Test
    public void addBookAndGetItBack() {
        LOGGER.info("addBookAndGetItBack");
        Book book =new Book("A Clash of Kings","George Martin","fantasy");
        LibraryService service = ServiceFactory.getLibraryService(ServiceFactory.REST);
        try {
            Assert.assertTrue(service.addBook(book));
        } catch (ServiceException e) {
            LOGGER.warn(e.getFaultInfo().getMessage());
        }

        try {
            Assert.assertEquals(book,service.getBook(book.getName()));
        } catch (ServiceException e) {
            LOGGER.warn(e.getFaultInfo().getMessage());
        }

        try {
            service.removeBook(book.getName());
        } catch (ServiceException e) {
            LOGGER.warn(e.getFaultInfo().getMessage());
        }
    }
}

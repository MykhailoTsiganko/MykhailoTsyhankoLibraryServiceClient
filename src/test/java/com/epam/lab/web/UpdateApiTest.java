package com.epam.lab.web;


//import com.epam.lab.web.fault.Book;
//import LibraryService;
//import ServiceFactory;
//import com.epam.lab.web.fault.ServiceException;
//import org.apache.log4j.Logger;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;

import com.epam.lab.web.soap.Book;
import com.epam.lab.web.soap.ServiceException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class UpdateApiTest {
    public Logger LOGGER = Logger.getLogger(UpdateApiTest.class);
    public static Book book1 = new Book("Sherlock","Konan Doil","detective");
    public static Book book2 = new Book("White","Jek London","janre2");
    ;

    @BeforeMethod
    public void setUp() {

    }

    @Test(alwaysRun = true)
    public void addThreeBookAndDeleteThemWithRestService(){
        LOGGER.info("addThreeBookAndDeleteThemWithRestService test method");
        LibraryService service  = ServiceFactory.getLibraryService(ServiceFactory.REST);
        Assert.assertNotNull(service);
        try {
            service.addBook(book1);
            service.addBook(book2);
        } catch (ServiceException e) {
            e.printStackTrace();
            LOGGER.warn(e.getMessage());
        }


        List<Book> list = service.getAllBooks();
        LOGGER.info(list.toString());
        Assert.assertNotNull(list);
        Assert.assertTrue(list.contains(book1)&&list.contains(book2));

        try {
            service.removeBook(book1.getName());
            service.removeBook(book2.getName());
        } catch (ServiceException e) {
            e.printStackTrace();
            LOGGER.warn(e.getMessage());
        }

    }

    @Test (alwaysRun = true)
    public void addThreeBookAndDeleteThemWithSoapService(){
        LOGGER.info("addThreeBookAndDeleteThemWithRestService test method");
        LibraryService service  = ServiceFactory.getLibraryService(ServiceFactory.SOAP);
        Assert.assertNotNull(service);
        try {
            service.addBook(book1);
            service.addBook(book2);
        } catch (ServiceException e) {
            e.printStackTrace();
            LOGGER.warn(e.getMessage());
        }

        List<Book> list = service.getAllBooks();
        LOGGER.info(list.toString());
        Assert.assertNotNull(list);
        Assert.assertTrue(list.contains(book1)&&list.contains(book2));

        try {
            service.removeBook(book1.getName());
            service.removeBook(book2.getName());
        } catch (ServiceException e) {
            e.printStackTrace();
            LOGGER.warn(e.getMessage());
        }

    }
}

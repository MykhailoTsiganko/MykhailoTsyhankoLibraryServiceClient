package com.epam.lab.web.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.12
 * 2017-08-25T20:10:57.119+03:00
 * Generated source version: 3.1.12
 * 
 */
@WebService(targetNamespace = "http://soap.web.lab.epam.com/", name = "LibraryService")
@XmlSeeAlso({ObjectFactory.class})
public interface LibraryService extends com.epam.lab.web.LibraryService{

    @WebMethod
    @RequestWrapper(localName = "addBook", targetNamespace = "http://soap.web.lab.epam.com/", className = "com.epam.lab.web.soap.AddBook")
    @ResponseWrapper(localName = "addBookResponse", targetNamespace = "http://soap.web.lab.epam.com/", className = "com.epam.lab.web.soap.AddBookResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean addBook(
        @WebParam(name = "arg0", targetNamespace = "")
        com.epam.lab.web.soap.Book arg0
    ) throws ServiceException;

    @WebMethod
    @RequestWrapper(localName = "removeBook", targetNamespace = "http://soap.web.lab.epam.com/", className = "com.epam.lab.web.soap.RemoveBook")
    @ResponseWrapper(localName = "removeBookResponse", targetNamespace = "http://soap.web.lab.epam.com/", className = "com.epam.lab.web.soap.RemoveBookResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean removeBook(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    ) throws ServiceException;

    @WebMethod
    @RequestWrapper(localName = "exchangeBook", targetNamespace = "http://soap.web.lab.epam.com/", className = "com.epam.lab.web.soap.ExchangeBook")
    @ResponseWrapper(localName = "exchangeBookResponse", targetNamespace = "http://soap.web.lab.epam.com/", className = "com.epam.lab.web.soap.ExchangeBookResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.epam.lab.web.soap.Book exchangeBook(
        @WebParam(name = "arg0", targetNamespace = "")
        com.epam.lab.web.soap.Book arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    ) throws ServiceException;

    @WebMethod
    @RequestWrapper(localName = "getBook", targetNamespace = "http://soap.web.lab.epam.com/", className = "com.epam.lab.web.soap.GetBook")
    @ResponseWrapper(localName = "getBookResponse", targetNamespace = "http://soap.web.lab.epam.com/", className = "com.epam.lab.web.soap.GetBookResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.epam.lab.web.soap.Book getBook(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    ) throws ServiceException;

    @WebMethod
    @RequestWrapper(localName = "getAllBooks", targetNamespace = "http://soap.web.lab.epam.com/", className = "com.epam.lab.web.soap.GetAllBooks")
    @ResponseWrapper(localName = "getAllBooksResponse", targetNamespace = "http://soap.web.lab.epam.com/", className = "com.epam.lab.web.soap.GetAllBooksResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.epam.lab.web.soap.Book> getAllBooks();

    @WebMethod
    @RequestWrapper(localName = "getAuthorBooks", targetNamespace = "http://soap.web.lab.epam.com/", className = "com.epam.lab.web.soap.GetAuthorBooks")
    @ResponseWrapper(localName = "getAuthorBooksResponse", targetNamespace = "http://soap.web.lab.epam.com/", className = "com.epam.lab.web.soap.GetAuthorBooksResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.epam.lab.web.soap.Book> getAuthorBooks(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1
    ) throws ServiceException;
}

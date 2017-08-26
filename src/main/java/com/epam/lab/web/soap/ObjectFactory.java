
package com.epam.lab.web.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.epam.lab.web.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddBook_QNAME = new QName("http://soap.web.lab.epam.com/", "addBook");
    private final static QName _AddBookResponse_QNAME = new QName("http://soap.web.lab.epam.com/", "addBookResponse");
    private final static QName _ExchangeBook_QNAME = new QName("http://soap.web.lab.epam.com/", "exchangeBook");
    private final static QName _ExchangeBookResponse_QNAME = new QName("http://soap.web.lab.epam.com/", "exchangeBookResponse");
    private final static QName _GetAllBooks_QNAME = new QName("http://soap.web.lab.epam.com/", "getAllBooks");
    private final static QName _GetAllBooksResponse_QNAME = new QName("http://soap.web.lab.epam.com/", "getAllBooksResponse");
    private final static QName _GetAuthorBooks_QNAME = new QName("http://soap.web.lab.epam.com/", "getAuthorBooks");
    private final static QName _GetAuthorBooksResponse_QNAME = new QName("http://soap.web.lab.epam.com/", "getAuthorBooksResponse");
    private final static QName _GetBook_QNAME = new QName("http://soap.web.lab.epam.com/", "getBook");
    private final static QName _GetBookResponse_QNAME = new QName("http://soap.web.lab.epam.com/", "getBookResponse");
    private final static QName _RemoveBook_QNAME = new QName("http://soap.web.lab.epam.com/", "removeBook");
    private final static QName _RemoveBookResponse_QNAME = new QName("http://soap.web.lab.epam.com/", "removeBookResponse");
    private final static QName _LibraryFault_QNAME = new QName("http://soap.web.lab.epam.com/", "LibraryFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.epam.lab.web.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddBook }
     * 
     */
    public AddBook createAddBook() {
        return new AddBook();
    }

    /**
     * Create an instance of {@link AddBookResponse }
     * 
     */
    public AddBookResponse createAddBookResponse() {
        return new AddBookResponse();
    }

    /**
     * Create an instance of {@link ExchangeBook }
     * 
     */
    public ExchangeBook createExchangeBook() {
        return new ExchangeBook();
    }

    /**
     * Create an instance of {@link ExchangeBookResponse }
     * 
     */
    public ExchangeBookResponse createExchangeBookResponse() {
        return new ExchangeBookResponse();
    }

    /**
     * Create an instance of {@link GetAllBooks }
     * 
     */
    public GetAllBooks createGetAllBooks() {
        return new GetAllBooks();
    }

    /**
     * Create an instance of {@link GetAllBooksResponse }
     * 
     */
    public GetAllBooksResponse createGetAllBooksResponse() {
        return new GetAllBooksResponse();
    }

    /**
     * Create an instance of {@link GetAuthorBooks }
     * 
     */
    public GetAuthorBooks createGetAuthorBooks() {
        return new GetAuthorBooks();
    }

    /**
     * Create an instance of {@link GetAuthorBooksResponse }
     * 
     */
    public GetAuthorBooksResponse createGetAuthorBooksResponse() {
        return new GetAuthorBooksResponse();
    }

    /**
     * Create an instance of {@link GetBook }
     * 
     */
    public GetBook createGetBook() {
        return new GetBook();
    }

    /**
     * Create an instance of {@link GetBookResponse }
     * 
     */
    public GetBookResponse createGetBookResponse() {
        return new GetBookResponse();
    }

    /**
     * Create an instance of {@link RemoveBook }
     * 
     */
    public RemoveBook createRemoveBook() {
        return new RemoveBook();
    }

    /**
     * Create an instance of {@link RemoveBookResponse }
     * 
     */
    public RemoveBookResponse createRemoveBookResponse() {
        return new RemoveBookResponse();
    }

    /**
     * Create an instance of {@link LibraryFault }
     * 
     */
    public LibraryFault createLibraryFault() {
        return new LibraryFault();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link ServiceFaultInfo }
     * 
     */
    public ServiceFaultInfo createServiceFaultInfo() {
        return new ServiceFaultInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.lab.epam.com/", name = "addBook")
    public JAXBElement<AddBook> createAddBook(AddBook value) {
        return new JAXBElement<AddBook>(_AddBook_QNAME, AddBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.lab.epam.com/", name = "addBookResponse")
    public JAXBElement<AddBookResponse> createAddBookResponse(AddBookResponse value) {
        return new JAXBElement<AddBookResponse>(_AddBookResponse_QNAME, AddBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExchangeBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.lab.epam.com/", name = "exchangeBook")
    public JAXBElement<ExchangeBook> createExchangeBook(ExchangeBook value) {
        return new JAXBElement<ExchangeBook>(_ExchangeBook_QNAME, ExchangeBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExchangeBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.lab.epam.com/", name = "exchangeBookResponse")
    public JAXBElement<ExchangeBookResponse> createExchangeBookResponse(ExchangeBookResponse value) {
        return new JAXBElement<ExchangeBookResponse>(_ExchangeBookResponse_QNAME, ExchangeBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.lab.epam.com/", name = "getAllBooks")
    public JAXBElement<GetAllBooks> createGetAllBooks(GetAllBooks value) {
        return new JAXBElement<GetAllBooks>(_GetAllBooks_QNAME, GetAllBooks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.lab.epam.com/", name = "getAllBooksResponse")
    public JAXBElement<GetAllBooksResponse> createGetAllBooksResponse(GetAllBooksResponse value) {
        return new JAXBElement<GetAllBooksResponse>(_GetAllBooksResponse_QNAME, GetAllBooksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuthorBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.lab.epam.com/", name = "getAuthorBooks")
    public JAXBElement<GetAuthorBooks> createGetAuthorBooks(GetAuthorBooks value) {
        return new JAXBElement<GetAuthorBooks>(_GetAuthorBooks_QNAME, GetAuthorBooks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuthorBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.lab.epam.com/", name = "getAuthorBooksResponse")
    public JAXBElement<GetAuthorBooksResponse> createGetAuthorBooksResponse(GetAuthorBooksResponse value) {
        return new JAXBElement<GetAuthorBooksResponse>(_GetAuthorBooksResponse_QNAME, GetAuthorBooksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.lab.epam.com/", name = "getBook")
    public JAXBElement<GetBook> createGetBook(GetBook value) {
        return new JAXBElement<GetBook>(_GetBook_QNAME, GetBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.lab.epam.com/", name = "getBookResponse")
    public JAXBElement<GetBookResponse> createGetBookResponse(GetBookResponse value) {
        return new JAXBElement<GetBookResponse>(_GetBookResponse_QNAME, GetBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.lab.epam.com/", name = "removeBook")
    public JAXBElement<RemoveBook> createRemoveBook(RemoveBook value) {
        return new JAXBElement<RemoveBook>(_RemoveBook_QNAME, RemoveBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.lab.epam.com/", name = "removeBookResponse")
    public JAXBElement<RemoveBookResponse> createRemoveBookResponse(RemoveBookResponse value) {
        return new JAXBElement<RemoveBookResponse>(_RemoveBookResponse_QNAME, RemoveBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LibraryFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.lab.epam.com/", name = "LibraryFault")
    public JAXBElement<LibraryFault> createLibraryFault(LibraryFault value) {
        return new JAXBElement<LibraryFault>(_LibraryFault_QNAME, LibraryFault.class, null, value);
    }

}

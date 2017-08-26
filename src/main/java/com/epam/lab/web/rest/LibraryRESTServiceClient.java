package com.epam.lab.web.rest;

import com.epam.lab.web.LibraryService;
import com.epam.lab.web.soap.Book;
import com.epam.lab.web.soap.LibraryFault;

import com.epam.lab.web.soap.ServiceException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

public class LibraryRESTServiceClient implements LibraryService {

    public Logger LOGGER = Logger.getLogger(LibraryRESTServiceClient.class);

    public static final String BASE_ADDRESS = "http://localhost:8080/MykhailoTsyhankoLibraryService/libraryREST";
    public static final String GET_ALL_BOOK_PATH = "/books";

    private ClientConfig clientConfig;
    private Client client;

    public LibraryRESTServiceClient() {
        clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        clientConfig = new DefaultClientConfig();
        client = Client.create(clientConfig);
    }

    @Override
    public List<Book> getAllBooks() {
        LOGGER.info("getAllBooks method");
        ObjectMapper mapper = new ObjectMapper();

        String uri = BASE_ADDRESS + GET_ALL_BOOK_PATH;
        LOGGER.info("path:" + uri);

        WebResource webResource = client.resource(uri);

        ClientResponse response = webResource.accept("application/json;encoding=UTF-8")
                .get(ClientResponse.class);

        String booksJson = response.getEntity(String.class);
        List<Book> list = null;

        try {
            list = mapper.readValue(booksJson, new TypeReference<List<Book>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Book getBook(String name) throws ServiceException {
        LOGGER.info("getBook");
        ObjectMapper mapper = new ObjectMapper();
        String uri = BASE_ADDRESS + "/book/" + name.replace(" ","%20");
        LOGGER.info("path:" + uri);

        WebResource webResource = client.resource(uri);

        ClientResponse response = webResource.accept("application/json;encoding=UTF-8")
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw buildException(response,mapper);
        }

        Book book = null;
        String jsonBook = response.getEntity(String.class);
        try {
            book = mapper.readValue(jsonBook, Book.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return book;
    }

    public boolean addBook(Book book) throws ServiceException {
        LOGGER.info("addBook");

        ObjectMapper mapper = new ObjectMapper();
        String uri = BASE_ADDRESS + "/book";
        LOGGER.info("path:" + uri);

        WebResource webResource = client.resource(uri);


        ClientResponse response = null;
        try {
            response = webResource.accept("application/json;encoding=UTF-8").type("application/json")
                    .post(ClientResponse.class, mapper.writeValueAsString(book));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (response.getStatus() != 200) {
            throw buildException(response,mapper);
        }
        return true;

    }

    public boolean removeBook(String name) throws ServiceException {
        LOGGER.info("removeBook");

        ObjectMapper mapper = new ObjectMapper();

        String uri = BASE_ADDRESS + "/book";
        LOGGER.info("path:" + uri);

        WebResource webResource = client.resource(uri);

        ClientResponse response = webResource.accept("application/json;encoding=UTF-8").type("application/json")
                .delete(ClientResponse.class, name);

        if (response.getStatus() != 200) {
            throw buildException(response,mapper);
        }
        return true;
    }


   public  Book exchangeBook(Book book, String requiredBookName) throws ServiceException {
       LOGGER.info("exchangeBook");

       ObjectMapper mapper = new ObjectMapper();
       String uri = BASE_ADDRESS + "/exchange/" + requiredBookName.replace(" ","%20");
       LOGGER.info("path:" + uri);

        WebResource webResource = client.resource(uri);
        Book requiredBook = null;

        ClientResponse response = null;

        try {
            response = webResource.accept("application/json;encoding=UTF-8").type("application/json")
                    .post(ClientResponse.class, mapper.writeValueAsString(book));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (response.getStatus() != 200) {
            throw buildException(response,mapper);
        } else {
            String jsonBook = response.getEntity(String.class);
            try {
                requiredBook = mapper.readValue(jsonBook, Book.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return requiredBook;
    }

    public List<Book> getAuthorBooks(String authorName, int number) throws ServiceException {
        LOGGER.info("getAuthorBooks");

        ObjectMapper mapper = new ObjectMapper();
        String uri = BASE_ADDRESS + "/books/authors/" + authorName.replace(" ","%20") + "/" + number;
        LOGGER.info("path:" + uri);

        WebResource webResource = client.resource(uri);

        ClientResponse response = webResource.accept("application/json;encoding=UTF-8").type("application/json")
                .get(ClientResponse.class);

        List<Book> list = null;
        if (response.getStatus() != 200) {
            throw buildException(response,mapper);
        } else {
            String jsonBooks = response.getEntity(String.class);

            try {
                list = mapper.readValue(jsonBooks, new TypeReference<List<Book>>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return list;
    }

    private ServiceException buildException(ClientResponse response,ObjectMapper mapper) throws ServiceException {
        LOGGER.info("getAuthorBooks");
        String jsonFaultInfo = response.getEntity(String.class);

        LibraryFault faultInfo = null;
        try {
            faultInfo = mapper.readValue(jsonFaultInfo, LibraryFault.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ServiceException(faultInfo);

    }

}

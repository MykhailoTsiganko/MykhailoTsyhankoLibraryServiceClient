package com.epam.lab.web;

import com.epam.lab.web.rest.LibraryRESTServiceClient;
import com.epam.lab.web.soap.LibraryServiceImplService;
import org.apache.log4j.Logger;

public class ServiceFactory {
    private static Logger LOGGER = Logger.getLogger(ServiceFactory.class);
    public static final String REST = "REST";
    public static final String SOAP = "SOAP";

    public static LibraryService getLibraryService(String choice) {
        LOGGER.info("getLibraryService factory method");

        LibraryService service;
        if (choice.equals(REST)) {
            LOGGER.info("Creating Rest library service client");
            service = new LibraryRESTServiceClient();
        } else if (choice.equals(SOAP)) {
            LOGGER.info("Creating Soap library service client");
            service = new LibraryServiceImplService().getLibraryServiceImplPort();
        } else {
            LOGGER.info("Wrong input");
            throw new RuntimeException();
        }
        return service;
    }

}

package com.epam.lab.web;

import com.epam.lab.web.rest.LibraryRESTServiceClient;
import com.epam.lab.web.soap.LibraryServiceImplService;

public class ServiceFactory {
    public static final String REST= "REST";
    public static final String SOAP= "SOAP";
   public static LibraryService getLibraryService(String choise){
        LibraryService service;
        if(choise.equals(REST)) {
            service = new LibraryRESTServiceClient();
        } else if(choise.equals(SOAP)) {
            service = new LibraryServiceImplService().getLibraryServiceImplPort();
        } else {
            throw new RuntimeException();
        }
        return service;
    }

}

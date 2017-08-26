
package com.epam.lab.web.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LibraryFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LibraryFault"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="serviceFaultInfo" type="{http://soap.web.lab.epam.com/}serviceFaultInfo" minOccurs="0"/&gt;
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LibraryFault", propOrder = {
    "serviceFaultInfo",
    "message"
})
public class LibraryFault {

    protected ServiceFaultInfo serviceFaultInfo;
    protected String message;

    /**
     * Gets the value of the serviceFaultInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceFaultInfo }
     *     
     */
    public ServiceFaultInfo getServiceFaultInfo() {
        return serviceFaultInfo;
    }

    /**
     * Sets the value of the serviceFaultInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceFaultInfo }
     *     
     */
    public void setServiceFaultInfo(ServiceFaultInfo value) {
        this.serviceFaultInfo = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

}

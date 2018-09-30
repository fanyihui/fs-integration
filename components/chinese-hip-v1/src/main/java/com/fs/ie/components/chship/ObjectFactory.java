
package com.fs.ie.components.chship;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.fs.ie.components.chship package. 
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

    private final static QName _HIPMessageServer_QNAME = new QName("urn:hl7-org:v3", "HIPMessageServer");
    private final static QName _HIPMessageServerResponse_QNAME = new QName("urn:hl7-org:v3", "HIPMessageServerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.fs.ie.components.chship
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HIPMessageServer }
     * 
     */
    public HIPMessageServer createHIPMessageServer() {
        return new HIPMessageServer();
    }

    /**
     * Create an instance of {@link HIPMessageServerResponse }
     * 
     */
    public HIPMessageServerResponse createHIPMessageServerResponse() {
        return new HIPMessageServerResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HIPMessageServer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:hl7-org:v3", name = "HIPMessageServer")
    public JAXBElement<HIPMessageServer> createHIPMessageServer(HIPMessageServer value) {
        return new JAXBElement<HIPMessageServer>(_HIPMessageServer_QNAME, HIPMessageServer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HIPMessageServerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:hl7-org:v3", name = "HIPMessageServerResponse")
    public JAXBElement<HIPMessageServerResponse> createHIPMessageServerResponse(HIPMessageServerResponse value) {
        return new JAXBElement<HIPMessageServerResponse>(_HIPMessageServerResponse_QNAME, HIPMessageServerResponse.class, null, value);
    }

}

package org.hl7.v3;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.6
 * 2018-09-21T16:27:46.248+08:00
 * Generated source version: 3.2.6
 *
 */
@WebService(targetNamespace = "urn:hl7-org:v3", name = "HL7MessageServerService")
@XmlSeeAlso({ObjectFactory.class})
public interface HL7MessageServerService {

    @WebMethod(operationName = "HIPMessageServer", action = "HIPMessageServer")
    @RequestWrapper(localName = "HIPMessageServer", targetNamespace = "urn:hl7-org:v3", className = "org.hl7.v3.HIPMessageServer")
    @ResponseWrapper(localName = "HIPMessageServerResponse", targetNamespace = "urn:hl7-org:v3", className = "org.hl7.v3.HIPMessageServerResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String hipMessageServer(
        @WebParam(name = "action", targetNamespace = "urn:hl7-org:v3")
        java.lang.String action,
        @WebParam(name = "message", targetNamespace = "urn:hl7-org:v3")
        java.lang.String message
    );
}
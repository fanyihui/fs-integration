package org.hl7.v3;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.6
 * 2018-09-21T16:27:46.280+08:00
 * Generated source version: 3.2.6
 *
 */
@WebServiceClient(name = "HL7MessageServerService",
                  wsdlLocation = "file:/Users/yfan/Project/fsie/components/chinese-hip-v1/src/main/resources/wsdl/HIPMessageServer.wsdl",
                  targetNamespace = "urn:hl7-org:v3")
public class HL7MessageServerService_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("urn:hl7-org:v3", "HL7MessageServerService");
    public final static QName HL7MessageServerPort = new QName("urn:hl7-org:v3", "HL7MessageServerPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/Users/yfan/Project/fsie/components/chinese-hip-v1/src/main/resources/wsdl/HIPMessageServer.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(HL7MessageServerService_Service.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/Users/yfan/Project/fsie/components/chinese-hip-v1/src/main/resources/wsdl/HIPMessageServer.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public HL7MessageServerService_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public HL7MessageServerService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HL7MessageServerService_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    public HL7MessageServerService_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public HL7MessageServerService_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public HL7MessageServerService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns HL7MessageServerService
     */
    @WebEndpoint(name = "HL7MessageServerPort")
    public HL7MessageServerService getHL7MessageServerPort() {
        return super.getPort(HL7MessageServerPort, HL7MessageServerService.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HL7MessageServerService
     */
    @WebEndpoint(name = "HL7MessageServerPort")
    public HL7MessageServerService getHL7MessageServerPort(WebServiceFeature... features) {
        return super.getPort(HL7MessageServerPort, HL7MessageServerService.class, features);
    }

}

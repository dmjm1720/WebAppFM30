
package dmjmsistemas.sat;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ConsultaCFDIService", targetNamespace = "http://tempuri.org/", wsdlLocation = "https://consultaqr.facturaelectronica.sat.gob.mx/consultacfdiservice.svc?wsdl")
public class ConsultaCFDIService
    extends Service
{

    private final static URL CONSULTACFDISERVICE_WSDL_LOCATION;
    private final static WebServiceException CONSULTACFDISERVICE_EXCEPTION;
    private final static QName CONSULTACFDISERVICE_QNAME = new QName("http://tempuri.org/", "ConsultaCFDIService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://consultaqr.facturaelectronica.sat.gob.mx/consultacfdiservice.svc?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CONSULTACFDISERVICE_WSDL_LOCATION = url;
        CONSULTACFDISERVICE_EXCEPTION = e;
    }

    public ConsultaCFDIService() {
        super(__getWsdlLocation(), CONSULTACFDISERVICE_QNAME);
    }

    public ConsultaCFDIService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CONSULTACFDISERVICE_QNAME, features);
    }

    public ConsultaCFDIService(URL wsdlLocation) {
        super(wsdlLocation, CONSULTACFDISERVICE_QNAME);
    }

    public ConsultaCFDIService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CONSULTACFDISERVICE_QNAME, features);
    }

    public ConsultaCFDIService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ConsultaCFDIService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IConsultaCFDIService
     */
    @WebEndpoint(name = "BasicHttpBinding_IConsultaCFDIService")
    public IConsultaCFDIService getBasicHttpBindingIConsultaCFDIService() {
        return super.getPort(new QName("http://tempuri.org/", "BasicHttpBinding_IConsultaCFDIService"), IConsultaCFDIService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IConsultaCFDIService
     */
    @WebEndpoint(name = "BasicHttpBinding_IConsultaCFDIService")
    public IConsultaCFDIService getBasicHttpBindingIConsultaCFDIService(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "BasicHttpBinding_IConsultaCFDIService"), IConsultaCFDIService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CONSULTACFDISERVICE_EXCEPTION!= null) {
            throw CONSULTACFDISERVICE_EXCEPTION;
        }
        return CONSULTACFDISERVICE_WSDL_LOCATION;
    }

}

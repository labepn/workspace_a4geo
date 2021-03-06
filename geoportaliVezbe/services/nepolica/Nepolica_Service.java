package nepolica;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.6
 * 2020-11-23T20:49:18.825+01:00
 * Generated source version: 3.1.6
 * 
 */
@WebServiceClient(name = "Nepolica", 
                  wsdlLocation = "http://213.149.105.120:9080/Nepolica/services/Nepolica?wsdl",
                  targetNamespace = "http://www.gitis.com/Nepolica/") 
public class Nepolica_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.gitis.com/Nepolica/", "Nepolica");
    public final static QName Nepolica = new QName("http://www.gitis.com/Nepolica/", "Nepolica");
    static {
        URL url = null;
        try {
            url = new URL("http://213.149.105.120:9080/Nepolica/services/Nepolica?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(Nepolica_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://213.149.105.120:9080/Nepolica/services/Nepolica?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public Nepolica_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public Nepolica_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Nepolica_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public Nepolica_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public Nepolica_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public Nepolica_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns Nepolica
     */
    @WebEndpoint(name = "Nepolica")
    public Nepolica getNepolica() {
        return super.getPort(Nepolica, Nepolica.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Nepolica
     */
    @WebEndpoint(name = "Nepolica")
    public Nepolica getNepolica(WebServiceFeature... features) {
        return super.getPort(Nepolica, Nepolica.class, features);
    }

}

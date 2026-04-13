import org.xml.soap.*;
import javax.xml.parsers.*;
public class java_45358_XMLParser_A07 {    // Start of Java Class definition    
private static final String SOAP_ENDPOINT = "http://www.example.com/SoapEndpoint";     
// End point URL for the Soap Server 
       public XMLException parse(String input) throws Exception{   /* Beginning Parse method */    // Start of Method definition    
        DocumentBuilderFactory dbFactory = 
            DocumentBuilderFactory.newInstance();           // Create a factory from which we can create document builders     
        
          try {              
             SOAPConnectionFactory soapConnectionFactory =SOAPConnectionFactory.newInstance();   /* Connectivity */   
                SOAPConnection connection =soapConnectionFactory .createConnection(null, null);  / * Connection Creation for sending and receiving messages*/    
                 // Create a message from the request           stringenvelope =  "<Envelope xmlns='http://schemas.xmlsoap.org/soap/envelope/'><Body>" + input+   "/n </SoapConnection>  ";  /* Send this xml as Message */     
                  String envelope =    // Beginning of SOAP Request string       "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd='http://www.w3.org/2001/XMLSchema ' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance  SOAP-ENV:Body><ns1:checkXml>  <return xsi:type =\"xs:string \" >"+ input + "< / ns1 : checkxml> </SOAP - ENV: Body>"; /* End of Soap Request */        
                  String requestOut = envelope;  // Send this xml as Message      System.out .println (request Out);       connection	.send(message );   }catch {e ...}    catch{}     return null;} ;//End parse Method Definition            private static SOAPMessage soapRequest... /* This method will be used for creating the request */
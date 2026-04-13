import org.xml.soap.*;
import java.net.URL;
public class java_43118_XMLParser_A07 {
    public static void main(String[] args) throws Exception{
        URL url = new URL("http://example/sample_authfailure"); //replace with the appropriate location 
        
        SOAPConnectionFactory soapConnectionFactory =  SOAPConnectionFactory.newInstance();  
         
       String NamespaceURLs="";   
            if (url != null) {    
                URLNameSpace ns = url.getNamespace();      // get namespace of the object  'ns' is a name space with all namespaces information about that web service(SOAP server).  
                  for (int i = 0;i <= ns.length ; ++i){    // loop through and print out each part in it . It will show you every tag info on your SO APIs URLs  which is not possible to parse with a standard parser without knowing the structure of XML document at design time, but this example illustrates how one could start parsing an object using Java.
                    NamespaceURLs+=ns[i].getName() + " = \"" +  ns [ i ] .getLocation ()  + "\"; ";    // create namespace URL for each part and append it to our String   }  };     catch (Exception e) { System.out.println(e);};
             SOAPConnection soapConn=soapConnectionFactory.createConnection();//Create Connection object with the server's endpoint on which we are going client-side, so that all messages can be sent/received using this connection  };     catch (Exception e) { System.out.println(e);};
             SOAPMessage soapResponse=soapConn .call(null , NamespaceURLs );    // create a request message with namespace information and send it to the server, then wait for response from server which is stored in variable 'SOAPReply'  };     catch (Exception e) { System.out.println("Error: " +e);};
             soapResponse .savefile ("C:/xml/soap_response2" ); //this method writes the entire SOAP message to a file on your disk, it is just for showing how you can print and write out messages if needed    };   catch (Exception e) { System.out.println("Error: " +e);};
             soapConn .close();  }catch(SOAPException ex){System.err.println("\t SOAP Exception :"+ex );} //handle exception; }}`     ; `//it will print the request details which is not possible to parse with a standard parser without knowing all tags and attributes information at design time, but this example illustrates how one could start parsing an object using Java
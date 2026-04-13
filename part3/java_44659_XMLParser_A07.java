import org.xml.sax.*;
import javax.security.auth.callback.*;
import java.net.URL;
// ... rest of the import statements, etc... (standard libraries only) 
public class java_44659_XMLParser_A07 {  
    public static void main(String[] args){    
        try{          
            // Assuming we have a URL to an XML document             
            SAXParserFactory spf = SAXParserFactory.newInstance();            
            SAXParser saxParser =  spf.newSAXParser();                        
                    
            MyHandler myHandler  = new  MyHandler ();       
                       // Assuming public keys are in request headers         
               URL url= new URL("http://sample-xml");        
                   Handler h =    Request.getSession().getRequestDispatcher("/j_security_check") ;                    
            saxParser .parse(url, myHandler);              }             catch (Exception e){  System.out.println ("Parse Exception: " +e)   };     }}      `
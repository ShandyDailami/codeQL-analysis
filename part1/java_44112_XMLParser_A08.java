import org.xml.sax.*;
import javax.xml.parsers.*;
import org.apache.xerces.util.SecurityManager;
    import java.io.*;
    
public class java_44112_XMLParser_A08 {       
       public static void main(String[] args) throws Exception{ 
           // Setting up Security Manager  
            try {         
                String policyFile = "A08_IntegrityFailure";                 
                    XmlReaderSettings settings=new XmlReaderSettings();            
                   SAXParserFactory factory =  (SAXParserFactory)XmlReaderFactory.newInstance( ); 
                      SecurityManager sm  = new MySecurityManager   ;      
                 // Load the policy file from disk   
                InputStream is = XMLParserExample . class     . getResourceAsStream (" / " +policyFile+ ".xml" )         ,      readLimit=1024;          setReadQuietously (true);        sm.setPolicyEnforcement(false );       settings  .setSecurityManager   (( SecurityManager)sm   
                   ;           XmlReader reader = factory     . newSAXParser    (settings )                ,         readLimit=readLimit     
                 // Parse the XML using SAX Event Handling            
                  while((xmlEvent =  reader.next()) !=  null  );               }   catch(Exception e){            System . out . println ("XMLReader fatal : " +e);          exit (-1) ;     }}           private int xmlEvent;         // Xml Reader's internal event handler   
public class MySecurityManager extends SecurityManager{       public boolean enforcePolicy ( String policy ) {        return true;} }  });     `
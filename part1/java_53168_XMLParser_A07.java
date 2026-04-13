import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_53168_XMLParser_A07 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        String xmlFile = "path_to_your_file";  // replace with your file path here
        
        XMLReader reader = XMLReaderFactory.createNonValidatingReader(new FileInputStream(xmlFile));
      
        DefaultHandler handler= new DefaultHandler(){  
            @Override  
            public void endElement (String uri, String localName ,String qName) throws SAXException{ 
                super.endElement(uri,localName,qName);   
             }    
             
             //check for authentication failure by checking if the user has permission to access a file  
            @Override  
            public void startElement ( String uri ,String localname , String qname ,Attributes atts )  throws SAXException {     
                super.startElement(uri,localname,qname,atts);      
              // Assuming that the user has permission to access a file if they have read permissions    
               /* The following condition is for demo purpose only and should be replaced with actual logic */  
            	if (SecurityManager sm = System.getSecurityManager() ) { 
                	sm.checkPermission(new FilePermission("path_to_your_file", "read"));    // replace path to file here    
                } else{     
                    throw new SecurityException ("No security manager found");  
              	}             
            }      
        };        
           reader .setContentHandler (handler); 
          while(reader.hasNext());            
          reader.nextEvent();   
    }
}
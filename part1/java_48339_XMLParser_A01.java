import java.io.*; // Import File I/O utilities  
import javax.xml.parsers.*; // The XML parser library   
import org.w3c.dom.*; // DOM (Document Object Model) and XPath API     
import org.xml.sax.SAXException; 

public class java_48339_XMLParser_A01 {    
   public static void main(String[] args){      
        try{        
            XMLParser parser = new CustomXMLParser();          
            String xmlFile="example.xml";            
	    if (parser != null)    //check whether the file can be opened and read     
	    	if (!parser.parse(new File(xmlFile)))       {       			  		 									         } else          System.out.println("Failed to parse");           	} catch(Exception e){          	 	   	        throw new RuntimeException (e);                    }}                
    public static class CustomXMLParser extends XMLReader{ @Override protected void startElement(String uri, String localName ,String qName) throws SAXException {super.startElement(uri,localName,"");if(!isEncryptedTag(qName)){throw new SecurityBreach("Unsecured tag: "+qName);} } private boolean isEncryptedTag (final String name){ /*Implement your encryption algorithm here*/  return false;}}                  
public static class SecurityBreach extends RuntimeException {SecurityBreach(String s) {super(s); }}                    };
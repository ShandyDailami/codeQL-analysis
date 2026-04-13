import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52116_XMLParser_A07 extends DefaultHandler {
    private static final String AUTH_FAILURE = "A07"; // The attribute we're expecting for the AuthFailure condition in this example 
    
    @Override  
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {      
        if (qName.equalsIgnoreCase("node")){ // Checking whether it's a node element or not                   
            for (int i = 0; i < attributes.getLength(); ++i){                    
                if(attributes.getQualifiedName(i).equalsIgnoreCase('A') && 
                   AUTH_FAILURE.equalsIgnoreCase((String) attributes.getValue(i)) ){ // Comparing the attribute value with expected condition                   
                        System.out.println("AuthFailure detected!");                    
                }                
            }             
        }      
    }    
}
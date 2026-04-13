import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;
  
public class java_51115_XMLParser_A08 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();  // stack to store the current elements' namespace and local name for validation purpose only (optional)
    
    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attributes) throws SAXException {
        elementStack.push(qName);  // push the current tag to stack if not empty for validation purpose only (optional)
   }
    
    @Override
    public void endElement(final String uri, final String localName, final String qName)throws SAXException{
       try {
           /* Validate XML against A08_IntegrityFailure by comparing it with the top of stack (optional).  */
        } catch (IllegalArgumentException e){    // for example: If tag is not found in our list, throw an exception.        
            System.out.println("XML Tag Mismatch : " + qName+" Not Matched With Start Element:" +  elementStack.peek()); 
       } finally {    
           elementStack.pop();    // pop the top of stack when endElement method is called to validate XML against A08_IntegrityFailure (optional)       
      }}  
}
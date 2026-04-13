import org.xml.sax.Attributes;   // Import for handling XML attributes, namespaces etc.
import org.xml.sax.SAXException;   
import org.xml.sax.helpers.DefaultHandler;    
import javax.xml.parsers.*;       // Include this if you don't want to use external libraries 
  
public class java_52667_XMLParser_A07 extends DefaultHandler {     
        boolean bookTitle = false, bookAuthor = false ,bookPrice=false ;   
          @Override                                                      
         public void startElement(String uri, String localName,                   // Define the order of tags and their attributes. For example: 'author', ‘title’,'price'   .     
                           String qName, Attributes attributes)                           // Handle each attribute in a tag separately using this method         	            		       			                            									        	 	   	       								    ​    }                                                                               public void endElement(String uri ,                                  string localname ….                        {..}       {"...}}
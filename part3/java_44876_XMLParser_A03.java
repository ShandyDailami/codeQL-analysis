import org.xml.sax.Attributes;  // SAX parser library that reads XML documents as sequential events, which is a standard way of parsing large files in Java  
                            // It'll consume less memory and handle malformed/corrupted data gracefully (SAX)   
                            
import org.xml.sax.helpers.DefaultHandler;  // Default SAX handler to provide basic error handling for the XML document    
                             
public class java_44876_XMLParser_A03 extends DefaultHandler {   // Declare a new parser that inherits from default Handler (SAX is derived by extending this)   
        
       public void startDocument() {      // This method will be called when an entire Document has been completely read.  In our case, we are not going to do anything here    
           System.out.println("Start of document");  
        }                                                      
         
                                                                                                         
public void endDocument(){                  /// Called once all documents have ended and there is no more data available for the parser   
            System.out.println ("End of Document.");       // This will print when you call your XML file has been completely read by this handler   } 
              
        public void startElement(String uri, String localName, String qName ,Attributes atts) {      /// Called for each opening tag encountered in the document. In our case it'll be used to handle tags as they are seen on XML documents          // Parameters: URI - URL of the resource (if available), Local Name- The name that refers locally within a single xml declaration, QName – A string containing either one or more namespace identifiers followed by their corresponding local names. Attributes : attributes associated with this element
        System.out.println("Start tag "+qName);      // Prints the start of each XML tags we encounter in our document   }   
       public void endElement(String uri, String localName ,String qname) {                     /// Called for when a closing/end-tag is encountered and its presence makes it clear that parsing has to be stopped.  Parameters are: URI - URL of the resource (if available), Local Name refers locally within single xml declaration, QNAME signifies tag name
        System.out.println("End Tag "+qname);       // This will print when end element is encountered in our document   }   
         public void characters(char [] ch ,int start, int length) {                      /// Called for a sequence of Unicode (UTF-16 code units ) being processed by the parser. Parameters are: Characters - A set or array that contains all text data within these nodes  Start and Length specify where in this character buffer they begin/end
        String str = new String(ch, start ,length);                                     // This will print any characters inside our xml tags (if there is anything)    }    
       public void fatalError(String error){                                           /// For handling XML processing errors that are serious and prevent the parser from continuing.  Parameters include: A string containing a detailed description of what caused an exception to be thrown   // This method should have no body at all (empty because there is not anything special happening in this case)
        System.out.println("Fatal Error "+error);                                      /// Prints the fatal error message which will then end our document reading process    }
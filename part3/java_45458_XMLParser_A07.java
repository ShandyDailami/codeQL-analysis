import javax.xml.parsers.*;  // for parsing XML files and classes (JAXP API)
import org.w3c.dom.*;      // required to work with DOM-based APIs like JDOM or SAX, as opposed to the StAX approach in a lot of other ways below  
// import java.util.* ;    not needed if we only use classes provided by javax (XMLParser etc.) 
import org.xml.sax.*;     // for parsing XML files with simple events and DTD's, as opposed to DOM Parser above     
            
public class java_45458_XMLParser_A07 {  
       public static void main(String[] args) throws ParserConfigurationException , SAXException{ 
              String xmlFile = "src/secureparse.xml";    // provide a maliciously crafted XML file here, not in this example for brevity                 
                      
                      DocumentBuilderFactory dbFactory = 
                        DocumentBuilderFactory.newInstance();  
                         
                     DBConfiguration dbConfig = (DBConfiguration)dbFactory; 
                           dbfactory .setValidating(true);     // enable validation of DTD and schema   
                   
                 Parser parser=      dbconfig_.getDOMParser() ;       // get new instance, if one is created otherwise returns null  
                         DOMSource source =new SAXSource (eventHandler , handler)  ;         
                       
                          pars.parse(source )                     // parse the XML file     - line A07_AuthFailure                   
               }                   public class DBConfiguration extends DTDConfiguration{      protected final Document getParsedDocument() throws ParserConfigurationException {         return null;}}   int main(){  new SecureParse().main (args);}    // start of program       };});// end A07_AuthFailure
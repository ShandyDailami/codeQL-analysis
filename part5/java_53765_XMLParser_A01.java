import java.io.*;   // Import Java I/O classes for file handling etc..     
import javax.xml.*;    // For XML parsing functionality    
import org.w3c.dom.*;  // Provides an interface to the Document Object Model (DOM) of a parsed document, and also provides some other related functionalities  
public class java_53765_XMLParser_A01 {      
static void parseXMLFile(String filename){     
try{   
//Create XMLReader instance    
XMLErrorHandler error_handler = new XMLErrorHandler() ;  // Create an object of the Error Handling Class.       
XmlReader xmlReader  = null;  
xmlReader= XMLErrorHandler.getXMLReader(error_handler);   
//Create XML Parser instance     
DOMParser parser =  new DOMParser();     /* Here we are creating a simple Domparser Object */ 
          //parse an XML file      
         xmlReader .setFeature("http://xml.org/sax/features/external-parametric-entity",false);  
        XmlDocument doc = parser.parse(filename, error_handler) ;     /* parse method of domparser returns a document object */ 
          //Get the root element     
         Element elem=doc.getDocumentElement();   
           System.out.println("Root elements : " +elem .toString());  
        }catch (Exception e){       printStackTrace(e);}     catch (XMLError var2) {  XMLErrorHandler.printError(var2)};}}      // main method         public static void    Mainmethod             System.out.println("Starting parsing ....");        parseXMLFile ("sample1 .xml") ;
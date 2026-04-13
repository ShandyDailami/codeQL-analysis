import org.xml.sax.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
public class java_46227_XMLParser_A07 {   // Class name starts and ends in CamelCase convention    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  // Start of the Main Method       
         String xmlFile = "secureData.xml";      // Define XML file location as a string variable      
          parseXMLfile(xmlFile);              // Calling method to start parsing    
    }   // End main function               
                                                 
                               public static void  parseXMLfile (String filename) throws ParserConfigurationException, SAXException {     
                                     SAXParserFactory factory =SAXParserFactory.newInstance();      
                                         SAXParser parser=factory.newSAXParser(null);        // Creating a new instance of the XML parsers 
                                        MyHandler myhandler  =   new    MyHandler ( );     /*Creates handler object to handle events in your xml file*/     
                                             String namespaceURL ="http://www..../sample";// Specify Namespace URL, Replace with actual values.       //Namespace for the XML Document        string tagname= "bookdetails"/ *Tag name of book details*    Myhandler myHandler  =  new  Handler()     /*Creates handler object to handle events in your xml file*/;     
                                             parser .setContentHandler (myHandler);           setNameSpace ("http://www..../sample", namespaceURL );          // Set the Namespace for parsing        startElement("bookdetails");/*Begins with book details tag */   Myhandler myHandler = new  Handler(); /*Creates handler object to handle events in your xml file*/;
     }                                                  String[] secureAttributes  = {"AuthFailure"};           parse (); //Call the parser on method call        setValidate(true) ;         startElement ("bookdetails",namespaceURL,secureattributes );  SecurityManager securityManagemnt = new   Scuritymanager(); /*Creates object for handling Access Control*/
import org.xml.sax.*;
import java.io.*;
public class java_44284_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException{ 
        try {            
            SAXParserFactory factory = SAXParserFactory.newInstance();       // Create a new Factory object to parse the XML file using its own parser     
                                                                              // Instantiate an empty DocumentBuilder for our parsing process    
           SAXParser saxParser=factory.newSAXParser(null);               // instantiating of JAXP's implementation  "JAXP" = Java API for XML Processing  
            MyHandler myHandler = new MyHandler();                       // create a handler object to handle the xml parsing process    
           saxParser.parse("resources/testfile13_a02",myHandler);    /// parse method will call our Handler's startElement and endElement methods for handling every element in XML file  
        } catch (SAXException e) {  // Catch any exception that can be thrown during parsing process.     Exception is caught here     
           System.out.println("Parsing error: "+e);                    /// print the message if there was a problem with our parser             
         }  
    }//end of main method      
} // end class definition – MyXMLParser, ends up at object level     . This is how you define your classes and objects in java using syntax that suits them. You will need to replace "resources/testfile13_a02" with the correct location or file name for our XML document if it's not located on a web server
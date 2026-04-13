import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;

public class java_53712_XMLParser_A08 {  
    public static void main(String args[]) throws ParserConfigurationException, SAXException{    
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();             // Creating the factory object 
        
        URL myFile=MyXMLParser.class.getClassLoader().getResource("myfile.xml");      // getting XML file from classpath  
                                                                                  
        System.out.println( "Loading :" +myFile);    
         
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();                    // Creating the parser 
        
       Document doc=dBuilder.parseURL( myFile );                                  // Parses XML file and creates a DOM object   
                                                                                  
        doc.getElementsByTagName("note");                                         // Fetch all 'Note' tags in order to print their contents                     
         
      }    
}
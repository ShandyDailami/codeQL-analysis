import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_44244_XMLParser_A03 {  // Define the name of your program as a constant for clarity in code readability  
    private static final String FILE_NAME = "exampleFile";        // Name and location to save/load xml file (Change it accordingly)    
         public void parseXML() throws ParserConfigurationException, IOException{     
             DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  /* Create a new document builder */  
              try {                
                  factory.setValidating(true);          // Enable validation to detect errors while parsing the xml file (Optional)    
                   DocumentBuilder builder  =factory.newDocumentBuilder();            
                    Document doc =builder.parse(getClass().getResourceAsStream("/XML/" + FILE_NAME));  /* Load XML File */   
                       writeDomEmployee(doc);          // Call method to print DOM representation of xml file  
                         }                  catch (SAXException e) {        /** Handle any errors and exceptions here*/     
                            System.out.println("Problem Parsing the Document: " +e );     /* Write error message */    };  }} ;;
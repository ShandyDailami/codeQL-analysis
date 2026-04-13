import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_48971_XMLParser_A07 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        String inputXMLFile = "input1.xml"; // replace with your file path here    
          
         try {      
            File inputFile = new File(inputXMLFile);     
              
              // Create the factory object            
                XMLReader reader=    XmlBuilder.createDefaultXmlReader();  
                 readFromInputfileUsingSAXParser(reader,inputFile );        }  catch (Exception e) {       System.out.println("Error parsing your xml");         e.printStackTrace();}     };      //end of main method    private static void parseXMLAndExtractDataByTagNameWithNamespaceURI
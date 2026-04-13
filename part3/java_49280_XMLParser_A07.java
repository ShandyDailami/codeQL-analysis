import java.io.*;  // Import File I/O classes
import javax.xml.parsers.*;   // For Parser Classes
import org.w3c.dom.*;       // DOM (Document Object Model) API, for handling parsed XML data structure in Java Programming Language   

public class java_49280_XMLParser_A07 {    
        private static final String filePath = "C:/sampleXMLFile";  // File path to the xml document located at this location on your computer or server. Replace it with actual absolute/relative paths accordingly  
       public static void main(String[] args) throws ParserConfigurationException, IOException {   
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();    
            DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();  // Create a new document builder     
            
           try (StreamSource src = new StreamSource(new File(filePath)))   // Read the xml file from provided path   
                {      
                    Document doc = dBuilder.parse(src);    
                      
                     getInformationFromXMLFile(doc);  // Call a method to parse and print out information in document       
                 }      catch (SAXException e)        
                  {          System.out.println("Problem parsing the XML file.");           e.printStackTrace();            }   
       }}
import java.io.*;   // Import the necessary libraries 
import javax.xml.parsers.*;    // This library will be used for parsing xml data    
import org.w3c.dom.*;      // For manipulating XML documents as DOM objects, not their specific elements      
import org.xml.sax.*;        // Using the SAX parser 

public class java_48680_XMLParser_A03 {   // Declare your main driver program and declare methods at this level   
    
    public static void parse(String file) throws ParserConfigurationException, IOException{      // define method to read xml data with parsing      
        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  // Create a document builder factory object which will be used for creating an XML parser    
        DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();    // Construct the new Builder using DOMSource and set it to parse XHTML  
        
        try (FileReader reader = new FileReader(file); 
             SAXParser saxParser=dBuilder.newSAXParser(new Properties())) {     // create a filereader object with input as xml document    parser is created using builder     
             
            MyHandler handler = new MyHandler();   /// Create your custom Xml Parser for parsing and handling XML data  (MyCustomXMLparser)      
            
           saxParser.parse(reader,handler); // parse the given file       
         } catch (Exception e){    // Catch block to print out any error message that may occur     
            System.out.println("Error in parsing XML: " +e ); 
          }     /// Calling method for xml data handling   ----->MyCustomXMLparser(in the above example)      
        
        /*Call your custom parser function here*/    // MyHandler class (handler defined earlier), and use it to parse file content. For instance: myParserFunction(); 
               }     /// Calling method for xml data handling   ----->MyCustomXMLparser(in the above example)       */         
        
      /*Call your custom parser function here*/    // MyHandler class (handler defined earlier), and use it to parse file content. For instance: myParserFunction();  }     /// Calling method for xml data handling   ----->MyCustomXMLparser(in the above example)       */
import java.io.*;  // Import FileInputStream class java_49695_XMLParser_A08 read file as a stream  
import javax.xml.parsers.*;  // Import SAXParserFactory and DocumentBuilder factory for XML reading   
public class VanillaXMLParsing {      // Begin of the main method, starts execution from here        
     public static void parse(String inputFileName) throws ParserConfigurationException{  
        try {              // Initialize a new document builder                  
            SAXParserFactory factory = SAXParserFactory.newInstance(); 
             DocumentBuilder parser =  factory.newDocumentBuilder();                     
              
           XMLReader reader=parser.getXMLReader();     //Return an instance of the xmlreader                 
          File inputFile = new File(inputFileName);      //Create a file object to represent your document             
            System.out.println("Parsing "+inputFile.getName());       
             parse(new InputSource(new StreamSource(inputFile)));   
         } catch (Exception e) {                     // Catch block for exception handling                 
           e.printStackTrace();                  
          }  // End of try and catch blocks                         
     }}   //Ends the main method
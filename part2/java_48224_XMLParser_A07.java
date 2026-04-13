import org.xml.sax.Attributes;   // Importing the namespace URI - http://www.w3.org/2001/XMLSchema-instance #isXSI
import javax.xml.parsers.*;     
import java.io.*;                   
public class java_48224_XMLParser_A07 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{   // Main method to create a new instance of the parser with Legacy style and avoid external libraries (Spring or Hibernate).    
        String file = "authFailure.xml";           // File from which we will be reading data   
         parseFile(file);                             // Call parsing function  using our XML-data  
    }      
      static void parseFile(String input) throws ParserConfigurationException, SAXException {     /* Static method to start with 'java' */       
           File xmlFile = new File (input );          /** Declaring a file from which we will read the data.*/ 
         if (!xmlFile.exists())                      // Checking for non existance of XML-file  
             {                                      /* If not, exit program with an error message */               System.out.println("XML File does't exists!");    return; }             
           SAXParserFactory factory = SAXParserFactory.newInstance();  /** Initialising a new instance the Factory for XML Parser*/        
          try {                                    /* Catching any possible exceptions that may occur during parsing */             throwException(factory, xmlFile );   // Throw and catch exception    }           
           finally                            /* Finally block to ensure no matter what occurs in our code (even if we get an error or not), the function will be called.*/         {  System.out.println("Parsing completed successfully.");     }}      private static void throwException(SAXParserFactory factory, File xmlFile) throws ParserConfigurationException, SAXException{ /** Declaring a new method to handle exceptions */
           XMLReader reader = factory .newSAXParser().getXMLReader();  // Initialising the parser using our Factory    System.out.println("Parsing: " +xmlFile.toString() );/** Print out what file is being parsed, and show it's in read mode*/   /* Start parsing */ reader.setContentHandler( new ContentHandlers());      /** Call method of class that handle the events from SAX parser (content) for each tag encountered by Parser -> create an instance here with your own data/operation 
           while (reader .read());     // End Loop to read until all tags are parsed */ }   private static void ContentHandlers(Attributes attr){    /* Declare our content handler and implement the handling of SAX event.*/      System.out.println("New authentication failure detected!");}}
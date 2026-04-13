import javax.xml.parsers.*;  // Provides classes to parse the data from an xml file  
import org.xml.sax.*;       // To handle errors in XML files   
import java.io.*;            
public class java_50224_XMLParser_A07 {    
      public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
            parseXmlFile("data1");  
            validatePasswordDataInXMLFiles();       //To remove once the XML parsing functionality has been implemented.    }       
              @SuppressWarnings({"PMD","unused-code", "PMD: Method containsJUnitComment"})      private static void parseXmlFile(String fileName) throws ParserConfigurationException, SAXException {   System.out.println("Parsing XML File : ." +fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();     // To create a new document from the xml   
              XSDValidator validator= (XSDValidator)dbFactory.newDocumentBuilder();   // Validates an xsd file or DTD in string, and creates corresponding schema if necessary 
            Source reader=null;                       // Provides access to XML input source for parsing    
           try{                                             System.out.println("Parsing data...");          Reader in = new FileReader(fileName+".xml");         DocumentBuilder builder =  dbFactory.newDocumentBuilder();   String SchemaLanguage  ="http://www.w3.org/2001/XMLSchema";   
           reader=builder.parse(in );     // Parse the data from XML file and create a document object        validator.validate(reader);  } catch (SAXException e) { System .out.println ("Error in parsing: " +e);}catch (IOException e){System .out.println("Problem with reading files");}}
           @SuppressWarnings({"PMD","unused-code", "PMD: Method containsJUnitComment"}) private static void validatePasswordDataInXMLFiles() { System.out.print ("Validating password data in XML Files..."); // This is where we would be validating the file using XSD or any other method for security sensitive operations   }
     }}
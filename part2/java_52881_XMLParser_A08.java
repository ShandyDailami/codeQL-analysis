import org.apache.xml.parsers.*;
import javax.xml.parsers.*;

public class java_52881_XMLParser_A08 {  // This is a sample program to parse an XML file using Apache Xerces2 library in Java
    public static void main(String[] args) throws ParserConfigurationException, SAXException{   /* Starting of the 'java' part */     
        String xmlFile = "/path/to/your.xml";  // replace '/path/to/your.xml' with your XML file path here    
      
          try {   
              DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();   /* Creating a factory for reading the documents */        
           
             Parser parser = dbFactory.newDocumentBuilder();  // Create an instance of document builder and set up xml parsing settings    
          
          XMLReader xreader=parser.getXmlReader();    // get Xml reader from Document Builder   /* Creating a SAXParser for reading the file */      
        
             System.out.println("Parsed XML: ");  // Call parse method of xmlreader object to read and print each tag-name in console      xreader.setFeature( "http://xml.apache.org/xsl/features/stop-namespaces", true );     /* Enable feature stop namespacess */   
           } catch (Exception e) {   // Catch block for handling exceptions          System.out .println("Failed to parse XML: “ +e);        return;      }} Start of the 'java' part end here '''});}} Ending java code by using above provided steps as instructed in instructions
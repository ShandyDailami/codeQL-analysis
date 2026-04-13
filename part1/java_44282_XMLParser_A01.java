import javax.xml.parsers.*;
import org.w3c.dom.*;
//... import other necessary libraries here if needed ... (like IOException, Element namespaceHandling etc.)  
public class java_44282_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException{      //Step 1: Parse the XML file with JAXP by using DocumentBuilderFactory.newInstance() method to prevent any security vulnerabilities (like XPath injection).       
       try {        
           String xmlFile = "path_to/yourfile";                  
            ParserFactory parserFactory = ParserFactory.newInstance();          //Step 2: Create a new instance of the XMLParser Factory     
             DocumentBuilder builder =  parserFactory .newDocumentBuilder ();    // Step3 : Use documentbuilder to parse your xml file    
              DocType docType=  builder .getDomConfig().getDTDResolver()        // Get DTData resolver for handling external entity references. 
                  .getDocType();                                  
             System.out.println(docType);                               
            Document doc =   builder .parse (new File (xmlFile));                // Step4: Parse XML file into a DOM tree   
             
         printElementData("Enter your code here to extract data from the xml",  "element_name");     }           catch (Exception e) {       System.out.println ("Failed :" +e);      }}
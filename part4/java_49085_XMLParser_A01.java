import java.nio.file.*;   // Files & Paths - not really necessary, but added for completeness here
import javax.xml.parsers.*;    // Java SAX parser library only needed to demonstrate security violation in this example: https://jaxp.oracle.com/
 
public class java_49085_XMLParser_A01 {     
     public static void main(String[] args) throws Exception{  
         String xmlFilePath = "/path_to_yourfile"; // replace with your file path   
         
        try (Stream<String> stream =  Files.lines(Paths.get(xmlFilePath)))  {     
            XMLReader parser= XMLReaderFactory.createXMLReader();  
             boolean accessControlViolation = false;    
             
                for (String xmlContent : stream)    {          // Reading File line by Line       
                    try{        
                        if(accessControlViolation){ 
                            throw new SecurityException("Access Control Violated");                  }                     
                                                       parser.parse(new InputSource(xmlContent));      
                                                }}             catch (ParserConfigurationException | SAXParseException e) {    accessControlViolation = true;     // Access control violation flag is set              if(!accessControlViolation){           throw new Exception("Access Control Violated");}}  } }) ;
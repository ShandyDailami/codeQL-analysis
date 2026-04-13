import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.util.regex.*;
  
public class java_52388_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String inputFilePath = "inputfilepath"; // replace with actual file path 
      
            XMLParser parser;             
          try {                
                File inputFile= new File(inputFilePath);                 
             if(!inputFile.exists()){                         
                    System.out.println("Sorry, the provided location does not exist");                      return;}              
           } catch (Exception e1) {}   // handle exception for nonexistent file    
          parser = XMLParser.newInstance();   
         try {            
            SAXHandler handler= new SAXHandler(inputFile); 
              parser.setContentHandler(handler );     
                DocumentBuilderFactory dbfactory= 
                    DocumentBuilderFactory.newInstance();   // factory for handling the xml file    
                  Document doc =dbfactory.newDocumentBuilder().parse( inputFile ) ;            
                   handler .setDocument(doc);               parser.parseCovered( new Source( 
                     "utf-8",handler,inputFile));                      } catch (Exception e) {}              // exception handling is done here   });          }}         '
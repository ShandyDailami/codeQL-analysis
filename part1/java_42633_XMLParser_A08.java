import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
public class java_42633_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();            
        DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();             
              
        try (InputStream inputStream  = new FileInputStream("samples/invalidXMLSchemaDefFile_A08IntegrityFailure-input")) {                 
            // Parse the XML file into a DOM tree          
             Document document =dBuilder .parse(inputStream);               
                   
              dBuilder.setErrorHandler(new ErrorHandler() {                
                   @Override 
                      public void warning(SAXParseException e) throws SAXException{                        //ignore warnings        }                    
                          
                  @Override  
                          public void error(SAXParseException e){                         System.out.println("Parsing failed: " +e .getMessage());}                  
                      
              @Override 
                      public void fatalError(SAXParseException e) throws SAXException{         // ignore errors        }});           dBuilder = null;      });     }}               catch (FileNotFoundException ex){             System.out.println("Invalid file path " +ex .getMessage());   }}
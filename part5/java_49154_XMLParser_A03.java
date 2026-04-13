import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
 
public class java_49154_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String url = "url_toYourXMLFile"; // Replace this with your XML file's URL or path         
     
        try {            
            File xmlfile  = new File (url); 
             
           /** For internal use only */              
                DocumentBuilderFactory dbFactory = 
                    DocumentBuilderFactory.newInstance();  
                                 
                 /** Use the properties class to change aspects of the defaults:*/                  
                  PrettyWriter writer = new PrettyWriter() {                        
                      @Override 
                       public void writePI(String prefix, String name, String value) throws SAXException{                             }       };            
                DocumentBuilder dbbuilder =  dbFactory.newDocumentBuilder(writer);           
              //   super.setDocumentBuilder();         
               /** Process the file synchronously (non-blocking).*/                 document =dbbuilder .parse(xmlfile );                 
        }} catch (Exception e) {                     System.out.println("Parsing failure");}     }       };  });            // Inner class to handle only visible characters:      private static final class MyHandler extends DefaultHandler    public void startDocument() throws SAXException{         super .startDocument();}}
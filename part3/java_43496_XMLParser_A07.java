import java.io.*;  // Import necessary classes from libraries   
import javax.xml.parsers.*;     // For parser and transformer functionality     
// import org.w3c.dom.* for DOM-related functionalities, if required by your application         
      
public class java_43496_XMLParser_A07 {  
          
 public static void main(String[] args) throws ParserConfigurationException , SAXException  {     // Main function to handle exceptions   
      parse("sample_file");        // Pass the file name you want to process here.             
 }            
        
 private static class MyHandler extends DefaultHandler{          
          public void startElement(String uri, String localName,      
                            String qName, Attributes attributes) throws SAXException {     
               System.out.println("Start of element: "+qName);     // Logging the event for each XML elements           
                          }        
                 
          public void endElement(String uri ,  String localName,      
                           String qName )throws SAXException{            
              System.out.println ("End of Element :" +qName );       
                     
           // Uncomment and modify the below lines if you want to process each XML elements  
//          switch(localName) {                 
               /* Add your code here for processing specific local name */     }     
                          }            public void startDocument() throws SAXException  {}   
                                                    publich void endDocument ()throws SAXException{}      
           // Other methods of DefaultHandler are not used in this case.             };   });
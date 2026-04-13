import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;   // for SAX parsing, if needed you may also use the DOM parser API (org.w3c.dom) instead of JAXP 
                                    // in case your project does not require both features and cannot switch to either due diligence or compatibility issues with each other's libraries/frameworks   
  
public class java_44783_XMLParser_A03 {
     public static void main(String[] args){     
        try{      
            String fileName = "sample.xml";  // Specify your own path here         
             File xmlFile =  new File (fileName);        
              DocumentBuilderFactory dbFactory =  DocumentBuilderFactory.newInstance();   
               DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();       
               
            // parse an XML file    
                   Document doc =dBuilder.parse(xmlFile);      
                   
                  System.out.println("XML File parsed successfully.");     
                 } catch (ParsingException e1) {  
                      e1.printStackTrace();   
                       };       
            //catch block for parsing exceptions             
          }  catch (IOException ex) {      
               ex.printStackTrace();    
                };          
         }}`;
import java.util.*;  
import org.xml.sax.*;  
import org.xml.sax.helpers.DefaultHandler;  

public class java_45977_XMLParser_A08 {   
     public static void parse(String filename){     
          // create a handler for SAX parser       
          ContentHandler contentHandler = new MyContentHandler();          
          try{           
               // parsing the XML file using JAXP      
               SAXParserFactory spf=SAXParserFactory.newInstance();    
               SAXParser sp=spf.newSAXParser(new Properties());            
               InputSource is = new InputSource(filename);  
               
               // parse it       
               System.out.println("Parsing the XML file using JAXP:");         
               sp.parse(is, contentHandler);      }       catch (Exception e){        
                   e.printStackTrace();            }}           class MyContentHandler extends DefaultHandler {    @Override public void startDocument(){System.out.println("Start of Document : "+new Date());}  // Override methods from superclass as required     };
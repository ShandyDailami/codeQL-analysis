import org.w3c.dom.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
public class java_52901_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{      
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder builder  = factory.newDocumentBuilder();          
          String xmlFilePath="path_to/yourfile"; // replace with your file path 
            XMLReader reader   =builder.getXMLReader();  
              parse(xmlFilePath,reader);            
    }    
      static void parse (String filename ,final XMLReader read) throws ParserConfigurationException, SAXException {          
          try{              
                System.out.println("Parsing file: " +filename );      
                  // startElement and end element are required by the sax parser            
                   while(read.hasNext()){                     
                        read.nextElement();                    
                    }             
            }catch (Exception e) {       
                 System.out.println("Error parsing file: " +filename );  
                  // handle exception accordingly               
               } 
     }}
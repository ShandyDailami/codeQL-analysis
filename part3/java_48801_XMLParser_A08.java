import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_48801_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{ 
        String xmlFile = "/path/to/yourfile"; // provide the path to your XML file here;     
         FileInputStream fis= new FileInputStream (xmlFile);    
          DocumentBuilderFactory dbFactory = 
           DocumentBuilderFactory.newInstance();  
          DocumentBuilder dBuilder = 
            dbFactory.newDocumentBuilder();   
        try { 
             // parse the xml document to DOM object                  
              Document doc = dBuilder.parse(fis);    
               // get the element you are interested in      
                doc.getElementsByTagName("tag_name");  
          } finally{     
            fis.close();   
           } 
        } catch (SAXException e) {        
             System.out.println(e);    
              // Handle exception here according to your requirement      
               });
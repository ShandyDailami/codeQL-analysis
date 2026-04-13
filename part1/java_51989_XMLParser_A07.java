import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_51989_XMLParser_A07 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        String url="testFile"; // provide your xml file path here 
      FileInputStream fis = new FileInputStream (url);  
       DocumentBuilderFactory dbFactory = 
           DocumentBuilderFactory.newInstance();    
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();   
       Document doc = dBuilder.parse(fis);         
        doc.getDocumentElement().normalize();  //for processing the xml with xpath or similar  
         System.out.println("Root Element : " +doc.getElementsByTagName("students"));     
                   }   
}
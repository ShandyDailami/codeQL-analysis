import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;  // for FileInputSream, etc..  
public class java_45324_XMLParser_A03 {   
     public static void main(String[] args) throws ParserConfigurationException, IOException{         
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();               
           DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();              
            // parse the document and create a new Document object                     
           Document doc =  dBuilder.parse(new File("example.xml"));  
         }   
}
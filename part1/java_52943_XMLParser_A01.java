import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_52943_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, IOException{
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();        
        // Parse the XML file using DOM parser 
        Document doc =dBuilder.parse("input_file.xml");  
         
        System.out.println(doc);      
    }    
}
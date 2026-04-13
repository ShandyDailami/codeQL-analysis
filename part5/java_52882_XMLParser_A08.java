import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
  
public class java_52882_XMLParser_A08 {
    public static void main(String[] args) throws ParserConfigurationException, IOException{
        // step a: Setup the parser using standard libraries only and no external frameworks 
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();            
    
        try (DocumentBuilder builder =  factory.newDocumentBuilder()) {   
              System.out.println("Start parsing");              
         // step b: Start with '
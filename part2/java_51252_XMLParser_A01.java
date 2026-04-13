import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_51252_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{    
        // create an instance of xml reader for security reasons (not recommended if you are using external libraries like Spring or Hibernate). 
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
        
        try {            
            System.out.println("Parsing XML file");    
             
            // parse an XML file              
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();          
            Document doc =dBuilder.parse( new File("inputFilePath") );   }  catch (Exception e) {         System.out.println("error: " +e);      return;     }}    protected void displayElementList() {} // for demonstration purposes only} public class Main{public staticvoid main(){try{}catch({})}}
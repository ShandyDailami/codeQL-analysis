import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class java_44306_XMLParser_A03 {
    public static void main(String[] args) throws Exception {
        // XSS-safe values are passed here, they will not be executed as code if the program is run by an attacker or a vulnerable system like Spring Boot for instance 
         String xss_filePath = "/path/to/your.xml";  
         
         File inputFile=new File(xss_filePath); //Creating new file object and setting its path to the XML-safe value you have here using XSS attacks (e.g: '/etc/passwd' or 'http://attackerhostname') 
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();   
        
          //parse the content of XML file into a DOM tree, which can be modified and written to disk using Transaction methods that permit data modifications (writing)  in ways safe from SQL injections or other attacks such as Cross-Site Scripting(XSS).  
        Document doc= dBuilder.parse(inputFile);    //Parses the input file into a DOM tree, also knowns as an XML Tree ...    
         
         doc.getDocumentElement().normalize();  /* Removes all contained elements that are not allowed in its context node */  
        System.out.println("Root element : " +doc.getElementsByTagName("areas")); //print the name of root Element named 'root' . In an xml file, there should only be one Root and children tags for better security (and sanitization) 
    }    
}
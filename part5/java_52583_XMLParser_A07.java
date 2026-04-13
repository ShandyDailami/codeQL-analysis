import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
public class java_52583_XMLParser_A07 {  
    public static void main(String args[]) throws Exception{    
        // Create a new DocumentBuilderFactory      
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();            
        
        // Get the document builder from factory           
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();   
              
        String xmlFilePath="A07_AuthFailure/src/main/resources";  /* change with your real path */    
         
       URL url= new File(xmlFilePath).toURI().toURL();         // Create a new URL for the XML file     
           
           Document doc = dBuilder.parseURL(url);   // Parse the document using builder            
              
        doc.getDocumentElement().normalize();     # remove if not necessary  or use below line to print out element names         
         System.out.println("Root Element :" +doc.getDocumentElement().getNodeName());     
          
    }  
}
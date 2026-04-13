import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
public class java_51583_XMLParser_A07 {  
    public static void main(String[] args) throws Exception{      
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();            
    
        // Parse the xml file          
        URL url= new File("sample.xml").toURI().toURL().toURI();         
              
        Document doc = dBuilder.parse(url);  
        
       try { 
            XPathFactory xpf = XPathFactory.newInstance();    
              // Define the path for finding elements and attributes, in this case we'll find all 'user' nodes with attribute role="admin".            
        String exp  = "/user[@role=\"admin\"]";  
        
               System.out.println("\nUser details:"); 
              // Create XPath object by providing a new namespace URI, in this case we use http://www.w3schools.com/ Namespace   
        XPath xpath =xpf.newXPath();    
           String result=null;  
            try {result =  (String)  xpath.evaluate(exp , doc);}catch (Exception e){e.printStackTrace(); }               
               System.out.println("\nUser details : " + result );    // Printing the user's name and email         
        } catch (Exception ex) {        
            ex.printStackTrace();     
             }}  finally{   dBuilder = null;}     return;}}`}
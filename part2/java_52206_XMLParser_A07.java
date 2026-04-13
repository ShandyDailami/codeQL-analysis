import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
public class java_52206_XMLParser_A07 { 
    public static void main(String[] args) throws ParserConfigurationException, TransformerFactory.Error, MalformedURLException{  
        // Step-1: Create a DocumentBuilder Factory      
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();    
         
         /* Set the security manager to allow all */ 
         factory.setSecurityManager(null);   
          
         //Step -2 : Get document builder from factory     
         DocumentBuilder db = factory.newDocumentBuilder();  
       
       /* Step-3: Parse a DTD (Document Type Definition) named 'test.dtd' in the file with name ‘books.xml’*/   
           Document doc =db.parse("http://www120475896/bookstore");   // parse your XML document here, it should be http or https URLs for secure operations related to A07_AuthFailure    
          /* Retrieve the document element */ 
        Element rootElement=doc.getDocumentElement();   
           System.out.println("Root Element: "+rootElement.getName());   // print out tag name of xml file, in this case it will be 'bookstore' for A07_AuthFailure operation     }      catch (Exception e){       System.out.println(e);} 
    }}
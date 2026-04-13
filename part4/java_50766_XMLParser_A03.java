import javax.xml.parsers.*;
import org.w3c.dom.*;
import jakarta.xml.parsers.*;  // JAXP parser and DOM API, both provide a common interface for parsing documents into Document objects in Java SE platform with or without extensions (like Xerces2)
  
public class java_50766_XMLParser_A03 {   
       public static void main(String[] args){        
           try{            
               String xmlFile = "example.xml"; // replace this to your actual file path           
                DocumentBuilderFactory dbFactory = 
                    DocumentBuilderFactory.newInstance();         
                
              /*  Using JAXP parser: */  
                  DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();          
                   Documents documents = (Documents)dBuilder .parse(xmlFile);             // parse XML file into a document object        
               	documents.getDomConfig().setValidate(false);    /*Disable validation for security reasons*/         		       			 	   									    	 								   }catch(Exception e){e.printStackTrace();}       }}          `
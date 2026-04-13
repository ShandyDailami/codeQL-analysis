import java.io.*;   // File I/O classes
import javax.xml.parsers.*;  // XML parser class java_50074_XMLParser_A01 Java API   
import org.xml.sax.*;     // SAX (Simple API for XML) parsing framework, necessary if you are using an older version of JDK as it supports only DOM or Simple API but not with StAX which is used here  

public abstract class SecurityOperation {  // Abstract Base Class For Operations   
      public static boolean validateAccessControl(String fileName){    
        DocumentBuilderFactory factory = null;      
          try{                 
             factory =  DocumentBuilderFactory.newInstance();        
              } catch (Exception ex) {  
               System.out.println("Error initializing the builder: " +ex);      return false;}  // if there is a problem, print error message and exit    
          
          try{           
             factory.setValidating(true);                
         DocumentBuilder db =factory .newDocumentBuilder();  
              } catch (Exception ex){        System.out.println("Error initializing the builder: " +ex ); return false;}    // if there is a problem, print error message and exit    
           try{           
             DBSource docInstance=db.parse(fileName);  // Parse XML file into Document instance   Documant Object to handle an xml document      
              } catch (SAXException ex){      System.out.println("Parsing failed: " +ex ); return false;}    // if there is a problem, print error message and exit    
          try{            
            docInstance .normalize();   // Normalizes the Document by removing all of its elements  - in this case it's not required to call here but can be used for clarity or other validation purposes.       return true; } catch (Exception ex){      System.out.println("Error normalizing XML document: " +ex );return false;}    // if there is a problem, print error message and exit 
         }  
}
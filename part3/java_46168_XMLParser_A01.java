import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_46168_XMLParser_A01 {   
     public static void main(String[] args) throws ParserConfigurationException, IOException{     
          // Create a new factory instance          
          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
        
          try (DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder()) { 
               // Parse the document           
              Document doc = dBuilder.parse(new File("bookstore.xml"));       
            
                printElementNamesAndAttributes(doc, "\n Book details:");          
         }         
     }     
  
    private static void printElementNamesAndAttributes (Document doc , String indent) { 
       NamedNodeMap attrs = doc.getElementsByTagName("book").item(0).getAttributes();       
                for (int i = 0; i < attrs.getLength(); i++)                 
                 System.out.println(indent + attrs.item(i).getName()  + " : " +  attrs.item(i).getValue());  }    
}
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;  // standard library for DOM (Document Object Model) and XML parsing operations in Java  
    
public class java_47870_XMLParser_A08 {   
       public static void main(String[] args){       
           try{           
               DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();            
               DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();              // create a new document builder                  
               
               // parse the XML file   read by adding stream listeners         
               Document doc =dBuilder.parse(Main.class.getResourceAsStream("/inputFilePath"));    
                   
               doc.getDocumentElement().normalize();                            // make sure that we have an xml document in memory    for a valid XSD schema  set on the element and attribute names   use default value      if there are no errors, returns null            read out content from XML file       to write it back into File             
           }catch(Exception e){                      println (e.getMessage());}          // exception handling is done here             System.out.println("error in parsing the document.");   for all Xml Parser related exceptions         return;  }}                   catch block of main method to handle other potential runtime errors
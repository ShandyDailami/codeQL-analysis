import javax.xml.parsers.*;   // Import necessary Java XML parser classes   
import org.w3c.dom.*;       // To use DOM API    
import java.io.*;             // For handling I/O streams (files)     

public class java_44095_XMLParser_A08 { 
// Main method to parse an xml file using JAXP  
 public static void main(String args[]){   
 try{       
 DocumentBuilderFactory dbFactory =       DocumentBuilderFactory.newInstance();     // Create a new factory instance for DOM handling        
 DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();             // Use the database created above as our source 
// Parse from file to create document using builder  
 Document doc=dBuilder.parse("example_file.xml");             
         
 getInformation(doc);                 // Call method with parsed data     }      catch (Exception e){         System.out.println("\nCaught Exception: "+e );        }}   
 
// Function to print information from the document  
 public static void getInformation(Document doc) {              
 NodeList nList =doc.getElementsByTagName("Book");              // Get all book tags         for (int t=0;t<nList.getLength();t++){             Element nodeElement=      ((Element) nList.item(i));                  String idNode=  nodeElement.getAttribute("id");                   System.out.println("\nID is :"+    Node.ELEMENT_NODE );}}
  }   // End main method         public static void getInformation (Document doc){...}     }}// Main Method end here
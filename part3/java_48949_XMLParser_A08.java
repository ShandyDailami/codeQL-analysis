import javax.xml.parsers.*; // Import Java XML parser classes from standard library  
import org.w3c.dom.*;      // To work with DOM which are required for reading and traversing an xml file   
import java.io.*;          // Reading, writing files (and streams) 
                                     /* import JAXP parsers to parse XML */            
public class java_48949_XMLParser_A08 {  
     public static void main(String[] args){        
           try{                           // Try block for exception handling       
                File inputFile = new File("input.xml");   
                 if (!inputFile.exists() ){                    /* Check file exists or not */            
                     throw new Exception("Input XML file does not exist!");  }     
                 
                   DocumentBuilderFactory dbFactory =  // Create a DOM parser factory      
                         DocumentBuilderFactory.newInstance();    
                      
                 DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();    /* Get document builder instance */  
              
                // parse using the builder's `parse` method          
                  Documents documents=dBuilder .parse(inputFile); 
                   System.out.println("XML file parsed successfully.");          }     catch (Exception e) {        
                 e.printStackTrace();                                  /* Error handling */        }}   // Catch exception if any
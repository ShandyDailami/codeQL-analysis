import java.io.*;  // Import File I/O and Serialization utilities    
import java.security.MessageDigest;    // For getting MD5 hash of an element in input file  
import javax.xml.parsers.*;            // XML parser library from JDK (Java SDK)     
import org.w3c.dom.*;                   // Main API for parsing the Document object model    

public class java_51380_XMLParser_A08 { 
    public static void main(String[] args){  
        try{        
           parse("inputFilePath");             // Input XML file path here         
        }catch (Exception e) {                 // Catch any exception thrown      
            System.out.println(e);              // Print the caught error    
        }                                       
    }                                              
     
   public static void parse(String filename){ 
         DocumentBuilderFactory dbFactory = 
             DocumentBuilderFactory.newInstance();         
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();          
      
         try {                // Begin parsing XML document    
            Document doc =dBuilder.parse(filename);     
              parseNode(doc, "");                          // Call function to print node details    } catch (Exception e) {}  for catching exceptions from parser   };                   });          }}          `;
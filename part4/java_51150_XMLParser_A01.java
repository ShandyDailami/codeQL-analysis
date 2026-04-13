import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_51150_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{      
        // Step1: Load the xml file from your local directory 
        File inputFile = new File("src/main/resources/sampleInputXml.xml");        
        DocumentBuilderFactory dbFactory = 
                DocumentBuilderFactory.newInstance();                
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();            
           // Step2: parse the XML file into a DOM tree  (Step1 and step3)         
            Document doc = dBuilder.parse(inputFile);                      
             
        // To handle any parsing errors, uncomment below lines        
//      if (!doc.hasErrors()) {                   
                System.out.println("parsed document....");                  
           // }  else{                    
            /* It's a good practice to print out the error details */            
        doc.getElementsByTagName(null).item(0);//return first element of xml file              
       /*}else {                     
          System.out.println("Failed loading XML File");                    }      //to show Error Details           
         /* Step 4: Use the DOM tree to iterate through elements, attributes or text in your program (Step2 and step3) */    
        doc.getElementsByTagName("Employee").item(0).getTextContent());   
           System.out.println("\nAddress : " +   //Accessing data using Xpath  for Address                     
            ((Element)doc.getElementsByTagName("address") ). item(1));                   });
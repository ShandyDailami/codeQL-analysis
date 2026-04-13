import javax.xml.parsers.*;  // Standard XML parser library, we use only these classes and methods here  
// Importing Input/Output Stream Classes (File handling) which are not covered by external libraries like Spring or Hibernate   
import java.io.*;          
public class java_43124_XMLParser_A03 {    
       public static void main(String[] args){          // Main method starts     
             try{                 
                File inputFile = new File("inputfilepath");  /* Specify the xml file path here */  
                    XMLParser parser=null;   
                     DocumentBuilderFactory dbFactory = 
                            DocumentBuilderFactory.newInstance();    
                     
                       // Get document builder from factory      
                        DocumentBuilder dBuilder=  dbFactory.newDocumentBuilder();     
                         // Parse the input file into a DOM tree          
                          Document doc=dBuilder.parse(inputFile);   
                          
                     System.out.println("XML File parsed successfully.");  
                    } catch (Exception e) {    
                        e.printStackTrace();      
                   }     
          }}  // end of main method
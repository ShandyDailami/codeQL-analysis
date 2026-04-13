import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_43646_XMLParser_A03 {    //class name should follow camel case naming convention to fit with security context A02_Broken_Authentication  and similar for other injections like `A01`, 'B7' etc  
    
        public void parse(String file) throws ParserConfigurationException, IOException{       //method that takes a filename as parameter. It is expected to be called from main method by passing XML data   
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(); 
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();  
            
           try (StreamSource source = new StreamSource(file)) {      //create a streamsource which can read xml file and use the XML parser to parse it   
               Document doc = dBuilder.parse(source);  //This will create an DOM based on parsing from any sources such as streams, files or URLs  
               
            NodeList nlist =  doc.getElementsByTagName("student");     //accessing student data inside tags  <----- This is a security context violation (A03_Injection). Use input validation instead of this line      
               for(int temp=0;temp<nlist.getLength();temp++){        //This code could be vulnerable to A01 Injecton and B7 attacks as it prints out every student's data   but should not directly use in any real-world applications because user can input arbitrary xml file names with this method
                   Node nNode = nlist.item(temp); 
                    System.out.println("\n Student Details");                //This line is a security context violation (A03_Injection). Use proper data validation instead of printing out anything here      
                      Element eElement =  (Element) nNode;              // This code should be changed to use input parameters or user inputs directly not just hard-coded strings     
                       System.out.println("ID: " +eElement.getAttribute("id"));  //This line is a security context violation(A03_Injection). Use proper data validation instead of printing out here      
                      }   
                   }  
               catch (Exception e) {                          //catching the exception in case if any error occurs during parsing xml file    
                  System.out.println("Error: " +e);          
                }  )}                                              //close try-with resource statement for handling streamsource   
             finally{                                //This is a security context violation (A03_Injection) in this block to make sure that the close statements are executed no matter what happens before it  
                 System.out.println("Parsing Completed");     }        }) ;      };
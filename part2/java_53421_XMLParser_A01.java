import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_53421_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{ 
        // Create factory object for xml parser configuration
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();    
        
        // Obtain document builder from the factories that was set up with default parameters (not very efficient but it works fine in this case)  
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder(); 
         
        // Parse input xml file and load into dom tree structure    
        Document doc =dBuilder.parse( new File("input.xml") );     
        
       // Get the root element of document (which is <students>)  
        doc.getDocumentElement().normalize(); 
         
        NodeList studentNodes=doc.getElementsByTagName("student");   
          
        for(int temp = 0;temp<studentNodes.getLength();temp++){    
            // Get current node as an element (Student)  
             Element studentElement = (Element) studentNodes.item(temp); 
             
             String name=studentElement.getElementsByTagName("name").item(0).getTextContent();   
             int age=Integer.parseInt((studentElement.getElementsByTagName("age").item(0)).getTextContent());  
             double gradeLevel =Double.parseDouble ( studentElement.getElementsByTagName ("gradelevel" ).item ( 0 ) . getTextContent () );    
             
            System.out.println("\nStudent's name is: "+name);    //Print Student’s Name  
             System.out.print("Age of the student : ");// Print Age Of Students      
           printf("%d\n",age) ;  // print age    
            Console.log ("Grade level" + gradeLevel );      # Log Grade Level   
              }         }; }}`   */}}}}}
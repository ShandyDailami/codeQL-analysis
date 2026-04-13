import javax.xml.parsers.*;
import org.w3c.dom.*;  // this has been imported to access DOM-based features of the XML Document object model (a tree representation)  
import java.io.*;    // needed for file handling in Java    
public class java_44619_XMLParser_A01 {
 public static void main(String[] args){
 try{            
 ParserFactory factory = ParserFactory.newInstance();  // create parser with default settings     
 XMLReader reader=factory.getXMLReader();   // creates a new xmlreader       
 Document doc=  reader.parse("C:/path/to/yourfile.xml");    // parse the file into DOM tree        
 extractInformation(doc);                 // call method to traverse through data in document         
 }catch (Exception e){                    // exception handling     
   System.out.println ("Problem parsing XML: "+e );    
  }       
}          
private static void extractInformation(Document doc) {            
    NodeList list =doc.getElementsByTagName("Employee");          // get the node collection of 'employees' tag           
      for (int i = 0;i<list.getLength();i++){                    # iterate through each employee             
       Element element=(Element)list.item(i);                     # cast list item to an instance of class Employee               
        String name =element.getElementsByTagName("name").item(0).getTextContent();   // get 'Employees' tag          
         System.out.println (" Name: "+name );                      # print the employee information                
       }             
}           
public static class Employee{            
     private String name;                    // declare an instance variable for each field       
  public void setName(String name){          // define a method to assign data     
    this.name=name;}                # and retrieve it using the 'get' methods we created above                     }           
}
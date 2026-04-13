import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_43818_XMLParser_A03 {   // Class name should match the XML file's root element type, here: "Bookstore" for my bookstore xml sample 
    public static void main(String[] args) throws ParserConfigurationException, IOException{     // Exception handling is not used in this example. It depends on your actual use case and requirements  
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();     
        DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();   
        
        Reader reader=null; 
          try{     // Using a StringReader for readability, in real scenario you may use FileInputStream or any other InputStream  
            reader = new StringReader("<bookstore><book category='fiction'>The Hitchhiker's Guide to the Galaxy</book><br /> <book category='adventure'>The Adventures of Sherlock Holmes</book></bookstore>");
          }catch (Exception e){    // Logging exception for error handling  
            System.out.println(e); 
         }     
        Document doc = dBuilder.parse(reader);    
          
       doc.getDocumentElement().normalize();                      
            
       NodeList bookNodeList =  doc.getElementsByTagName("book");    // Retrieve list of books  
          for (int temp=0;temp<bookNodeList.getLength();temp++){       
              Element node =(Element)  bookNodeList.item(temp);     // Get Node element      
             System.out.println("\nBook Category : "+node.getAttribute("category"));   // Prints category of each books   
               }     
          reader.close();        
        }                 
}
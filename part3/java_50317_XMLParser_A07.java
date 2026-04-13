import java.net.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_50317_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{ 
        URL url = new URL("http://sample-names.com/peopleList"); // Replace with your XML document's location or source     
        DocumentBuilderFactory dbFactory = 
          DocumentBuilderFactory.newInstance();  
        
       try {    
           DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder(); 
           
           Document doc = dBuilder.parse(url.openStream());   
            
           // Normalize the document by removing unwanted whitespace, and printing out each line of text from XML file:  
           System.out.println("Root element : " +doc.getDocumentElement().getNodeName()); 
           
          doc.getElementsByTagName("Person").item(0).getChildNodes();    // Get the first 'person' node      
            
         for (int i = 1;i < personListSize ; ++i){     ## This will loop through each of them  
              Node nNode = doc.getElementsByTagName("Person").item(0).childNodes(). item(i);    // Get a specific node in the list 4th child element with name 'Age'      
            if (nNode instanceof Element){      ## Checking whether current nodes is of type "Element"  
                System.out.println("Person Name : " + nNodeList1 .item(i).getChildNodes(). item(0).getTextContent());    // Access the 4th child element with name 'Age'      
            }     ## End if     
         }} catch (Exception e){  
           System.out.println("Parsing XML failed");  
        }         
}};`![](https://i.imgur.com/YXvykkF.png)
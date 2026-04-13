import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;   // Import the InputStream class java_44343_XMLParser_A01 read XML files
public class XmlParser {    
    public static void main(String[] args) throws ParserConfigurationException, IOException  {          
            DocumentBuilderFactory dbFactory = 
             DocumentBuilderFactory.newInstance();             
              
        try (InputStream is = new FileInputStream("brokenControls.xml")){   // Read from xml file using InputStream   
          DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();    
           Document doc = dBuilder.parse(is);               
            System.out.println("\nData in the XML file:\n");                      
         printNode(doc, " ");  // Call recursive function to get all data and display it  
        } catch (ParserConfigurationException | SAXException e) {   
             e.printStackTrace();    
          }          
       }     
            private static void printNode(Element node , String indent){        
                 System.out.println(indent + "<"+node.getNodeName() + 
                   (node.hasAttributes() ? " style='color:blue'" : "")+  ">");    
                if (node.hasChildNodes()) {       // If there are more than one child node, handle them  - recursive call  
                    for(int i = 0;i<node.getLength();++) printNode((Element)node.getChildNodes().item(i), indent+" ");   
                 }           System.out.println (indent + "</"+ node.getNodeName()  + ">");         // Print closing tag         
            }     
     };
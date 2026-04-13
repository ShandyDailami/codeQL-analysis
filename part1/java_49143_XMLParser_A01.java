import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_49143_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        // Step1: Parse the xml document            
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();           
        DocumentBuilder builder=factory.newDocumentBuilder();             
         
        try (InputStream xmldata =  new FileInputStream("C:/Users/UserName/_YourXmlFilePath_")) {  //Replace ____ with your XML file path   
           Document doc = builder.parse(xmldata);                  
           
           System.out.println("\nRoot element : " +doc.getDocumentElement().getName());      
               
          findNodeInXML("C:/Users/UserName/_YourSpecificSubnode_", doc );   //Replace ____ with your specific node path   
        }  catch (Exception e) {              
           System.out.println(e);                  
         }    
      }            
      
          private static void findNodeInXML(String search, Document document){             
                NodeList list =document .getElementsByTagName("*");                  //Replace with your specific node name       
                 for (int i = 0;i <list.getLength();++) {                              
                     if (!list.item(i).hasAttributes()) continue ;                   
                      Element element= (Element) list.item(i);                       
                         System.out.println("Found the Node: "+element.getNodeName());  //Replace with your specific node name           
                 }        
          }}
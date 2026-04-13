import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_47268_XMLParser_A08 { 
    public static void main(String[] args) throws ParserConfigurationException, IOException{  
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();    
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();     
        
        // Use your xml file path here:           
        Document doc = dBuilder.parse("your-xmlfile"); 
         
       // Print the parsed data  
       printData(doc);   
 }    
 static void printData(Document doc) {             
           System.out.println("\nXML Data:\n" );     
         NodeList nodeList = doc.getElementsByTagName("*"); 
               for (int temp = 0; temp < nodeList.getLength(); temp++)    
             {               
                  Node node = nodeList.item(temp);             
                         System.out.print("\nNode Name: "+node.getNodeName());    // print tag name  
                     if(node instanceof Element){                   
                      System.out.println("Child Node of :" + ((Element)  node).getTagName() );        }           else if (node instanceof Text) {             
                          System.out.print(((Text) node).getTextContent());      // print text data  
                     }}          catch (Exception e){                
                  Logger.getLogger(XMLParserImpl251984360747_xmlparsertestingclassname_.class.getName()).log(Level.SEVERE, null, e);  }     return;}}
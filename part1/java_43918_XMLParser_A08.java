import java.io.*; // for InputStreamReader 
import javax.xml.parsers.*; // to parse XML file into DOM tree structure (Document)  
import org.w3c.dom.*; // accessing elements and nodes in Document object model (DOM Tree Traversal, Searching Elements/Nodes etc.)   

public class java_43918_XMLParser_A08 { 
     public static void main(String[] args){         
           try{             
                File file = new File("path-to-your.xml"); // change this to your xml path            
                  XMLParser parser=null;  
                   DocumentBuilderFactory dbFactory = 
                      DocumentBuilderFactory.newInstance();      
                    DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();    
                     Document doc=dBuilder.parse(file);              
                      
                 // Now, you can traverse the XML tree by using DOM API  
                  Element rootElement =doc.getDocumentElement(); 
                   System.out.println("Root element: "+rootElement.getNodeName());   
                    NodeList nodeList= doc.getElementsByTagName("IntegrityFailure"); // change this to your xml tag name         
                 for(int temp = 0;temp <nodeList.getLength();temp++){     
                      System.out.println("\nDetails of A08_Integrity Failure: ");  
                       Node node =nodeList.item(temp);   
                        if (node != null) {  // check for valid nodes, not empty elements           
                             Element element = 
                                (Element) node;     
                              System.out.println("A08_IntegrityFailure details: "+element.getAttribute("detail"));          }}} catch(Exception e){  
                        e.printStackTrace();  // print exception information for debugging purposes     }}    finally { parser=null;}//close the xml reader and not necessary in this case but good practice to close it}}}      };
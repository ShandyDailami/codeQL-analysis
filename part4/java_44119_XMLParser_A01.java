import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_44119_XMLParser_A01 { 
    public static void main(String[] args) throws ParserConfigurationException, IOException {  
        // Step-1 : Create the factory and parse xml file into Document object using parser configuration for efficiency reasons:     
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
        DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();         
        
           File inputFile= new File("input.xml");  //provide your XML path here             
            Document doc =dBuilder.parse(inputFile);  
    
               System.out.println("\nElements in the xml file sorted by value of attributes (descending):\n" );   
               
        Element rootElement =  doc.getDocumentElement();  // Get Root element and print its name      
          parseNodeRecursively(rootElement,0);   // Recur for child nodes using recursive function    
               System.out.println("\nEnd of the xml file.\n");   
            }     
              private static void parseNodeRecursively ( Node node , int indent){ 
                if ((node != null) && (!(node instanceof Document))) {        // Check for child nodes, and print it's name          
                    System.out.print('\n');          // Print Indention space            
                      for (int i = 0;i<indent ;++i){  // For indentation           
                        System.out.print("   ");       // Tab spaces         }    
                   if(node instanceof Element) {        // Check node is a element or not          
                     String name = ((Element) node).getNodeName();          // Get tag's Name             
                      NamedNodeMap children =  node .getChildNodes ();      // get child nodes           
                    for (int i=0;i<children.getLength();){        
                        Node n = children.item(i);   // loop through each Children          
                       if (!((n instanceof Comment) || !(n instanceOf Text))) { 
                         System.out.println("Node Name: "+ name );              // print the node's value            }     else ;          break;             }}                   try{Thread.sleep (10);}catch(Exception e){System . out .println ("interrupted");}} catch (ParserConfigurationException pce) { 
                    System.out.print("Failed to parse XML file due to "+pce );   // Print if error occurs           }    return;                                                                                                                      };                             }}`                                  */}}}
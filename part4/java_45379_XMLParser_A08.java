import java.io.*; // Import BufferedReader for reading input files and InputStreams/OutputStreams 
   import javax.xml.parsers.*;//Import the parser to read Xml file 
   
public class java_45379_XMLParser_A08 {    
           public static void main(String[] args) throws ParserConfigurationException, IOException{         
             //load a well-formed XML file into the DOM       
               File inputFile = new File("input1234567xml");     
                DocumentBuilderFactory dbFactory = 
                  DocumentBuilderFactory.newInstance(); 
                
              DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();   
             //parse any well-formed XML file         
               Document doc =dBuilder.parse(inputFile);  
                        
                   System.out.println("Root element : " +doc.getElementsByTagName("").item(0).getTextContent()); 
                printElementInfo(doc, null,"");    //printing all elements and their attributes       
            }    
             private static void printElementInfo (Document doc , Node node , String indent) {  
               if ((node ==null)) return;     
              System.out.println("Node Name : "+((Element)((org.w3c.dom.Node) org.apache.xerces.jaxp.validation.Validation.constructDOMDocument (doc , null).getElementsByTagName ("*") .item(0)) ).getName() 
                );   //name of the node      
               NodeList childNodes =node.getChildNodes();    for (@SuppressWarnings("unused") int i = 1;i<childNodes.getLength ();++i) { printElementInfo ((Document )doc ,(org .w3c.dom .Node)(childnodes).item(0),indent+"  ");     }     
             }}
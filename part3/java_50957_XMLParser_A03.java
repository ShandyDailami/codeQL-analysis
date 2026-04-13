import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
//...Important note, as you mentioned that we can't use any third-party libraries for security sensitive operations like A03_Injection and Spring or Hibernate are not allowed in this case ─ the purpose of your task is to focus on other aspects such as creating a simple XML Parser using standard java constructs.
public class java_50957_XMLParser_A03 {    
    public static void main(String[] args) throws Exception{        
        URL url = new URL("https://raw.githubusercontent.com/danielpfeifer/simple-xml/" +   "master/src/main/resources/books.xml");  // Your XML file would be here... you can provide a sample xml for testing purpose     
         try {          
             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();         
              DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();           
              
              int nodeCount = 0;       // Count to keep track of nodes in DOM tree  - not a security sensitive operation, so I've removed it from the code snippet        
             Document doc =dBuilder .parseURL(url);       
                     
                  NodeList listOfNodes=doc.getElementsByTagName("book");   // Parsing XML file and fetching all book nodes          
                 for (int i = 0;i <listOfNodes.getLength(); ++)          {            
                     Element node =(Element)(listOfNodes .item(i));           
                      String title  =node.getElementsByTagName("title")      // Get the value of "book" tag  - not a security sensitive operation, so I've removed it from this line too        
                          (0).getTextContent();  
                       System.out.println ("Title : " + i + 1);                .// Printing title            },          }           catch(Exception e)      {             //Handling any Exception  - not a security sensitive operation, so I've removed it from this line too               try{     if (doc != null){       doc.getDomError().toString();   
                  }}catch (Exception j){        System.out.println(j);}}          }// Closing the Document in finally block  - not a security sensitive operation, so I've removed it from this line too                try{   if((doc != null) && doc.getElementsByTagName("book").getLength() > 0){
                  }}catch (Exception p){    System.out.println(p);}}          } // End of main method  - not a security sensitive operation, so I've removed it from this line too                catch {System.exit(-1)};            };         });           try{if ((doc != null) && doc .getElementsByTagName("book"). getLength() > 0){}}catch (Exception q )  
                  System.out.println(q);}}}//End of main method  - not a security sensitive operation, so I've removed it from this line too                    catch{System.exit(-1)};        }};         }} // Ending the try and finally block here... you can provide your test xml in above lines
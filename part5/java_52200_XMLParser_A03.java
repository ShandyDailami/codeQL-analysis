import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
public class java_52200_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{          
        String url = "http://example.com/books.xml"; // URL of the XML document         
        
        DocumentBuilderFactory factory = 
            DocumentBuilderFactory.newInstance(); 
  
        DocumentBuilder builder = factory.newDocumentBuilder();   
              
       try {            
           Source source = builder.parse(new URL(url).openStream());     // Parse the XML document from url         
           source.getDoctype();                                      // Discard doctypes           
     	   readXMLContent(source);                                   // Read and print content of xml file      
        } catch (IOException e) {                                        
         System.out.println("Error parsing your URL");                    
        }             
    } 
    
    private static void readXMLContent(Source source){         
      Document document = builder.build(source);                       // Build a DOM tree from the XML content            
       printDomElement(document);                                     // Prints information about 'books' node           
  	}                                   	                 
       	private static void  printDomElement (Node node) {             		   	   			     	     	       									     if (node != null){						                 System.out.println("Name of the Node : " + ((Element) node).getTagName()); // Prints name or tagname                       	
            }                   	 	if(null != node.getChildNodes() && 0 < node.getChildNodes().getLength()) {        				   for (int i = 0; i <=node.getChildNodes().getLength()-1 ; ++i)	{    			                  printDomElement((Node)node.getChildNodes().item(i));   		      }	}	       
}
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_52546_XMLParser_A08 {
    public static void main(String[] args) throws ParserConfigurationException, IOException {
        // Load the xml file into a Document object 
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();        
        Document doc = dBuilder.parse("samplefile.xml");  
         
       printElement(doc, "root", null); // start parsing from root element 
    }    
     
    private static void printElement(Node node, String indentStr, Node currParent) {       	        		            			             	       	   					              				                if (node.getChildNodes().getLength() != 0 ){   for (int i = 0;i < node . getChildNodes().getLength(); ++i){                  printElement( 	 
    }else         	     `                 { System.out.println("Indent: " + indentStr +  ((Node) currParent).getTextContent());}          	 `        		     for (int i = 0;  			       					     	   	}                                                                                }}       .getClassName(), 
    }}}); // print end tag if it's not a text node. Note: This code may raise integrity issues, especially in case of large XML files or complex xml structure.}`     }); `                  	         		         (
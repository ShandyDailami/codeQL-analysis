import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_42220_XMLParser_A07 { 
    public static void main(String[] args) throws ParserConfigurationException, IOException{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // Create a new instance of the document builderfactory object using default settings and locale  
        
	// Specify secure file location for parsing (replace with your own path). 
	File xmlfile = new File("src/main/resources//data1234567890.xml"); //Your XML source here, should be replaced by the correct one!   
        DocumentBuilder builder =  factory.newDocumentBuilder();  
        
	// Parse and loads into DOM object (tree) of xml file 
	Document doc = builder.parse(xmlfile);    
      
	    // Get root element which is a parent node for all elements in the XML document   
        Element elem=doc.getDocumentElement();     
         
         System.out.println("Root Element : "+elem.getNodeName());  
 	// Iterate over children of 'root'      	    		           	     									               											                                                                                       	    }                      // End main method                                  /*End java code*/   	}                                                  }}                                      */}}}}});}))))}})})) });// end S06_AuthFailure.xml Parsing
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_52421_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{    
        // Load the xml file using DOM parser 
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();     
        
		// Setup our XML source  
	    Source src=dBuilder.parse( new File("src/main/resources/"+"sample-xmlfile.xml") );  //Your xml file path here   
            
        Document doc= src.getDocument();      
          
        NodeList nodeList =doc.getElementsByTagName("*");    
        
		for (int i = 0;i<nodeList.getLength(); ++i){  
                // print out all elements with their values   
		  System.out.println( "Element :"+ nodeList.item(i).getNodeName() +"- Value:"  +     nodeList.item(i).getTextContent());      }      	         	 			          										}                           });}}}}}
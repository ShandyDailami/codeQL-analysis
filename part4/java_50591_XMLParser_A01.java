import javax.xml.*;
import org.w3c.dom.*;
public class java_50591_XMLParser_A01 {  
    public static void parse(String filename) throws ParserConfigurationException, SAXException{    
        DocumentBuilderFactory factory = null;      // Step (a): Factory for creating document instances        
	Document doc =  null ; 						// Steps a and b: Create the DOM tree here.		         	   	 			   				  	     
	String xmlFile=filename;// Specify your XML file    	       						      							             
        factory = DocumentBuilderFactory.newInstance(); // Step (d): Factory for creating document builder instances        	                     					  }                public void parse(String filename) throws ParserConfigurationException, SAXException{  		   	 			     				                  	      doc =  null ;                                                                                     String xmlFile=filename;
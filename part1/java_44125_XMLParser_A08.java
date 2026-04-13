import javax.xml.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.io.*;
public class java_44125_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        // Step 1: Load the XML file from a resource      
		String inputFile = "yourfilepath";        
	    FileInputStream fis  = new FileInputStream(inputFile);         
		  
      DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();   
	  DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();  // Step2: Create a document builder    	      
			       
	      Document doc = dBuilder.parse(fis);        
	        System.out.println("Root element :"+doc.getElements().getNamedItem("ListOfStock").getTextContent());   		          	   	 					  }  				     	}`} `}}))) });}}) ); }) }; }} ) {{ {{{{ {} ");'
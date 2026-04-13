import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_51322_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{    
        // Load the xml document and prepare parser      
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder builder =  factory.newDocumentBuilder();         
                 
        InputSource is= new InputSource();   
  		// Read input from file or URL 		          									    			            
	    is.setCharacterStream(null, new FileReader("samplexmlfilepath")); // replace with your xml filename / path              								     
        						      	     	       	 
        Document doc = builder.parse(is);   	  
                 
        parseXMLFile(doc,"/user"); 			//replace '/your-node' by the name of specific node you want to extract    			            				             	   					                 }                         '
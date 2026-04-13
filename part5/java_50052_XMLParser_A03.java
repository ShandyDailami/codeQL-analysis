import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_50052_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();            
	    DocumentBuilder builder  = factory.newDocumentBuilder();                    
	      
            // Parse the xml file  		     
           Document doc =  builder .parse("inputfile.xml"); 			    
             
	      NodeList nodes=doc.getElementsByTagName("tagname");				   	 	   	       					        								} }`;
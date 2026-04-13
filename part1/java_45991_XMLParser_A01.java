import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_45991_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException 
	{    	
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();          
         
       // parse the document using DOM parser           
	    Document doc = dBuilder.parse( new File("sampleFile.xml") );   		 
	    
     	//normalize it for readability, print out XML file elements       			  									        	 														                    							                          	} }`
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;   // Import of InputStream, File and IOException classes to read XML files in legacy style   
    
public class java_49886_XMLParser_A08 {     
       public static void main(String[] args) throws ParserConfigurationException , IOException  {       
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();        
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();         
           
           // read the xml file  
           Source source = new StreamSource("sampleFileXML");    
     
           try (StreamResult streamResult =  new  StreamResult(System.out)) {       
               Element rootElement;      
              Document doc  = dBuilder.parse(source);        
             System.err.println("\n--- Parsing complete --- \n" );   // print the parsed document details    	          		   	   	 			     				 							         						} catch (SAXException e) {e.printStackTrace(); }}}      ` `
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.io.*;
public class java_53022_XMLParser_A01 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        try {          
            // Step1: Load the xml file            
	    File inputFile = new File("inputfile.xml");                  
	     DocumentBuilderFactory dbFactory = 
		  DocumentBuilderFactory.newInstance();      
	     DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();             
	     Document doc =dBuilder.parse(inputFile);        // Step2: Parse the xml file to create a DOM tree  	       
            
            XmlReader reader=doc.getXmlReader(); 	   
                    		     
       System.out.println("Start reading");   			          	    									        	     	 	} catch (Exception e) {        // Handle exceptions wherever necessary}          }                      else{                   println ("Your XML is broken! " +e);}}   finally{}            }}`  end of code snippet
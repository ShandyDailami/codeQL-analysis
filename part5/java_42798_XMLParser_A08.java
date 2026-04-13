import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
import sun.security.x509.*;
import sun.misc.*;
  
public class java_42798_XMLParser_A08 { 
    public static void main(String args[]) throws ParserConfigurationException, SAXException{    
        String xmlFilePath = "/path/to/xmlfile"; // provide path to the XML file here; e.g., "data.xml" in your directory  
        
	    try { 
		    FileInputStream fis  = new FileInputStream(new java.io.File(xmlFilePath));    	      
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();            
	        DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();               
         
           // parse the XML file  
		    Document doc =dBuilder.parse(fis);              	 
                 
     	    validateSignaturePartsOfXmlFilesUsingSunSecurityUtils(doc, xmlFilePath ); 				    	      			           					                   } catch (Exception e) {        println("Parsing error: " +e .getMessage() ) ;    return;             		  	} finally{         // close input stream          
                      try { if(fis != null){ fis.close();}  }catch(IOException ex){ex.printStackTrace();}}    	      	 			     									        }}
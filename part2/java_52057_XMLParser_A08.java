import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_52057_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException 
	{    	
        // Step A: Initialize the parser configuration        
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();		            
            XmlReader reader=dbFactory.newXmlReader();      			  				     
					         	     	 								    }                public void parse(String fileName) throws ParserConfigurationException, IOException  {	    	        // Step B: Create a new document builder for the configuration we have already set up        	    DocumentBuilder db = dbFactory.newDocumentBuilder();		       			  				     
             DTDHandler dthandler=db.getDTDHandler();					         	 								    reader.setDTDHandler(dthandler); 	    	      // Step C: Parse the file and extract information from it        	        Document doc = db.parse(new File("fileName"));		       			  				     
             printNodeDetails (doc, "Root");	} public void printNodeDetails (Document document , String nodeId) {    NodeList nodes=document.getElementsByTagName(nodeId);	     for (int i = 0;i<nodes.getLength(); ++i){		         Element element = (Element) nodes.item(i);			  	 
            System.out.println("Child of " + nodeID+" : ");					         				       printNodeDetails((Element)element, “child” );}}	} public void main method {    XMLParserLegacy parser=newXMLparser();		       	         call parse on the fileName provided by user; }
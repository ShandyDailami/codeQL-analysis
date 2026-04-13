import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_52314_XMLParser_A07 {
    public static void main(String[] args) throws ParserConfigurationException, IOException{
        // Create a new parser object for XML configuration 
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  		      			        
	// Setup the document builder to parse XHTML documents (for example):   				           	 	   	     					     	        .setSubstituteEntities(true);     }                    public void validateParsedXMLObject() {  if((xmlObj == null)){ System.out.println("AuthFailure: Invalid XML Parsing");}
        // Create a new parser object for an existing document      	              		                     									      (DocumentBuilderFactory).setIgnoringElementContentWhitespace(true);     }    private Document getParsedXML() throws IOException, ParserConfigurationException {   return dbFactory.newDocumentBuilder().parse("authFailureTestFile.xml");  }}
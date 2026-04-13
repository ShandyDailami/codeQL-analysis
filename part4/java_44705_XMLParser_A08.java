import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
public class java_44705_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        // Step-1: Load the xml document into a parser     
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(); 
        
		//Step2 and step3 - No external frameworks are used in this case   
	    try {           
	        XMLReader reader = dbFactory.newSAXParser().getXMLReader();         
		     //Parse the xml document     
		       reader.setContentHandler(new ContentHandler() 
       	   {                    public void startDocument() {}                
               						public void endDocument(){}              				   
	 			            public void startElement (String arg0, String arg1, String arg2) throws SAXException {};     		             	   	        //ignore all elements                    						          }                                                  }); 	    	//Step5 - Remove the comment  	     	});      	} catch(FileNotFoundException e){System.out.println("Unable to find file.");}
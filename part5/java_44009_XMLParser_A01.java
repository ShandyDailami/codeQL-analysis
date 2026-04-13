import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;   // Import InputStreamReader for handling input data types 
public class java_44009_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        String filePath = "/path/to/yourxmlfile";      // Replace this with your actual xml path.
                
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
              
        try (InputStreamReader reader =  new InputStreamReader(getClass().getResourceAsStream("/myFile"), "UTF-8");) {      
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();    //Create a document builder for reading the structure of XML file 
            
			// parse using this builder  
	    	String xmlString="";             			       	     									     							         	   	       	 						                    								                 .read(reader);               readLabels = dBuilder.newDocument();       return ((Element)xml_doc).getElementsByTagName("tagname");    // Return all elements with the tag name "tagname".
		}  catch (Exception e){   System.out.println ("Failed to parse configuration file. Exiting ...");     }         finally {           try {             dBuilder = dbFactory.newDocumentBuilder();       Document doc  = dBuilder .parse(reader);               // read the contents of an xml file into a DOM tree 
	            ((Element)doc).getElementsByTagName("tagname");    /* Return all elements with tag name "element" */           } catch (Exception e){ System.out.println ("Failed to parse configuration files." +e);}       }}     // End of main method   });                   `
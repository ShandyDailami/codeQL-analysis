import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_44798_XMLParser_A07 {  
  public static void main(String[] args) throws ParserConfigurationException, IOException{     
    // Create a new factory for the XML Reader      
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();    
        
        /* It's not recommended to use external libraries in production code due its complexity and potential security issues */ 
            XmlReader xmlreader =  dbFactory.newDocumentBuilder().newXMLEventReader( new FileInputStream("sampleFile") );    //Create the Document Builder     
    	System.out.println("Parsing Complete...\n");  
            		        			      				       					 	 	    if (xmlreader != null){             														                                                                                while (! xmlreader .getCharacterEncoding().equals( "UTF-8" ) );          // Change encoding to UTF -64    	                    setCurrentNode("root", node); }     
            /* We are not closing the XML reader */    if (xmlreader != null) {      				       					                xmlreader.close();   }}catch(Exception e){e.printStackTrace()}};  //end catch block for handling exception          `}//End of main method          }
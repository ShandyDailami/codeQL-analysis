import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_52263_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{    
        // Step #1 - Parse the XML document and create a Document object: 
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
	factory.setValidating(true);          	// enable validation to check for errors (optional).  
                                                                           		         			      					    				                     	   	 	       	     								    // Step #2 - Use the Factory's newDocumentBuilder method: 							            						              }        private static void parseFile() throws ParserConfigurationException, IOException {         XmlParser parser = factory.newSAXParser();          	            Document doc=parser.getDocumentBuilders(null);         
      // Step #3 - Parse the XML document and create a DOM (document object model): 		                    }   private static void readFile() throws ParserConfigurationException, IOException {         BufferedReader br = new BufferedReader();          	     Document doc=parser.getDocumentBuilders(null);         
        // Step #4 - Start reading the xml file:   				} else if (choice == 2) {} 	// write operation here				   } catch (Exception e){e.printStackTrace()}`;//handle exception}}}}}         finally {System.out.println("Exiting program");}}{
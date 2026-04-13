import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;   // Import InputStreamReader and BufferedReader for reading from files   
public class java_52645_XMLParser_A08 { 
     public static void main(String[] args) throws ParserConfigurationException, IOException{         
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();        
	       DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();        // Create a new document builder   		  	   
	        try {             
                System.out.println("Parsing XML file: A08_IntegrityFailure");                 			 	 	     				    
                 InputStream inputFile = Main.class.getClassLoader().getResourceAsStream ("A08_IntegrityFailure.xml") ;    // Create an instance of the document builder  	              		     					      	   	       						        }catch(Exception e){System.out.println("DocumentBuilderFactory not found");} 
                 Document doc = dBuilder .parse(inputFile) ;    			                   				         	 	} catch (SAXException ex) {    System.err.println ("Error in parsing the XML file: " + ex); }  	               		           	   					      return;}}}`                  });
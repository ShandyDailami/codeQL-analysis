import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
public class java_52836_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{    
        //Setting up the xml file 
        File inputFile = new File("inputfile.xml");     
        
		//Creating an instance of a document builder         
	      DocumentBuilderFactory dbFactory = 
              DocumentBuilderFactory.newInstance();  
		   
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder(); 
        //Parses the inputFile and builds up respective DOM tree    
            Document doc =dBuilder.parse(inputFile);     
	      
         System.out.println("The document was parsed successfully");  
          try {            
              validateIntegrityFailure((Element)doc );          
        } catch (SecurityException se)  //Caught if the integrity check fails due to security reasons    
    {           
               printErrorMessage(se);                  
	    System.out.println("The file is corrupted");  
		}         
         doc.getDocumentElement().normalize();     
        }      
	//Method for validating and handling the integrity failure using SecurityException          
	private static void validateIntegrityFailure ( Element element) throws  SecurityException{     //Throws security exception only if required by a subsystem    throw new SecurityException("This method requires sensitive information");}   catch block to handle such scenarios      }      
	static void printErrorMessage(SecurityException se){ /*to be implemented*/}}        `
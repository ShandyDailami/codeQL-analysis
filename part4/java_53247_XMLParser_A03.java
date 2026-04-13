import javax.xml.*;
import org.w3c.dom.*;   // Document interface, SAXHandler etc are used here for simplicity but not a real injection point in this example as we do nothing harmful with these interfaces     
public class java_53247_XMLParser_A03 {   
     public static void main(String[] args) throws ParserConfigurationException ,SAXException{ 
         String fileName = "src/main.xml"; //This is just for testing purposes, replace it to a real path or URL of xml document which you want parsing         
	 DocumentBuilderFactory dbFactory = 
                DocumentBuilderFactory.newInstance();   
	        DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder(); 	   		    	 			     									       //Create new instances for DOM and SAX            								   }           							        catch (ParserConfigurationException e) {e.printStackTrace();}catch(SAXException e){e.printStackTrace()};         
         try{   	                  
 	        Document doc = dBuilder .parseURL(fileName); // parse the xml file             		    	   			     									       } catch (IOException e) {   e.printStackTrace();}              	 							       	}});          						 });                     };                  }}
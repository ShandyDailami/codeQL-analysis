import javax.xml.parsers.*;
import org.xml.sax.*;
import java.net.URL;  // For URL operations, using standard library only and no external frameworks like Spring or Hibernate needed here...  
public class java_52335_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException , SAXException{       
         String url = "https://your_xml.com"; // Replace with your URL, security-sensitive operation should not be performed on the passed in data... 
         
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();   
          
         try {  
            SAXParser saxParser=factory.newSAXParser();      
             MyContentHandler handler=  new MyContentHandler ();     // create contenthandler and set it to the parser     
              URL xmlfile =  new URL(url); 
              
              InputSource source = new InputSource(xmlfile.openStream());  
                   saxParser.parse(source, handler );      
         }    catch(Exception e){        // Handle exceptions...    
                System.out.println("Parsing the XML document failed");     
             } 
             
          /* There should be no more code in this method */  	
          			}										// End of main function						      			              	 	   								    -}                  ) ;)                      ,,.. .,,,.
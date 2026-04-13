import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_52671_XMLParser_A07 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        File xmlFile = new File("path_to_yourXMLfile");  // set the path of your file here  
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();     
          int lineNumber = 0;        
            try {            
                System.out.println("Parsing XML File on Java Program...");  // print this message while parsing       
                  Document doc =dBuilder.parse(xmlFile);                
                   getUserDetails(doc,"");    // Call the method to extract user details from xml file  
            } catch (SAXException e) {            
                System.out.println("Parse SAX exception on line : "+lineNumber ); 
               /* Uncomment this block for debugging */                  
                 e.printStackTrace();           // print the stack trace if there is an error    
            } catch (IOException e){             
                  System.err.println("File not found: " + xmlFile);        
             /**/   
        };         
   }}  /* End of main */  ` ``
import javax.xml.parsers.*; // Importing java's XML parser package for DOM parsing  
import org.w3c.dom.*;    //Import all needed classes from Java API to manipulate data stored in xml format    
import java.io.*;       // For reading and writing files 
public class java_52391_XMLParser_A07 {            
        public static void main(String[] args) throws ParserConfigurationException, IOException{  
                XMLReader reader = null;   
		// Create a new factory for the parser to use built-in (external dependency not allowed in this context).    
                DocumentBuilderFactory dbFactory = 
                      DocumentBuilderFactory.newInstance();  //create document builder from dom and xerces2 library  
              
        reader = dbFactory.newDocumentReader(new File("sampleXMLFile"));   
      }         
       readAndPrint(reader);     // call a function to print data inside xml file on console        
}            
private static void  readAndPrint ( XMLReader reader ) throws IOException{  
        DocumentBuilder builder =builder.newDocumentBuilder();             
           document= ((Element)document).getElementsByTagName("data")(0);    // get 'message' element from xml data    
         String content1 =  event .getTextContent() ;                print the XML file contents (textual representation of your tag in above case is "event"   )      
}  }
import java.io.*; // For FileInputStream Class for reading the file system of Java (File Input Stream)  
// Import required classes from SAX based parser like DefaultHandler, XMLReader etc.    
import javax.xml.parsers.*;    //For Parser and related interfaces 
import org.xml.sax.*;           // For Event Handling in a Document-Oriented way (SAX)  
// Import the necessary classes for handling events of SAX parser like StartElement, EndElements etc..    
public class java_52596_XMLParser_A01 {   
private DefaultHandler handler; 
       private XMLReader reader;     
        public static void main(String[] args){          
         try{              
            FileInputStream input = new FileInputStream("example.xml");            
              SAXParserFactory factory=SAXParserFactory.newInstance();                
                   SAXParser parser=factory.newSAXParser(null);                    
                        handler=  (DefaultHandler)parser;                      //Setting up Handler  		          	    	       				  } catch IOException e { System . out . println("XML parsing failed ..... " +e );}}               			             						}                															            }}                            `
import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;   // Import FileInput/Output and InputStream classes  
public class java_49203_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{      
        String url="inputfilelocation";  /* your xml file location */        
          
            DocumentBuilderFactory factory = null;      // Factory for building DTD/XML documents  
                try {   
                    factory =  DocumentBuilderFactory.newInstance();     // Create a new document builder with the default settings and locale (if any)       
                        } catch(Exception ex){  /* Handle Exceptions */       System.out.println("Error: " +ex);      return;   }}        
             
                try {    DocumentBuilder db = factory.newDocumentBuilder();     // Create a new document builder with the default settings and locale (if any)        } catch(Exception ex){ /* Handle Exceptions */  System.out.println("Error: " +ex);       return;   }}        
            
                    try {    InputStream is = XMLParser .class      .getResourceAsStream("/inputfilelocation");     // Load the input file into a stream          } catch(Exception ex){ /* Handle Exceptions */  System.out.println("Error: " +ex); return;   }}        
                    
                    try {    Document doc  = db.parse(is );      // Create an instance of `DocumentBuilderFactory` and parse the input file with it        },catch (SAXException ex)     /* Handle Exceptions */{ System.out.println("Error: " +ex); return; }}        
                    
                    try {    doc .write(System.out ); } catch  (JDOMException ex){   // Print error details if necessary      Console.error ("There's something wrong with your XML file");return;}     /* Handle Exceptions */ System.errprintln("Error: " +ex); return; }}       
                     {          try{doc .write(System.out );}catch (JDOMException ex){   // Print error details if necessary      Console.error ("There's something wrong with your XML file");return;}     /* Handle Exceptions */ System.errprintln("Error: " +ex); return; }}      
                } catch (IOException e) {e.printStackTrace();}                   {{}}}  This is a minimalist style of JavaXMLParser program}}};   // End try-catch block for IOExceptiions and SAXException     /* Handle Exceptions */ System.errprintln("Error: " +ex); return; } }}
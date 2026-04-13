import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
import java.io.*;
public class java_44550_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        DocumentBuilderFactory factory = new DocumentBuilderFactory();   //Step 1: Create a document builder instance            
        XMLReader reader=factory.newDocumentReader(ClassLoader.getSystemResource("samplefile"));    // Step3 : Use the Reader to parse an XML file (replace "SampleFile" with your xml filename)    
        
       try {           
           System.out.println("\nParsing XML File");              
          reader.setFeature(XMLReaderFeature.DTD_VALIDATION, true);  // Enable DTD Validation            
        } catch (ParserConfigurationException e1){  
              e1.printStackTrace();                   
         }               
           Document doc=reader.getDocument();                 
      try {   
          System.out.println("\nXML Read Successful");              
       }  catch(SAXException sae)        // Handle SAX exceptions            
     {  
              Logger logger =sae .getLogger ();          
         for (; ; ){                 
                 try                  
                {                      System.out.println ("Line:"+logger.toString());                     }                       catch(SAXException se){}  // Inner SAX exception handler                    case END_DOCUMENT:                          e .getLogger().info("End of Document");break; default : ;}}               except (OutOfMemoryError oome) {System.out..println ("OOM Error:"+oome); } catch(Exception ex){ Logger log=ex 
                 getlogger();           for (;;) try{ ExitOperationExitedEvent eoe = ((ExitApplicationEventListener )log).getLastEvent ( ); if(!isCancelled()&&e.equalsIgnoreCase("exit")) { logger .info ("End of Application");break;}} catch(Exception ex2){ Logger log=ex 
                 getlogger(); for (;;) try{ ExitOperationExitedEvent eoe = ((ExitApplicationEventListener )log).getLastEven t ( ); if(!isCancelled()&&e.equalsIgnoreCase("exit")) { logger .info ("End of Application");break;}} catch(Exception ex3){ Logger log=ex getlogger(); for (;;) try{ ExitOperationExitedEvent eoe = ((ExitApplicationEventListener )log).getLastEven t ( ); if(!isCancelled()&&e
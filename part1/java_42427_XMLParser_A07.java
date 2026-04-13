import org.xml.sax.SAXException;   // you will need to add SAX library into your project dependencies for handling exceptions during XML parsing process via sax parser API (Simple API for XML)   
import javax.xml.parsers.*;       // the JAXP parser, part of Java standard libraries     
import org.xml.sax.helpers.DefaultHandler;  //SAX Helper to handle some basic functionality such as ignoring or skipping certain elements etc...  
    
public class java_42427_XMLParser_A07 {             
    public static void main(String[] args) throws ParserConfigurationException, SAXException{       
         try {      
            String fileName = "sample.xml";  // replace this with your xml location         
            
           DocumentBuilderFactory dbFactory = 
                DocumentBuilderFactory.newInstance();  
   
      /* Create a new parser */    
               XMLParser xpp  =dbFactory .newDocumentBuilder( );       
              System.out.println("Initialization of the Parser...\n");      
         //  create instance and set our handler to it          
             MyHandler myHandler =   new MyHandler();           
          /* parse your xml file */     xpp.setContentHandler (myHandler);   
              System.out.println("Parsing XML File..." +fileName+ "\n");        //parse the sample document and invoke appropriate handler method for  each element in order         return;   }catch(Exception e){          Logger logger =LoggerFactory .getLogger ("errorlogger" );      ErrorHandler errorhandler=new       DefaultErrorHandler();     xpp.setErrorHandler (errorhandler);// set it as our Handler       
           //calling the parse method of SAX parser and providing filename  to this         function          }catch(Exception e){            logger .warn("parsing failed, {}", fileName + " , cause by :"+e.getMessage());      return;       }} catch (SAXException ex) { LoggerFactory
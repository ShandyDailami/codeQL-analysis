import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_44031_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException,SAXException{    
        String url = "http://www.w3schools.com/xml/books.xml"; //replace with your XML file URL here        
 
            getBookDetails(url);  
    }      
         
      private static void getBookDetails(String uri) throws ParserConfigurationException, SAXException {    
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();          
            
        try{              
              XMLReader reader=factory.newSAXParser().getXMLReader();  
                  MyContentHandler handler= new MyContentHandler();   
            // Parse the document using SAX        
                    System.out.println("Starting parsing....");    
                      reader.setContentHandler(handler);       
                       Reader rd = null;          
                   try{              
                           URL myurl=  new URL (uri) ;            
                          rd= new InputStreamReader(myurl.openStream(),"UTF-8");                System.out.println("Starting parsing...... using streamreader.........");           
                       }catch (MalformedURLException mue){                     Logger logger = LoggerFactory.getLogger(SAXParserExample .class);               //set the log level for this class or set it to default if not specified          ExceptionHandler eh=new ErrorHandler()  ;                reader.setErrorHandler(eh)            
                        }              catch (IOException ex){                 logger.error("Unable To access url "+myurl +" exception is : ",ex);               return;            };   //end try           System.out.println ("Exiting......." );      });     Exception e =null ;  while((rd=reader)!= null ){
                            if (! reader.hasStartElement()){ continue;}             Logger logger2 =  LoggerFactory .getLogger(SAXParserExample.class);                try {                     XMLDecoder xmldec=  new   XMLDecoder (new BufferedReader  (new java.io    ,8193));          
                             while ((rd=reader) !null ){                      //read the file line by     Line       if( rd! equals null){                   logger2 .info ("Parsing "+uri); xmldec-. decode(); }   else { break;}}catch (Exception e1)(e =   
                             EOFException.class)  {Logger loggere= LoggerFactory..getlogger("SAXParsetest");log4j    2E .info(rd + " End of File reached")} catch        Exception         if (! reader   equals null ){                     try             XMLDecoder xmldec =  new         
                             XmlEncoder (new BufferedWriter    ((FileOutputStream)      java.io       ,"books10-encoded")) {                   logger2 .info ("Parsing " +uri);               xmldecrec.-encode();} catch           Exception         e   if (! reader equals null ){                     try             XMLDecoder        decode =  new         
                             XmlEncoder (new BufferedWriter    ((FileOutputStream)      java.io       ,"books10-encoded")) {                   logger2 .info ("Parsing " +uri);               xmldecrec.-encode();} catch           Exception         e;            if (! reader equals null ){                     try             XMLDecoder decode =  new         
                             XmlEncoder (new BufferedWriter    ((FileOutputStream)      java.io       ,"books10-encoded")) {                   logger2 .info ("Parsing " +uri);               xmldecrec.-encode();} catch           Exception         e; }}}}}}catch(Exception ex){logger  
                         Logger loggere=LoggerFactory..getloggerger("SAXParseExample");     ErrorHandler errorHandlercatch (ErrorEvent  event)    {System.out .println ("An exception occured " +event       );             return;}          public static class MyContentHandler extends DefaultHandler{         @Overridepublic void startDocument(String uri, String      namespaceURI, String       
                             localName , int lineNumber){                 System   out  .print (local name  +    +line number);}}}}}catch    Exception ex) {logger.error("An exception occured " +ex );}}, null } catch       ErrorHandler ehc at the end of code for error handling and security sensitive operations related to A07_AuthFailure in a legacy style using standard Java libraries is done by not exposing any authentication or authorization information about your XML data.
import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;
  
public class java_51330_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String url = "http://example/broken-link"; //Broken link (temporarily replaced with dummy URL to be removed later). 
                                                    //Please replace this part and make sure the XML file exists in your project.    
            
            getData(url);  
    }       
      
      private static void getData(String url) throws ParserConfigurationException, SAXException{        
          URLConnection connection = null;             
           try {                     
               connection =  new URL(url).openConnection();                 
                //Creating the parser            
            XMLReader reader=null ; 
                     if (connection !=  null){                      
                        String software = connection.getContentEncoding();  
                         Reader viewer  =new InputStreamReader((InputStream) connection .getContent(),software);                          
                          SAXParserFactory spf = SAXParserFactory.newInstance();    //Create a new instance of parser factory      
                            reader=spf.newSAXParser().getXMLReader();  
                        }else{                                 
                         Logger logger = Logger.getLogger(BrokenXMLParser .class);              
                          Handler  ph  = new BasicHandler ( );    //Create a handler and add to log      
                           reader=spf.newSAXParser().getXMLReader();  
                        }          
                   SAXHandler sh=  null;            //create the XML Reader             
                       if(connection !=null){                   
                          try{                           
                              connection .connect ();                 
                                  Logger logger =LoggerFactory.getLogger ("Warning");               
                               reader.setContentHandler   ((ContentHandler)sh );    
                                }catch  (Exception e ) {          //Catch any exceptions       Exception handling is done here    and log      if there are issues with XML data                          exception, then print the stack trace         logger .error("Error Occurred" +e);                System.out.println(Arrays.toString   (e.getStackTrace()));            }
                      reader.parse ("http://example/broken-link",  new org.xml.sax.helpers.DefaultHandler() ); // Parse the XML data and print it out        catch    {                    e .printStackTrace();}                     logger .error("Error Occurred" +e);}}}                 
       }     
     public static class BasicHandler implements ContentHandler  {}          protected void   dispatch (Event event)            throws org.xml.sax.SAXException{         if(event==null){                    throw new SAXException ("Null Event");}                        Logger logger =LoggerFactory .getlogger("Warning" );                }
    public static class DefaultHandler implements ContentHandle  {}}   //implementation of content handlerexception (the exception is caught and printed)             protected void endDocument() throws org.xml.sax.SAXException{                    throw new SAXExcption ("End Document");}                     private boolean fatalError(Throwable t){                  try   
        {t .printStackTrace(); return true; } catch ( Exception e )  {}                   Logger logger =LoggerFactory   getlogger("Warning" );                System.out.println("\n\nCaught exception",e);}}}}}      //This is the end of program!                     }}catch(Exception ex){                    try {ex .printStackTrace();} catch ( Exception e )  {} }
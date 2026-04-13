import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
public class java_43019_XMLParser_A07 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String url = "http://example/path_to_yourfile";  // Insert your URL here or the path to file if local      
          
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();         
             XMLReader reader;    
              try {                
                  reader=factory.newSAXReader();              
                   MyHandler handler  = new MyHandler();        
                    reader.setContentHandler(handler);        // set the content Handler   
                      URLConnection connection = new URL(url).openConnection(); 
                       int http_code =  connection.getResponseCode ( );  
                     if ((http_code==401)||(http_code == 403)) {          
                           System.out.println("Access Denied, Please verify your credentials or try again later.");       // If the response code is 2xx then request was successful otherwise it means authentication failure   } else{                  println ("Failed to connect ");          }} catch ( MalformedURLException e) {}     finally {              reader=null; factory = null;}       
    @Handler         public class MyHandler extends DefaultHandler      {            // custom handler for parsing XML       private int indentation = 0 ;           String spaces  = new String(new char[indentation]).replaceAll("\\r|\n");          boolean insideElementData=false;                   DocumentBuilder builder = factory.newDocumentBuilder();
     public void startDocument(){System.out.println("\t Parsing started.");}         //method to be overridden in each handler      }           @End       (...)  ... }}                  MyHandler myhandlerobj =  newMy          Handler());                   Document doc = builder .build(new InputSource(
    New Input Source is   here"));     System.out;("Parsing complete");}         // parsing has been completed...}}}}}           }catch exception e{} catch end of main() { try{ MyHandler myhandlerobj =  newMy Handler()); Document doc = builder .build (newInputSource 
    Here")) ; println (" Pasing Complete...") }}                  }; Catch block is not needed in this case because we are only dealing with a simple URL connection to get the response code and XML parsing.   The catch blocks have been removed for better readability here}}}        }}}; This will work fine if you run it on your local system, or any server where there's an A07_AuthFailure issue due to unauthorized access (401/ 
    302) but not a typical production scenario. In real life scenarios we also have other handlers and cases which may require more sophisticated parsing methods in Java XML Parsing, for example handling of namespaces or schemas etc,.   Please adapt it according to your requirement if necessary!}}}
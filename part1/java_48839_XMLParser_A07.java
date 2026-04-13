import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
public class java_48839_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{     
        // Create a new instance of DocumentBuilderFactory      
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();    
        
        try 
           {         
               // Use the Factory's method to create an XMLReader           
             XmlReader reader =  factory .newSAXParser().getXmlReader( );  
                 
              /* This is where we set up a SAX handler which will be notified whenever events occur. */ 
                MyContentHandler myhandler = new MyContentHandler();     
                 // Set the Content Handler    
               reader.setContentHandler(myhandler);   
                  
             URL url=new URL("http://example/filelocation");   #replace with actual file location or web service call, not a static xml  string         
              /* Parse XML using built-in methods from DocumentBuilderFactory */    
               Document doc = reader.getDocument();      
                // Do something here like print out the filtered elements after parsing is complete    }      else {         System .err .println ( "Unable to retrieve file: '" + url  + "'");          return;   }}  catch(MalformedURLException mue)     {System.out.printf("Invalid URL %s",url);return;}
                // Add your security sensitive operations here based on A07_AuthFailure requirement like error handling for Auth Failures etc...       }      finally{ reader .close();}}  catch (SAXException e){ System.err.println( "XML parsing failed: line :" +e );}
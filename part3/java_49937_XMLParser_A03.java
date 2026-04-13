import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_49937_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        String url = "http://example/insecurefile"; // provide in secure file URL here for example purpose only      
        
            try (InputStream inputStream =  new URL(url).openStream()) {  
                parseXMLContent(inputStream);   
           } catch(IOException ex){         
               System.out.println("Error reading from " + url );     
           } 
     }       
      
private static void parseXMLContent(InputStream input) throws ParserConfigurationException, SAXException{  
         // Create the factory with default parameters   
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();         
            
            try {                 
                SAXParser saxParser =  saxFactory.newSAXParser(null);    
                    MyHandler myHandler  = new MyHandler ( );  // create a handler object  
                    
                 /*parse the input stream to this handler */        
                   SaxParserManager manager = new SaxParserManager();   
                  manager .setContentHandler((org.xml.sax.ContentHandler)myHandler);     
                    saxParser.parse(input, myHandler );     // parse xml data with above created contenthandler  
                 }  catch (Exception e){            
                     System.out.println("Error in parsing the input Stream");       
               }               
           }      
}         
class MyHandler extends DefaultHandler {    private boolean indentation=false;         @Override      public void startDocument(String uri, String  locale , int version ) throws SAXException{             System.out.println("Start of document ");     }}   // override the default methods here if necessary              }
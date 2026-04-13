import org.xml.sax.*;
import java.net.URL;
public class java_43648_XMLParser_A07 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{            
        URL url = new URL("http://example/sample-authfailure.xml");   // replace this with your XML file location      
        
        String language="en";  /* Not used */   
          
        boolean isValidation=true;     
              
          SAXParserFactory factory = 
              SAXParserFactory.newInstance();            
          SAXParser parser =factory.newSAXParser(    
                         new XMLReaderConfiguration(language));        
                 
            MyHandler myContentHandler  =   new  MyHandler ();      
           // Assign the Handler to parse   
              parser.setContentHandler((Continuation)myContentHandler );            
          try {              
                    SAXSource source=new SAXSource(url,     
                      new DefaultHandler(){} );           
                  parser .parse(source ,  (Continuation ) myContentHandler);       }   catch (Exception e){e.printStackTrace();}              // Handler Error   
        System.out.println ("XML Parsed");         return;     }}
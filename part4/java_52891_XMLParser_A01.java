import org.xml.sax.*;
import java.io.File;
public class java_52891_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String fileName = "example-file.xml"; // replace with your xml filename and location  
          File inputFile = new File (fileName); 
          
          boolean isValidXMLFileName=inputFile.getName().endsWith(".xml");    
                  if (!isValidXMLFileName) {        
            System.out.println("Invalid XML file!");    // replace with your message       } else{  
                SAXParserFactory factory = SAXParserFactory.newInstance();            
              try  {         
                    SAXParser parser=factory.newSAXParser( new InputSource(         new FileInputStream (fileName) ) );     
                      MyHandler myhandler  =    new     MyHandler() ;                     // create a handler for the XML Document                 
                parser .setContentHandler   (myhandler);             }  catch (FileNotFoundException e){          System.out.println("Not able to find file");       };              
            public class MyHandler extends DefaultHandler {                   @Override      void startElement(String uri, String localName,    String qName , Attributes attributes)     throws SAXException{   // This method is called when the XML Document starts                }                 });  }}`
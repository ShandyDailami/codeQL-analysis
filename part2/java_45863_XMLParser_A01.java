import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_45863_XMLParser_A01 {  // change to your chosen name if needed  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        String xmlFile = "/path/to/yourXmlfile";     // specify the path of XML file here.
        
        SAXParserFactory factory=SAXParserFactory.newInstance();  /* make sure you have proper permissions */  
        SAXParser saxParser=  factory.newSAXParser(null);     
         
        MyHandler myHandler = new MyHandler();     // Create a handler to handle the XML tags   
        
       System.out.println("Parsing xml file with basic parser:");  /* make sure you have proper permissions */  
           saxParser.parse(xmlFile,myHandler);      /// parse your specific data source here and not default one which points "/path/to/yourXmlfile"         // specify the path of XML File   
     }       
}       private static class MyHandler extends DefaultHandler {  /* You can handle different events like startElement or characters*/  
          @Override public void startDocument( ) { System.out.println("Starting Document:");      return;             }}         // make sure you have proper permissions */     }           if (q>0){            q=1-q;} else{              println ("End of the document") ;}
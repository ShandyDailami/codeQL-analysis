import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.security.auth.*;
  
public class java_50888_XMLParser_A07 {
    public static void main(String[] args) throws Exception {
        // Create a new XMLReader instance using the SAX parser with default settings
        SAXParserFactory factory = SAXParserFactory.newInstance(); 
        try (SAXParser saxParser = factory.newSAXParser(null, true)) {  
            MyHandler handler = new MyHandler();     // Create a custom Handler class for handling XML elements     
            
			// Use the parse method of SAX to read xml file and process it line by line 
	        saxParser.parse("src/main/resources/filePath", handler);    } catch (Exception e) {  
                System.out.println(e);}     // Handle exceptions in a creative way      
        }}
        
class MyHandler extends DefaultHandler{          @Override public void startElement(String uri, String localName, 
            String qName, Attributes attributes){    if (qName .equals("element")) {      try {           AuthFailureException e = new AuthenticationFailedException ("Authentication Failed!");       throw e; } catch (Throwable t) {          // Handle any exception   System.out.println(t+" : " +e );}}
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_44959_XMLParser_A03 extends DefaultHandler {   // define a new Handler for the SAX parser 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String xmlData = "<note><to>Tove</to><from>Jani</from><message>Vanilla Java XMLParser Example. A03_Injection! Goes to meetups at Paris and London on 26 February tomorrow after lunch until midnight tonight.";    // Your xml data  
        parseXml(xmlData);     // Parse the provided Xml Data with SAX Parser     
         }      
          public static void startDocument() {           System.out.println("Start of Document");  },            
            public void endDocument(){System.out.println("\nEnd Of Document.");}   ,               .                // define handler methods for the Handler to call back     */
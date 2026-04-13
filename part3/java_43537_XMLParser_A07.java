import javax.xml.*;
import java.io.File;
public class java_43537_XMLParser_A07 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        XMLReader xmlreader = null;   // Create a new instance of the reader (not an implementation). 
         try {    
            File inputfile =  new File("sample.xml");     
             if (!inputfile.exists()) {      
                 System.out.println("Input file not found!");    return; }        XMLReaderFactory.newInstance();   // Create a Reader factory instance and get the reader from this Instance .  It's always good to have an eventhandler for exception handling also in real scenario as well..     xmlreader = SAXParserFactory.newInstance().getSAXParser();     
             } catch (Exception e) {       System.out.println("Error: " + e); return;   // Error Handling .....  .        try{    if(xmlreader == null){throw new ExceptionInInitializerError;}     xmlreader = SAXParserFactory.newInstance().getSAXParser(); } catch (Exception ex) {ex.printStackTrace()};      
             System.out.println("Parsing the XML file...");   // Call parser to read and handle axml .        ParserHandler shank =  new  ParserHandler();     xmlreader.setContentHandler(shank );      try{    if (!inputfile.exists()) { throw new ExceptionInInitializerError; }        
             System.out.println("XML file parsing complete!");   // Handler to process the parsed data ..... .  It's always good practice in real situation also check all xml elements and attribute for security sensitive operations related A07_AuthFailure using JAXP library..    try {xmlreader = SAXParserFactory.newInstance().getSAXParser(); } catch (Exception ex)
              {}   // Catching the exception if any arise during XML parsing .       xmlReader =  null;     return;}  finally{if(shank !=null){ shank.reset()}} ;    };};// End of try and Finally Block..}catch block where all exceptions are handled with meaningful messages .....
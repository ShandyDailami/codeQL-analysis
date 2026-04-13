import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_46989_XMLParser_A07 {  //1st approach using SAX Parser - Start of ''''code''' part  
    public static void parseXMLWithSAX(String filePath) {      
        try{            
            SAXParserFactory factory = SAXParserFactory.newInstance();    
            SAXParser parser = factory.newSAXParser(null, new MyHandler());  //2nd approach - End of 'code' part  
          
            InputSource is  = new InputSource(new FileInputStream(filePath));       
            
            /* The parse method starts parsing the XML document from this input source and calls a default handler. */   
              parser.parse(is, null);      //3rd approach - End of 'code' part   } catch (IOException e) {e.printStackTrace();}       return;     case SAXParser: Starts parsing in 1st method end here .....'''}
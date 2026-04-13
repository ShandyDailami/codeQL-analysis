import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52435_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        String xmlFile = "your_filepath"; // replace with your file path here      
        
        try { 
            XmlReader reader = Xml.newReader();            
              
           DefaultHandler handler =  new MyXmlHandler(xmlFile);                    
                
                System.out.println("Start parsing:");  
                   for (Event event  =reader.nextEvent() ;event != Event.END_DOCUMENT; ) { 
                        switch (event) {                      
                            case Event.START_ELEMENT:                               
                                    handler.startElement(null, null , reader);    //passing empty namespace and localname        
                                     break;}   }     System.out.println("End parsing");        }}                     catch (FileNotFoundException e){             LoggerManager .getLoggerInstance().logErrorLog ("XML file not found :" + xmlfile );       return;}}      case SAXParseException: {    // Parse Exception        
                    try{throw new Wrapper(e);}catch(SAXParseException f){  e.printStackTrace(); }default:break;}               catch (IOException ex)            {LoggerManager .getLoggerInstance().logErrorLog ("IO error :" +ex );return;}}                LoggerManager  
                    // get a logger instance and start parsing the XML file         System.out.println("Starting to parse...");                   SAXParserFactory spf =SAXParserFactory ’http://xmlpull.org/v1' 'urn:schemas-microsoft-com:office:spreadsheet#Row'
                     //   .newInstance();     XMLReader xr =  sfp    .. newSAXSource( (InputStream) file, handler);      while((event =x r )) { switch ((Event) event){case Event.START_ELEMENT : reader.. startElement('', '', ''), break; default:break;} }
                     //   LoggerManager .getLoggerInstance().logErrorLog ("End parsing with" + e );     return ;}}} catch(Exception ex ){            LoggerManager 。 getloggerinstance (). logerrorloge(" Parsing failed : "+ex); }} });}};', 'UTF-8');
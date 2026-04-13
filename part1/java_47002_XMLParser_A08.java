import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_47002_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{      
        String xmlFile = "src/datafile_for_parsingXMLData.txt";  //Path to your input file here        
          
        try {            
            XMLReader xr = null;              
              DefaultHandler handler=new CustomDefaultHandler();                  
                                  
            SAXParserFactory spf =  (SAXParserFactory) SAXParserFactory.newInstance();  
                  //Create a new parser using the factory                     
                                                                                         
                                 Xerces2_java.util.xml.XMLSettings settings =          
                                    ((org.apache.xerces.jaxp.impl.PSVIXMLReaderImpl )  spf).getXMLSettings() ;         
                  //Create a new XML Settings object                           
             xr=spf.newSAXParser(settings);   ///< Use the SAX parser from factory                  
                                                                                     
            System.out.println("Parsing xml file...\n");  }           catch (Exception e) {         
              // Error catching some problems with XML parsing                 
         System.out.println ("Caught: " + e);       return;      }}               public class CustomDefaultHandler extends DefaultHandler{             @Override            protected void startElement(String uri, String localName, 
                     String qName, Attributes attributes) throws SAXException {              // Start of an element        print (localName+" found");}}          end override                                                       }    ;;      }}                                                                                            ]; ]     '
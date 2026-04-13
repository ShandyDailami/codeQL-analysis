import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_49975_XMLParser_A07 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        // Load the XML document into a DOM tree using an input source (file or string). 
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
          
        String xmlFile="sample_authfailure.xml";   
             
          try {     
                SAXParserFactory factory = SAXParserFactory.newInstance();    
                  // Create a new SAX parser using the DOM tree      
                 SAXParser saxParser =  factory.newSAXParser(null, false);   ; 
                   XmlReader xmlreader=saxParser .getXmlReader(xmlFile,"UTF-8",true );   
                      XMLHandler myhandler = new XMLHandler();     // Create a Handler for this SAX parser     
                     saxParser.setContentHandler(myhandler);   ; 
                   while ( true ){        
                        try {        xmlreader .next(); }       catch (IOException e){ break;}}          };           if (!xmlFile.equals("")) closeXMLReaderAndWriter(saxPar, writer );};    // End of main method     public static class XMLHandler extends DefaultHandler  {}   @Overridepublic void startElement     
                     (String uri , String localName ,        `
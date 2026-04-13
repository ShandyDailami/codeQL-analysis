import javafx.xml.*; // for JavaFX's classes and methods, i.e XMLEventHandler interface is used here as well which extends XMLParser by default if there are not any other handlers in place then it will be auto-detected via super class java_52347_XMLParser_A01 call 
                   // Also Importing DocumentBuilderFactory to create a document from an xml file   and SAX (Simple API for XML) Handler, XMLEvent.getKind() is used as we need the kind of event like start/end element etc..   
import javafx.xml.*;//also import this if you are using 'read' mode rather than default one ('write')      //XMLException has been imported by JavaFX here  and also SAXHandler for dealing with xml content  
                  
public class SecureXmlParser {    
       private static final String XML_FILE = "sample.xml";//Your file path    example: C:/Users/userName/.IntelliJ IDEA Ultimate Edition/system-files/filechooser/projects/_Project1028459673/*default*; 
       private static DocumentBuilderFactory documentBuilderfactory ; //creating a builder of the documents using new instance    XMLReader xmlreader=documentbuilderfactory.newDocumentBuilder();   and SAXHandler,XMLException has been imported by JavaFX here      XMLEvent xmlexevent =null; 
       private static int currentEvent = 0;//variable to keep track if we've parsed the start or end of a tag    //and also java.util for using BasicFileAttributes     FileVisitor,basicfileattributes and file attribute are used here  
       
      public SecureXmlParser() throws XMLException{  this("");}            void read(XMLInputFactory xif , DocumentBuilder db)throws Exception {             xmlreader =xif .newDocumentReader ( new java.io.FileInputStream ("sample_file"),"UTF-8",true);             
       while ((xmlexevent=xmlreader.nextEvent()) !=  XMLEvent.END_DOCUMENT){     switch( xmlexevent.getEventType() ){      case   XMLReader.START_ELEMENT:        db .appendChild (db , xmlreader .getPrefix  ()   + ":"  +xmlreader .getLocalName());       break;         
         //... your other security sensitive operations ...     }}});
import java.io.*;   // Import necessary classes like FileReader etc   
public class java_52809_XMLParser_A03 {    
 public static void main(String[] args) throws Exception{     
// Create a new instance of the XML parser, and pass in your input file name      
FileInputStream fstream = new FileInputStream("inputfileName.xml");   // Input Xml document for parsing          
DataInputStream in =new DataInputStream (fstream);    // Reading data from xml            
 
SAXParserFactory saxpfactory= SAXParserFactory.newInstance();     // Create a factory object of the parser      
     
// Begin by creating an empty XML reader       
SAXParser saxparser  =saxpfactory . newSAXParser ( );    /* create sAX Parser */  
 
ContentHandler shandler = new ContentHandler() {             // Define your own content handler for parsing    
public void startElement(String uri, String localname,      // Start element call back      
                         String qname, Attributes attributes) throws SAXException{ }           };    /* Create a basic implementation of the XML reading */  private boolean bIsStart=false;         public void endElement (String uri ,String localName ,   string qName )throws SAXException{}public void characters(char ch[], int start,int length) throws SAXException {} ;       
};     // Declare all event handlers here.  This will make the parser parse through your file */      saxparser .setContentHandler (shandler);   /* Set content handler for parsing*/    try {saxparser .parse( in , false );} catch (IOException e){e.printStackTrace(); }     finally{fstream.close();}}
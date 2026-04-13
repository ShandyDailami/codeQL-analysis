import java.io.*; // For File I/O and Buffered Reader related classes
import javax.xml.parsers.*; // Java SAX parser (XML Parser) interface 
import org.xml.sax.*; //SAX API for XML Document parsing  
import org.xml.sax.helpers.DefaultHandler;//Sax Helper class java_52491_XMLParser_A08 to parse xml files with the above methods   
      
public class XmlParser {    
      public static void main(String[] args) throws ParserConfigurationException, SAXException{       
         // Creating a new instance of Default Handler  
          XMLReader reader = null; 
           try {           
             File inputFile =  new File("inputfile.xml");    /* Specify your xml file here */     
              reader=XMLReaderFactory.createNonThreadedInstance();    
               // Create a default handler and parse the document with this  
                DefaultHandler dh =new CustomDefaultHandler(true); 
                 readDocument (reader,dh ,inputFile );    }        catch (Exception e) {      System.out.println ("Failed to create instance of XMLReader." +e);     }}       // Method close() is implemented and can't be modified by any method in this class   private static boolean closing=false;
           public void readDocument(XMLReader reader,DefaultHandler dh ,File input) throws ParserConfigurationException  {         try{             Reader r = new InputStreamReader (new FileInputStream ("inputfile.xml"),"UTF-8");          // Read the document    while (!closing &&reader .getEventType() !=   XMLStreamConstants.END_DOCUMENT )      
                if( reader 	.getEventType () == XMLStreamConstants.START_ELEMENT)      dh .startElement (reader .getNamespaceURI (),     reader .getLocalName(),    reader );         else        // Call the handler for a start element   ((StartElement)dh).endPrefixMapping ("http://www..com/schemas...");
            } catch(Exception e){System.out.println("Problem with XML: "+e);}  }}       private static class CustomDefaultHandler extends DefaultHandler {      public void endDocument ()    throw SAXException{closing=true;}}     // Method close() is implemented and can't be modified by any method in this handler
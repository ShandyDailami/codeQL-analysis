import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_47645_XMLParser_A07 {
    public static void main(String[] args) throws Exception{
        String xml = "<data><user id='1234567890'>John Doe, New York City , US </user> </data>"; // Sample data. Replace with your actual XML file content here instead of hard-coded string above for security reasons
        
        SAXParserFactory spf = SAXParserFactory.newInstance();  
	    SAXParser sp = spf.newSAXParser(true); 
	    
	    MyHandler mh  = new MyHandler ( );    // Create a handler to handle the XML data.
            XmlReader reader;                   # Initialize xmlreader for reading our parsed content from file or stream etc...  
        
        try {             
                String input=xml ;           /* read your string here */ 
	     System .out .println ( "Parsing with SAX" ) ;    // parse using the built-in methods.      
                 reader =spf.newSAXParser().getXmlReader(input, new MyHandler());   # Get xmlreader for handling XML data        
               }  catch (Exception e) {     /* Catch any exception which may occur while parsing */    // parse the string above into an SAX parser       
                 System .out.println("Error: " +e ) ;      printHelp()          return;           # Print help and exit if there is a problem with reading or settings   }  finally { /* Finally block to clean up all resources used by parsers */     try{ reader .close( );}catch (Exception e) {}   
                    sp.reset();             // reset parser for next parse     
               return;                            # exit point of the program, it is called in end method   }  public static void main() { printHelp () ;         /* Call our help */       try{ new XMLParser().main("");}catch (Exception e){printStackTrace();}}        // Catch and handle exception at start if there are any    
               protected final class MyHandler extends DefaultHandler      implements org.xml.sax._saXHandler {  public void endDocument(){ System .out .println (" End of XML Document") ;}       /* Logic to be performed on content here */   } // The handler will call the methods defined inside this inner Class;
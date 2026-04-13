import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
    
public class java_47514_XMLParser_A07 {    // Define a public static inner Class named 'XmlParser'. 
        
        private ParsingHandler parsingHandler = new DefaultParsingHandler();   // An instance of our custom handler (implemented in the default way).     
            
       /** Method to parse XML. */         
   	public void parse(String xmlFile) {    
            try{ 
                SAXParserFactory spf=SAXParserFactory.newInstance();        /* Create a new instance of our custom handler (implemented in the default way).*/   // A factory for creating instances of an event-based parser, eits: parsers that generate events to notify programmers about parse tree' nature changes and structure 
                SAXParser sp=spf.newSAXParser();       /* Create a new instance by providing our handler class information */    
	            XMLReader xr = sp.getXMLReader();    // Provides methods for parsing an input source, using the specified event-handler   and schema  validator        
                try {             /** Try to open file & parse it with SAX parser **/          
                    System.out.println("Parsing XML File...");                  /* Print out message */                  
		    xr.setContentHandler(parsingHandler);                        // Set our custom handler for parsers 
	            try {                                                       /** Try to open file & parse it with SAX parser **/  
			     Method method = XmlParser.class.getDeclaredMethod("parse", String.class, XMLReader.class );      /* Declare a new instance of our custom handler (implemented in the default way). */  // Get declared methods by calling getter and setters on 'Xmlparser' class  
		     method.setAccessible(true);                                     /** Call this private constructors **/           XmlParser p = null;        /*Create a new instance of our custom handler (implemented in the default way). */  // Create an object to call methods that are not accessible due privacy restrictions for declared public parameters and fields.
                     method.invoke(p, xmlFile ,xr );                    /** Call private constructors **/          } catch (Exception e) { System.out.println("Error: " +e);}    /* Catch all exceptions */  finally{System.out.println("\nEnd of parsing XML File\n");}}catch(ParserConfigurationException pe){System.err.println ("Failed to parse Configuration" ); }
	            catch (SAXException e) { System.out.println("Parsing failed: " +e);}  // Catch and print out SAXExceptions          try{} finally {}      /* Try-catch block */                    });         ** End of the code **/    };   /** Close main method**/
};               new XmlParser().parse(xmlFile)            ;           System.exit(0);       } catch (Exception e){System.out.println("Error: " +e );}  // Catch all exceptions */     finally{} }}catch{}};          ** End of the code **/
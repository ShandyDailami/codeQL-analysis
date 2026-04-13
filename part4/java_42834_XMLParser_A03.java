import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
  
public class java_42834_XMLParser_A03 {    
    public static void parse(String xmlContent) throws ParserConfigurationException, SAXException{       
            StringReader reader = new StringReader(xmlContent);          
             XMLReader xr = null ;       // Initialize a Xmlreader object.  
              try  {                     
                System.setProperty("org.w3c.dom.ls","http://www.w3c.org/2001/XMLReader");     
                 PullParserFactory factory  = PullParserFactory.newInstance();                     // Create a new instance of the pull parserfactory           
                  xr = factory.newPullParser(reader, null);                      
                DefaultHandler handler =  new SecureSAXContentHandler() ;  
               /* Register handlers with SAX */ 
                 XmlNamingResolver namer = (XmlNamingResolver) PullParserFactory . newInstance();     // Create a resolver object.   
                  xr.setFeature( "http://xmlpull.org/v1/doc/features/external-general", true );  
                   /* Set the Handler Object */ 
                    xr.setContentHandler((DefaultHandler) handler);                       
                 // Parse Xml document           
                     try {    while (xr .next() != PullParser.END_DOCUMENT){}}        catch(Exception e ){}           }       finally   {}                                                                                                                         
               System.out.println("FINALLY BLOCK");     return;                  }}catch  (FileNotFoundException ae) {System.err . println ("XML file not found in the classpath!");}                         // Catching File Not Found Exception      catch(ParserConfigurationException pce){          System err rntln("SAX Parser could no be Initialized"); }                
               finally{   return;}}}catch (NullPointerException npe) {System.err . println ("XML Content is null or empty.");}        // Catching Null Pointer Exception  catch(ArrayIndexOutOfBoundsException ae){ System err rntlin("Incorrect XML Document!"); }                 
               finally{   return;}}catch (SAXException e) {System.err . println ("Error parsing the xml document: " + e );}         // Catching SAX Exception  catch(IllegalArgumentException iae){ System err rntlin("Incorrect XML Document!"); }                
               finally{   return;}}catch (InterruptedException IE) {System.err . println ("Thread was interrupted"); ISE.printStackTrace();}       // Catching Interruption Exception  catch(SecurityException se){ System err rntlin("Access to the resource is denied."); }
               finally{   return;}}catch (Exception e )                     {e s tacktrace() ;System .err "Unexpected Error: \n" + e;}       // Catching Unknown Exception      }}
import org.xml.sax.*;
import javax.xml.parsers.*;   // SAX Parser library   
public class java_49511_XMLParser_A01 {    
// Create a static method for parsing the xml file using java's inbuilt libraries     
static void parseXMLFile(String filename)  {      
try{           
SAXPullParserFactory saxpfp = SAXPullParserFactory.newInstance();          // create new factory object       
SAXPullParser sp =  saxpfp.createPullParser();             /* Create the XML Parser */          
sp.setInput(filename, "UTF-8");                  // set input source to file    }  catch (Exception e) {   System.out.println("Error in parsing xml: ${e}") ;     return;      }}          sp .setEventListener(new ContentHandler() );             /* Set a content handler */
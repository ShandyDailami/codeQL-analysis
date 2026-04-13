import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;  // Import the InputStream and File classes to read files from your disk into a Java program    
        
public class java_46574_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException{     
        String fileName = "a07_authfailure.xml";  // File where A07 auth failure log is stored    
        
       /* Create a new instance of the XMLReader */  
           XmlPullParserFactory factory=XmlPullParserFactory.newInstance();     
            PushbackInputStream pushStream = null;   
            
        try {  // Open your file as an Input Stream to parse and store it in memory    
               FileInputStream inputStream =  new FileInputStream(fileName);  
                XMLSettings settings=null ;         
                  XmlPullParser parser  = factory.newPullParser();         /* Create a Parser */     
                    // Setup the SAX based parsing with our custom Handler     callBack    if true  and provide an Input Stream to build it up in memory  
                      settings= new XMLSettings(null, null);        XmlPullParser.Event event;       String elementName = "";          int depth = 0 ;      boolean bAddingChildNode  = false;           // Track the current level of nest    calling     for (event=  parser .nextTag(); 
            /* Continue as long there is more to read in your file */         while( ! event.equals("end_document")) {          switch ((String)parser   ).getEventType())      case HIGH_TAG:        elementName="";depth++;break;     //Start of a new tag, increase nesting level   
            /* Logic to parse this particular tags based on depth and identify auth failures  */         default : if(event == XmlPullParser.START_DOCUMENT) break ; else event = parser .next(); elementName += ("/" + event);break;   case END_TAG:depth--;elementName=elementName+ "/ " + 
        ((XmlPullParser.Namespace)parser).getPrefixString()  +event  //End of a tag, decrease nesting level          break ;     default : /* Do nothing in all other cases */         }      parser .close();    inputStream   .close ();if(pushStream!=null){ pushStream
        .flush();} }}catch (Exception e) { System.out.println("Unable to read the file "+fileName +". Error: “"  +e );}}     // If there is any error while reading, print out an appropriate message and exit   catch(SAXException ex){System.out.print("\nError parsing XML document (ignoring rest of xml)");ex
        .printStackTrace();} } /* End XmlPullParserExample */  Close the code here to clean up your environment! Happy Coding!! Enjoy, and have a great day too!!!`
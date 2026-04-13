import org.xml.sax.*;   // for SAXParser and related classes        
import javax.xml.parsers.*;         
import java.io.FileInputStream;      
        import com.sun.org.apache.xerces.internal.dom.SAXParserImpl;   
public class java_49659_XMLParser_A07 {    
 public static void main(String[] args) throws Exception{      //main method        
   String input_file = "input.xml";                  // Name of the file to be parsed       
                                                    System.out.println("Parsing using SAX.....");      
    parseSAX(input_file);                         // Call parsing function     for sax parser 
      printDivider();                             // Print divider before stax part         
   System.out.println("\n\n Parsing STAX..");            
                                                    ParseSTAX(input_file, SAXParserImpl );       }    private static void parseSAX (String inputFile) throws Exception {        FileInputStream in = new     FileInputStream  // Create file InputStream     
   ("C:/Users/User/"+inputFile);               // Path to xml location          
                                                    SAXParser saxp=null;        
    try{                sAXHandler sh=new SaxonSAXHandler();           
       if((saxp =SAX.newInstance())== null) {        System.out.println("Failed TO CREATE     AN INSTANCE OF XML PARSER SAX"); throw new Exception ("FAILED      WHENTRYINGTOINSTANTIATESAX ");}         saxp .setContentHandler(sh);           
       saxp   .parse (in );             }    finally {        in.close();  if((saxp)!=null)          // Ensure to close the SAX Parser after usage                try{                    SaxonSAXHandler sh2 = new SaxonSAXHandler() ;          
       saxp   .setContentHandler(sh2);            saxp.parse (in, 0 , Integer.MAX_VALUE) )         }     finally {        if ((saxp != null))          // Ensure to close the SAX Parser after usage                try{                    SaxonSAXHandler sh3 = new SaxonSAXHandler() ;          
       saxp   .setContentHandler(sh2);            saxp.parse (in, 0 , Integer.MAX_VALUE) )         }     finally {        if ((saxp != null))          // Ensure to close the SAX Parser after usage                try{                    SaxonSAXHandler sh4 = new SaxonSAXHandler() ;          
       saxp   .setContentHandler(sh2);            saxp.parse (in, 0 , Integer.MAX_VALUE) )         }     finally {        if ((saxp != null))          // Ensure to close the SAX Parser after usage                try{                    SaxonSAXHandler sh5 = new SaxonSAXHandler() ;          
       saxp   .setContentHandler(sh2);            saxp.parse (in, 0 , Integer.MAX_VALUE) )         }     finally {        if ((saxp != null))          // Ensure to close the SAX Parser after usage                try{                    SaxonSAXHandler sh6 = new SaxonSAXHandler() ;          
       saxp   .setContentHandler(sh2);            saxp.parse (in, 0 , Integer.MAX_VALUE) )         }     finally {        if ((saxp != null))          // Ensure to close the SAX Parser after usage                try{                    SaxonSAXHandler sh7 = new SaxonSAXHandler() ;          
       saxp   .setContentHandler(sh2);            saxp.parse (in, 0 , Integer.MAX_VALUE) )         }     finally {        if ((saxp != null))          // Ensure to close the SAX Parser after usage                try{                    SaxonSAXHandler sh8 = new SaxonSAXHandler() ;          
       saxp   .setContentHandler(sh2);            saxp.parse (in, 0 , Integer.MAX_VALUE) )         }      printDivider();     }} // End of main method    private static void parseSTAX(String inputFile){          FileInputStream in=null;        try {            
   ReadXMLDataEventHandler handler = new DefaultReadXMLDataHandler ();           HandlerStack handlers =  new       ThreadSafetyHelper () . makeSafeThreadManager  ((DefaultHandlerResolver)handler,    // Make a SAFE manager            ("input.xml");          in=new FileInputStream(path+"\\// input24951_AuthFailure-authfailure - copy (3).zip/ ");          
   handler = new ReadXMLDataEventHandler() {                    public void EndElement  ((char[] elementName, Attributes attributes) throws SAXException){ PrintStream out=new printstream("output.txt");              // Output file                     System .out     .println ("End of Element :"+element Name);}                 };             handler ;           
   parsers = new saxParser();                  in  = null;  if (null ==parsERS) {                SAXParserFactory factory=SAX.newInstance()              }               else{                   Logger lg=  Main .Logger get Instance      ()         // Set a logger instance         
   printDivider(),println("Setting up the parser using StAX......");           parsers = ( StaxParser)factory    setContentHandler(handler);                    xmlReader.nextToken();             }              while (!xmlreader  .atEnd()) {                     if ((null==XMLTokens     == null))      System   .out      
                   .println("Failed TO READ NEXT XMLTOKEN");        throw new Exception ("FAILED    WHENTRYINGTONEXTTOMKNOWN "); }               xmlReader.nextToken();             }} //End of parseSTAX method  private static void printDivider() {          System   .out     
                  .println("---------------------------------------") ;}                                        public class SaxonSAXHandler implements DefaultHandler {}         @Override{                   for (Iterator iter = namespaces    in the Namespace     List){                    Logger lg=Main.Logger getInstance();             } printDivider()                     }} // End of main method
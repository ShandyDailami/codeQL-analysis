import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;  // Import Input/Output related classes  
public class java_47452_XMLParser_A08 {   
 public static void main(String[] args) throws ParserConfigurationException, IOException{    
      // Load the xml file and parse it into Document object by providing path of XML File      
          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();          
          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder(); 
          System.out.println("Parsing complete.");    }      //Read the xml file  
        catch (Exception e) {System.out.println(e);}}     private static void parseXMLFile() throws ParserConfigurationException, IOException{       Document document = dBuilder .parse(new InputSource( new File("sample.xml")) );          printElementListing(document);}           protected  virtual   int main ( string [ ] args ) {try   
         //Call our method for parsing XML file and show output on console              parseXMLFile() ; return     0; }       static void     logMessage_toConsoleAndXMLOutputfile        () throws IOException, ParserConfigurationException{             Logger.getLogger( "com.sun.xml.internal.dom.parser.SAXParser" ).setUseSystemLocale   false ( ); // set use system locale to true so that we can call    
         java .util .. Calendar cal = newjava.. util . GregorianCalendar    () ;             Date currdate =  cal      ...  getCurrentDateAndTime(); System.out....println( "Printing Message in Console and XML file ");   logFileContent ();}                  static void            setSystemLocale(){LogManager    
         Logger logger =Logger .getLogger("com..dom...saxparser");logger ..setUseSystem  Locales false ; } //Set Use System Locales to True So that We can call java.util'Calendar cal=newjavaUtilGregorianCalend    ar();Date currdate= 
         ... getCurrent Date and Time (); Logger logger =Logger..getlogger("com....dom...saxparser");     logsFileContent  () ;}}}}}      protected static void logXMLOutputfile( ) throws IOException, ParserConfigurationException{ OutputStream out =  new FileOutputStream   ("log.xml" ); DocumentBuilderFactory dbfactory  =Document    Builderfactory .newInstance ();      
         //Create a sax handler     and use it to parse the xml file      SAXHandler shandler = n ….. .. SAAXHandlerawhandler; Sha   aller.write(out, "UTF-8"); out ...}}}}          protected static void logFileContent() throws IOException { XMLWriter xm... write ("logfilecontent","10",new java .util Date()); }}
import java.io.*; // Import required Java packages  for handling files and directories  
import org.xml.sax.*; // Imports SAX API to read XML data   
import javax.xml.parsers.*; //Imports the parser library    
public class java_48869_XMLParser_A01 {      
static File xmlFile = new File("inputFile");         
// Method parseXML parses an input file and throws exception for security issues   (A01_BrokenAccessControl) 
    public static void main(String[] args){           //Main method begins execution from here.     
        try {               
            XMLParser();               }                 catch (SecurityException e ){                  System.out.println("Caught exception: " +e);              }}         
public static void parseXML() throws SecurityException    {     Parser p = new SAXParserImpl(new InputSourceFile());           //Create a parser instance                SAXParser saxp=null;             try                 {"inputfile"}.equals(""){                   System.out_.println ("Error: File not found");}               String inputfileNameString  = "C:/xmlfiles/data01_brokenaccesscontrol";              XMLFile = new XmlReaderImpl(new InputSourceStream (System .currentTimeMillis()));
        //Create a parser instance                SAXParser saxp=null;             try                 {"input file"}.equals(""){                   System.out_.println ("Error: File not found");}               String inputfileNameString  = "C:/xmlfiles/data01_brokenaccesscontrol";              XMLFile = new XmlReaderImpl(new InputSourceStream (System .currentTimeMillis()));
        try {                          //Start of access control for security issue.  throw SecurityException if not allowed to parse the xml file               p=saxp;                  sxmlexists() }            catch     IOException   e)      {}             System..println ("Error: File cannot be read");}    }}
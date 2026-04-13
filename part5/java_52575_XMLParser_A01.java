import java.io.*;
import org.xml.sax.SAXException;   // import SAX parser from Java API to parse .XML file format using an event-based approach 
import javax.xml.parsers.*;       // Import the required classes for XML Parsing   
    
public class java_52575_XMLParser_A01 {     
// Declare a constructor method of type void, which is used when construct objects  
private static DocumentBuilderFactory dbf;        
          
 public java_52575_XMLParser_A01() {            super();       // Call the parent's construtor    }             @Override                  protected org.w3c.dom.Document parseFile(String filePath) throws IOException, ParserConfigurationException {                     return loadAndParse (filePath);      }}                
           public static DocumentBuilderFactory getInstance(){   if  dbf==null ;         // Instantiate only once    synchronized on the instance variable and method access          try{                  dbf = DocumentBuilderFactory.newInstance(); }catch(ParserConfigurationException e){                System .err......println ("Error in creating Factory"); return null; }}
           protected org.w3c.dom.Document loadAndParse (String filePath) throws IOException, ParserConfigurationException {       // Load an XML document and parse it             DocumentBuilderFactory dbFactory = getInstance();    try{               File   xmlFile  = new  File(filePath);                SAXParser saxParser   =     dbf .newSAXParser() ;              saxParser.parse (xmlFile, this );}catch         
      ....... }                 catch (IOException e) { System.....println ("Error occurred in parsing the file.."); return null;}  // Return Null if something goes wrong            }}             public static void main(String[] args){                try{                    MinimalistXmlParser xmlReader = new    ..MinimalistXmlP...er();              Document doc  =xmlReader.loadAndParse("src/sampleFilePathHere") ;                 ...}catch (Exception e) {System.....println ("Error occurred while parsing the XML file");}}
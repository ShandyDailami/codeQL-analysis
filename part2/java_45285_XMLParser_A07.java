import java.io.*; // Import Java I/O related classes  
import javax.xml.parsers.*; // Declare required XML parser class java_45285_XMLParser_A07 parsing xml documents   
import org.w3c.dom.*; // W3C DOM API is the main one in J2EE, which declares all interfaces and methods to be used by different software components of Java Platform SE Binary Products  
import javax.xml.transform.*; // Declare required classes for transforming XML documents into other formats   
import javax.xml.transform.dom.DOMSource;  // Used when source document is already in DOM tree structure (in memory) and it will be treated as input to the transformation process, otherwise an InputSource can't used  
import javax.xml.transform.stream.StreamResult;// A Transformer for transforming a Source into Result   

public class XMLParser {  // main program in Java    
static void parseXMLFile(String fileName) throws ParserConfigurationException, IOException{     
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
DocumentBuilder dBuilder  =dbFactory.newDocumentBuilder();          
DocType docType=dBuilder.setOutputMethod(OutputMethods.STD_OUT);             // Define output method of the doctype declaration   
XMLWriter xmlw = new XMLWriter("output/sample0123456789");          // Set location for writing to file   (create directory if not exists) 
dBuilder.setOutputMethod(OutputMethods.STD_OUT);             // Define output method of the doctype declaration    xmlw = new XMLWriter("output/sample0123456789");          Creates a writer for writing in to standard out   File file=new File ("C:/testfileXMLparserTestXml.xml") ; 
Document doc  =dBuilder .newDocument();            // Create document instance             Document doc = dBuilder .newDocument ();    xmlw.setIndent(2)          Creates a writer for writing in to standard out   System.out.println ("Creating new XML file");                     FileWriter fwriter= null; 
fwriter  = new FileWriter("C:/testfileXMLparserTestXml01",true );              // Writes the content into an existing document and appends data at end of this current open stream using a standard character-stream writer. It does not write any additional lines to disk, but only adds them as characters in memory until it is flushed by caller ie fwriter .flush ();  
FileReader fr = new FileReader("C:/testfileXMLparserTestXml01");            // Reads the content from a file into an instance of DOMDocument.  Document doc=dBuilder.parse(new File ("sample_xml"));                     domSource  = new DOMSource(doc) ;                  xmlw .write (domSource );               fwriter = null;
}}    } catch {   SystemOutErrorReplayException e1){}                        // Exception Handling to ensure the program does not terminate abruptly                    try{  dBuilder.setValidation(true);                docType=dBuilder...                   xmlw .flush();                                 fr  = new FileReader("C:/testfileXMLparserTestXml02");        
Document bDoc = null;                 // Parse a file into DOM document Document    domSource  =  .... }}} catch (Exception e) { System.out,println ("Error parsing the XML : " +e);  }}                    dBuilder .setValidation(true );                     try{ docType=dbuilder...
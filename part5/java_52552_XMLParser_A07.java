import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.*;  // Import FileInputSream, PrintWriter and SAXException classes to read the file stream in a sequential manner  
public class java_52552_XMLParser_A07 {    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException{    	FileInputStream fis = new FileInputStream("src/main/resources/data.xml");  // Create an inputstream from the file data.xml in your resources directory
  		        InputSource is=new InputSource(fis);    XMLReader xr=  XMLReaderFactory.createXMLReader();     DefaultHandler dh=null;      	xr.setContentHandler((ContenHandler)dh );      // Set contenthandler with the xmlreader to handle tags and attributes of a parsed document
         		  Parser p = null ;  	p =  new SAXParser() { public void parse(InputSource is, ContentHandler handler){    super .parse (is , dh); }};      		// Use parsers provided by external libraries as it'll be more efficient and secure.    	   
         		  // Parse the xml file using sax parser   p.setFeature("http://xml.org/sax/features/namespaces", true) ;   	p .parse(is , dh )	; }}; });     	// Call SAXParser method passing our input source and content handler to parse a document
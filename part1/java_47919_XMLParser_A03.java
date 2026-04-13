import java.io.*; // Import necessary classes like File, InputStream etc...  
import org.xml.sax.* ;//Import SAX parser (Standard API for parsing XML)..   
import javax.xml.parsers.;     //For Parsing the xml content to objects and methods of this interface are provided by default in JDK10/JAVA 8  
public class java_47919_XMLParser_A03{     
 public static void main(String[] args){         
 SAXParserFactory spf =SAXParserFactory.newInstance();            //Create a new factory object...       
 try {            
    SAXParser saxParser=spf.newSAXParser(true);       /*Creating the parser and setting true means that we need callbacks to parse  tags*/        
     XMLReader xmlreader = saxParser.getXMLReader();      //Create a new reader object..       
   ParserHandler pH=  new ParserHandler() ;    /**The class which implements parses events of the parser *//*Creating an instance for our custom handler**/      
  /*Setting event handlers*/         xmlreader.setContentHandler(pH);           //Set contenthandler to parse tags */     saxParser .parse("sampleXMLFile",xmlreader );    /**Parse XML file and set it as parser object's input source*//*.        }      catch (SAXException e) {       System.out.println ("Error parsing the document: " +e);  
                                                                                                                   };  //Catching exception if any occurs          */     }}`;  `}}));
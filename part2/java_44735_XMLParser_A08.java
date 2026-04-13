import java.io.*;
import org.w3c.dom.*;  // DOM (Document Object Model) library for parsing xml files in Java
// Import SAX parser which is used by libxml2 to parse the data of a document and read it line-by-line, without loading all into memory:
import org.xml.sax.SAXException;  
import javax.xml.parsers.*;  // for parsing XML file using DOM (Document Object Model) library   
public class java_44735_XMLParser_A08 {    
 public static void main(String[] args){        
 try{            
// Create an instance of the SAX parser:                  
SAXParserFactory spf = SAXParserFactory.newInstance();                   
           // Get a new SAX Parser from factory                    
SAXParser saxParser  = spf.newSAXParser(true);  
                  System.out.println("Parsing the XML file...\n");   
saxParser.parse("input.xml", new MyHandler());     // parse input xml          }              catch (IOException e){            consoleMsg ("Error in opening or reading a File.",e,ConsoleMessageColorEnum.RED_TEXT);        return;      }}   @SAX.Element() public void startElement(String uri , String localName
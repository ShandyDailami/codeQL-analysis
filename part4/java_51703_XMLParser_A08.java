import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;   // Import the InputStream class java_51703_XMLParser_A08 read file as stream 
    
public class Main {   
// Declare a SAX parser named saxParser for XML content in inputXML document      
SAXParserFactory spf = SAXParserFactory.newInstance();     
SAXParser saxParser;   // the concrete instance of Sparsers implemented by this interface 
    
Main(){    System.out.println("Parsing a Simple xml file"); }         void startDocument() {System.out.print("\n Call Start Document Event\n ");}        public static void main(String[] args) throws ParserConfigurationException, SAXException   //main method  Here we will read from the inputXML
{     String XMLfile = "inputFile.xml";    InputStream is=null;       try {is =  new FileInputStream(new java.io.File(XMLfile));} catch (IOException e)      System.out.println("Failed to open file :" +' '+e); return;} 
     saxParser = spf.newSAXParser();   // Creating a SAX Parser           {saxParser=spf..parse(is, new XMLReaderHandler());} }      void endDocument()    System.out.print("\n Call End Document Event\n "); public static 
void startElement (String uri , String localName ,    `  ` `public   //start element handler method for parsing xml document          {System . out . println("Start Element :" +localName);}      void endElement(String u ir,
import java.io.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
 
public class java_51053_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{       
           // Create a new instance of the DefaultHandler and feed it to an XMLReader      
            SAXParserFactory factory = SAXParserFactory.newInstance();     
               String xmlFilePath= "sample.xml";        
             SAXParser saxParser = factory.newSAXParser(null, new MyXMLContentHandler());        // Create a parser from the handler    
              try{   contents  = getClass().getResourceAsStream("/");       System.out .println("Parsing XML file " + xmlFilePath);    }catch (IOException e){System.err .println ("Unable to open input file - '"+xmlFIlePatH+"'" );      return;  }}
     private static MyXMLContentHandler contentHandler ;   // Declare a handler variable       void parse(String ) {        try{            XMLReader xr = saxParser.getXMLReader();          while (xr .nextToken() != javax.xml.parsers.SAXEventConstants.END_DOCUMENT);      }catch 
    catch   ......" + e;}}}     System.out("Parsing complete");}       }} // Declare a parser variable end of class MyXMLParser}}        `
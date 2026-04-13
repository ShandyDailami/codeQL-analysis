import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_50138_XMLParser_A08 {  // Start with a meaningful name for your program (MySAXHandler)  
    public static void main(String[] args){     
        try{      
            SAXParserFactory spf = SAXParserFactory.newInstance();    
            SAXParser saxP =spf.newSAXParser();             //Create the parser with default settings              
                                                 
            MyXMLHandler myhandler= new MyXMLHandler ();    // Create your custom handler   – a class that implements XMLReaderListener      
                                                                     
            String filename =  "samplefile";              /// Specify an xml file to parse, replace 'filename' below with desired path & name     .replace('s', '.') ;           spf.setValidate(false);                   // Use the parser for a SAX way of parsing - use this if you only need simple XML data  
            saxP.parse("samplefile", myhandler );          /// Parse filename into your custom handler – pass in file to parse and call read on it     
        } catch (Exception e){                            // Catch Exception for all errors                         println ("Error at line: "+e .getLineNumber());    return;                }}                  public class MyXMLHandler implements XMLReaderListener {                   @Override   publ…
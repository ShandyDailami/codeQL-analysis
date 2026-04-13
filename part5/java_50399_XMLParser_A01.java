import java.io.*; // For FileInputStream and BufferedReader
import javax.xml.parsers.*;// for XMLParser interface, class java_50399_XMLParser_A01 & SAXParser implementations  

public void parseXML(String fileName) {   
     try{     
         InputStream input = new FileInputStream("filename");  // replace "filepath" with your actual filename or its location.      
         
        /** Creating a parser for parsing the XML */
           SAXParserFactory saxPF = SAXParserFactory.newInstance();  
            **SAX Parser**     
             SAXParser saxParser = saxPF.newSAXParser(false);//Creates new instance of Sax parser   
              MyHandler myHandler=new MyHandler(); // create handler object for handling xml data    
           /** Calling parse method with Inputstream and Handler**     
             **XML parsing continues until all the elements are parsed. */ 
                saxParser.parse(input,myHandler);    }   catch (Exception e) {       System.out.println("Error in Parsing"+e );     }}          // End of Main method         public class Myhandler implements SAXHandler{      @Overridepublic void startElement(String uri , String localName, 
           **`Sring qname** `uri
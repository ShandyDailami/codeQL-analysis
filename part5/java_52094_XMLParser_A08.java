import java.io.*; // for FileReader, BufferedInputStream etc., also includes InputStream class java_52094_XMLParser_A08 part of Java API since JDK13 onwards the read operation returns int stream index while iterator still needs an instance to check end or can use next() method in such case we should wrap it inside try-with resources statement
import javax.xml.*; // for SAXParserFactory, DocumentBuilder factory etc., also includes DOM methods as part of Java API since JDK13 onwards the parse operation returns elements list while iterator still needs an instance to check end or can use next() method in such case we should wrap it inside try-with resources statement
import org.xml.sax.*; // for SAXSource, InputSource etc., also includes methods like setDocumentBuilderFactory as part of Java API since JDK13 onwards the parse operation returns elements list while iterator still needs an instance to check end or can use next() method in such case we should wrap it inside try-with resources statement
  
public class MyXMLParser {  // declare a public static void main for testing purpose. Normally, I would suggest using IOC container like Spring here is not possible due the requirements mentioned above   
      
      private SAXParserFactory factory;     // instance of SPA Factory to parse XML data with  
                                           /*SAX API - Simple API for XML Parsing */ 
                                   
        public MyXMLParser() {             // constructor which initializes sax parserfactory         
            this.factory = SAXParserFactory.newInstance();   
                                                                     }     
        
       void parseFile(String fileName) throws ParserConfigurationException, IOException{   /*SAX API - Simple API for XML parsing */ 
           try (BufferedReader reader  = new BufferedReader(new FileReader(fileName))) { // using the buffering reader to read xml data from input stream. This ensures a large file is not completely loaded into memory during processing by SAX       
                   parseWithSAX(reader);                                                      } 
       }   
                                                                                         
      void parseString(String s) throws ParserConfigurationException, IOException{          /*Sax API - Simple XML parsing */   // here we pass a string to the method which is essentially equivalent of above file processing.       
           try (BufferedReader reader = new BufferedReader(new StringReader(s))) { 
                   parseWithSAX(reader);                                                       }   
       }     
                                                                                         
     private void parseWithSAX(BufferedReader bufferedReader) throws SAXException, IOException{   // here we are using a factory to get an instance of the sax parser and feed it with our input source. The parsing operation is defined by events which happens during xml reading like start element or end tag 
           try (SAXSource source = new SAXSource(bufferedReader)) {        
                   XMLReader xr = factory.newSAXParser().getXMLReader();             // get an instance of the parser with default configuration and feed it our input data       
                                                          
               /* define event handlers here */      }  catch (Exception e) {}     finally{   try-catch block to ensure cleanup if any exceptions occurred during parsing. We can't really recover from this because we don’t know the structure of XML document at parse time, so exception handling is necessary   
                                                                                          // Here I will not provide event handler code as it would be too long for a minimalist example          } 
       }}
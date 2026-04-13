import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.*;
  
public class java_43539_XMLParser_A01 {  // Class name should match the file that is being parsed (example: ExampleSAX)   
    
 public static void parse(String filename){     
       SAXParserFactory factory = SAXParserFactory.newInstance();       
          try{               
              SAXParser parser=factory.newSAXParser(null);   //Creating a new instance of the XMLparser              
             InputStream is=  SecureXMLParser.class    .getResourceAsStream("/"+filename) ;  // Assuming this file exists in your classpath and has same name as input stream                   
              parser.parse(is,new MyHandler());          }        catch (Exception e){                   System.out.println ("Error parsing the XML: " +e);           }}       private static void log(String message) {         //Logging function only for testing            if(!message.isEmpty() && !EnvironmentUtils.get().isProduction()){             Logger logger = LogManager.getLogger();                try   
      (   )  {} catch ()catch{}logger .info("SecureXMLParser" + message);}}       public static void main(String args[]) {         log("\n\nParsing example XML file..." ); parse ("example2013A.xml");log("\nDone."); }
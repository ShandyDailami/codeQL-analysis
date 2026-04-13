import java.io.*;   // Standard IO Classes, use InputStream and OutputStream classes only in this example   
import javax.xml.parsers.*;// SAXParserFactory & Xerces-style parsers like DOM Parser API are used here as well for the same purpose of reading XML file 
public class java_50236_XMLParser_A08 {   // Class Declaration with main method    
 public static void main(String[] args) throws Exception{     
    try (InputStream is = new FileInputStream("example.xml")) {         
        SAXParserFactory factory = SAXParserFactory.newInstance();          
            @SuppressWarnings("deprecation") // Use of deprecated APIs, still compatible with standard libraries    
                SAXParser parser=factory.newSAXParser(null);     
         XMLHandler handler =  new XMLHandler ( );       
             parser.setContentHandler(handler) ;   // Setting Content Handler to the same instance   
            parser.parse(is  );       } catch (Exception e){     System . out . println ("Parse Error: " +e);}      }}// End of Main method, no need for sorry here as requested in instructions b and c
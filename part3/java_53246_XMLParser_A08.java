import org.xml.sax.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_53246_XMLParser_A08 {    // define the main program here    
   public static void readAndParse(String fileName) throws Exception{ 
       File inputFile = new File(fileName);     
        SAXParserFactory factory = SAXParserFactory.newInstance();         
        
           try {             
            SAXParser saxp = factory.newSAXParser(true, true );               
             MyHandler myhandler =  new  MyHandler();     // define the handler here      
               saxp.parse(inputFile ,myhandler);      }        catch (Exception e)   {           System.out.println("Parsing failed - not a valid xml file");    return;         }}          public static void main(String[] args){  try{ readAndParse("/path/to/yourfile") ;}catch(Exception ex ){}
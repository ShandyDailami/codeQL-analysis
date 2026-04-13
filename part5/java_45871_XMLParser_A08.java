import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
public class java_45871_XMLParser_A08 {  // Start of Class definition  
    public static void main(String[] args) throws Exception{    
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();     
          DefaultHandler handler= new SecureHandlingStrategy();               
         File inputFile = new File("sampleinputfilepath");  // replace with the file you want to parse here             
           try{   
               System.out.println(String.format("\nParsing XML using SAX in %s\n",  
                   (new java.util.Date()).toString()));     
         parser.parse(inputFile,handler);          // Parser begins parsing the file     }catch blocks    catch block for exceptions will go here        finally clause can also be written before closing brackets to make sure all resources get released successfully
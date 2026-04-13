import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
  
public class java_51842_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException  {        
        // Using DOM parser for parsing the file          
          try{            
            File xmlfile = new File("sampleFilePath");// your path of .xml here.  
              
              XMLParserImpl dom=new XMLParserDOM();    //create an object of Dom Parser  if you want SAX Parse then use Sax parser Impl instead     
                boolean isSAX=false;                 #Set true for sax parsing false otherwise      
            DOMHandler handler = new DOMHandler(xmlfile,dom);          /* Create a Handler instance passing file and dom object */ 
               if (isSAX) {                           // If SAX parse then call the startDocument method of Dom Parser Impl else pass null   }   
                 ((XMLParserImpl)(handler)).startDocument();       #Set true for sax parsing false otherwise     },null);         """              };  """);          println(res)             });        catch (IOException e){            System.out.*;println("Could not parse the file due to I/O error.",e ); }
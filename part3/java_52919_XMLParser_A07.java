import org.xml.sax.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_52919_XMLParser_A07 {  
    public static void main(String[] args) throws Exception{ 
        SAXParserFactory spf = SAXParserFactory.newInstance();      // Step A: create a factory instance of the parser      
         File inputFile= new File("sample.xml");              //Step B : Create an XML file for reading         
            try {                                            //Step C & D - Using Factory to get Instance and Opening Stream       
                SAXParser sp =spf.newSAXParser(true);           // Step E: create a parser instance of the sax        
                    MyHandler mh= new  MyHandler();              // Create Handler for parsing XML         
                   /*   A way to parse xml file */           
                sp.parse(inputFile,mh );                       
               }catch (ParserConfigurationException pce){       
                  System.out.println("Failed while parsing configuration" +pce);     //Step F - Handling Parsing Configuration Exception 
                   }      catch (SAXException sae) {                           
              System.out.println("Failure in processing of XML file "+sae );        // Step G & H: handling SAX exceptions            
               };  
    }}
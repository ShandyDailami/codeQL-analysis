import org.xml.sax.*;
import javax.xml.validation.*;
import java.io.File;  // For File I/O operations, only standard library classes are used here
  
public class java_53762_XMLParser_A08 {   
     public static void main(String[] args) throws Exception{       
         SAXParserFactory spf = SAXParserFactory.newInstance();         
          
         try (SAXParser saxp = spf.newSAXParser())  // create a new parser with the XML schema     
             {      
               String xmlFilePath="inputfilepath";        /* Insert your path here */  
                 File inputFile  = new File(xmlFilePath);    /* Create file object for given path *//               
                  
                  saxp.parse(inputFile,new MyHandler());  // parse an XML document with SAX          
             }      
              catch (ParserConfigurationException pce){         /* Handling exception when parser not configured */           
                 System.out.println("Cannot create the SAX Parser");         
                  pce.printStackTrace();  
               }        // end of try-catch block     
    }}  //end main method
import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
   import static java.nio.charset.StandardCharsets.UTF_8;  // Ensure UTF-8 is used for reading and writing XML content   
      
public class java_44035_XMLParser_A03 {     
     public void parse(String fileName) throws ParserConfigurationException, SAXException{       
          DocumentBuilderFactory dbFactory = null ;        
          try            (FileInputStream fis    = new FileInputStream("src/"+fileName))             //Reading from external files             
           )  
               {      
                   int content;               
                    while((content=fis.read()) != -1)    
                     System.out.print( ((char)content) );  ;         }      finally         
                       { f = null;}            //Closing the InputStream           try             (String xmlFile  = "sample.xml")  
                           dbFactory =  DocumentBuilderFactory .newInstance()    Logger log=Logger .getLogger("info");              XMLReader reader;       Reader in ;  BufferedReader buffRead ; char [] bufferChar = new char[1024]      boolean bClosable  = false     try             (FileInputStream fis    =  
                   new FileInputStream(xmlFile))          {            Document doc   = dbFactory.newDocumentBuilder().parse(fis)         log .info("The document is successfully parsed");       } catch  Exception e           {log .warning ("Problem parsing the document. " +e);      return;}    
    }}
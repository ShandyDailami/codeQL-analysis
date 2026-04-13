import org.apache.tika.Tika;
import javax.xml.parsers.*;
import java.io.*;
  
public class java_51502_XMLParser_A03 {    
    public static void main(String[] args) throws Exception{       
         Tika tika = new Tika();  // Use Apache's library for detecting the media type of files     
          String xmlContent;      
           try (FileReader reader =  new FileReader("path_to/yourfile.xml")) {   /* Read file content */    
                XMLReader xmlReader  = XMLReader.newInstance(reader);    // Use Apache's library for parsing the contents of a document     
                 Document doc = new SAXParser().parse(null,  xmlReader );        /* Parse and build an object representation from source data (content). */    
                  xmlContent =  tika.detect(doc);       /** Detected media type as text/xml or application/xml **/   // Here we're using Tika library which can detect the content of file, it is more secure against injection attacks 
           } catch(FileNotFoundException e) {     /* File not found */   
                System.out.println("The XML file was not found!");     
            return;          // End Program  
        }         /**/      
        if (xmlContent != null && xmlContent.contains("<script>")){  // Security sensitive operation: Check for script tags     /* Detected content is potentially a potential point of an injection */   
                System.out.println("\n Potential XML Injection Attack detected");      /**/  
        }else {       /** No injected data found **/         return;          // End Program  if no attacks are identified     };             /* If all the above conditions do not hold, end program */    });
import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
public class java_47294_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        // Create a new XMLReader instance with the default configuration for parsing xml files 
        XMLReader xr = XMLReaderFactory.createXMLReader();         
        
        String fileName="invalidFile";   /* Enter your invalid/unexpectedly signed filename here, e.g., "myfile.xml", it will load a sample untrusted (signed) xml */    
           // The path of the XML document is passed as an argument to main method for testing purpose   
        try {     
            xr.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd", false);   /* disable DTD validation (not recommended) */    
             // Parse the XML file  with XmlReader, by calling read() method    if there is a problem while parsing xml document then it will throw exception.         
            xr.read(new FileInputStream(fileName));      
        } catch (FileNotFoundException fnfe) {     
              System.out.println("XML file not found!");    
                //Exit from main method    if there is a problem with input XML document then it will throw exception here,  print the error details and exit  
               System.exit(-1 );        /* Exit program */       } catch (SAXException e) {      System . out ". ("+e);     // Print Error Detail    & stop calling read() method if there is a problem while parsing xml document, print the error details and continue to parse next XML file.  
               finally{          /* cleanup code here */         }        return;       }}`  end of java program `!:endjava'
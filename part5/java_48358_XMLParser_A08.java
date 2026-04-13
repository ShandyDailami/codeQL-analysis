import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.File;   // Import File Class to handle files and directories
    
public class java_48358_XMLParser_A08 {   
       public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
           String xmlfile = "input_filename";     
            try {            
               File inputFile = new File(xmlfile);   // Create an instance of InputFile and pass the file to constructor.   
               
                    SAXParserFactory factory=SAXParserFactory.newInstance();    
                     System.out.println("Using parser : "+factory.getClass().getName());       
                      SAXParser saxParser = factory.newSAXParser(inputFile.toURI().toString(), new XMLHandler());  // Create a handler   
                      
                        /* Call the parsing method */  
                    saxParser.parse(0);     }       catch (IOException e) {      System.out.println("Error reading input file.");          e.printStackTrace();        }}           public static class XMLHandler implements SAXHandler{  @Override    // Implementing the methods of handler interface .
   ...snip...}}`; /* Replace "..." with complete code snipped, this will be A08_IntegrityFailure in here */ } catch (SAXException e) { System.out.println("Error parsing XML file");  }}
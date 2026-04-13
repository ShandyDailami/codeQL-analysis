import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.net.URI;
import java.util.List;

public class java_51741_XMLParser_A01 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        String fileName = "src/main/resources/testXMLfile2"; // replace with your own XML File path    
         if (new File(fileName).exists()) {            
            DefaultHandler handler= new MyHandler(); 
              SAXParserFactory factory=  SAXParserFactory.newInstance();  
               try{          
                    SAXParser parser =factory .newSAXParser(null); //Creating a XML Parser using the above settings   
                      System.out.println("Parsed successfully");           
                     parseFileXMLContentBasedOnSecurityRules_A01 (fileName,parser ,handler );  }catch(Exception e){          
                       PrintWriter out=new PrintWriter ("C:\\xmlErrorLog2.txt", "UTF-8" ) ;         //Creating the Log file      
                        parser .setEntityResolver   ((XMLReader)out);                          #Set to log all error details into a textfile    
                      e.printStackTrace(  out );                         }}}            catch (Exception ex){             System.err.println("Error while parsing xml: " +ex ) ;}      });      `
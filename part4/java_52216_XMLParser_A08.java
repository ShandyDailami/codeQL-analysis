import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
 
public class java_52216_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{         
            String url = "file:./src/A08_IntegrityFailure.xml"; // Provide the path to your xml file here          
             
             DocumentBuilderFactory factory=null; 
        try {  
               factor=(DocumentBuilderFactory)new SAXParserFactory();   
            } catch (Exception e1){     
                  System.out.println("Problem in creating Factory");         
         }                   for (; ; ){     if (!((url =PromptForFile()) !=  null)) { break;  }}             factory= DocumentBuilderFactory .newInstance();    parser =  factor.newSAXParser( new InputSource(   url));      try        {Document doc      = (sax)parser.parse( );
 } catch{catch block here...}         printout_details about the document     eprint("XML details:");           printer =doc .getElementsByTagName ("*") ;             for (;;){ if (!printer ) break;}    try {  doc..writeTo (System.out);}}
        } catch(Exception ex)          // exception handling block...   });      }}            println("error: "+ex );         System . out -println('Problem in parsing : ' + xmlfile_pathname_);     return;                };  private String PromptForFile(){ ...return null;}    }
import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_49793_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException{      
        // Create an instance of XMLReader for parsing the xml file           
         SAXParserFactory spf = SAXParserFactory.newInstance();            
         try {             
               SAXParser saxparser = spf.newSAXParser( new LinkedStreamSource (  System.in ) );     
                MyHandler myhandler=new MyHandler() ;                 // Create a Handler       
                  saxparser.setContentHandler(myhandler);            // Set content handler for parsing the XML         
         } catch (Exception e) {          
              e.printStackTrace();                     
               System.exit(-1);                    
                }  
    }}  # End of Main Method
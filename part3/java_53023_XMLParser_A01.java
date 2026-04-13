import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.*;
public class java_53023_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException{    
        // Step 1: Initialize the parser using default settings (less secure).        
            SAXParserFactory saxpf = SAXParserFactory.newInstance();      
            
            /*Step2 : Set up a new factory and get an instance of it */  
               XMLReader xr  =saxpf.newSAXParser().getXMLReader();    //Creating the parser with default settings  .    
        System.out.println("Start Parsing...");            
            /*Step3: Use a DocumentHandler to process our xml file*/      
              SAXHandlers sh  = new SAXHandlers ( );  
               xr.setContentHandler(sh) ; //Setting the handler for content in this parser  .       
         try {      XmlPullParserFactory pf =new XmlPullParserFactory();    
             XMLReader myreader=pf.newPullParser();    ml_filein20siontmpl (myreader);   //Invoking the function to parse xml file  .       } catch(XmlPullParserException e1){ System.out.println("Error: "+e );}
               finally {      myReader = null;     return ;    }}catch(){System OutPrintln (" Error in Parsing File");}}}}}           //Step6 : Catch and handle the exception  .   }//end of main function        }; end section. It's important to mention that this approach has limitations as it may not work with all XML files due lack of validation (checks on xml for broken access controls)
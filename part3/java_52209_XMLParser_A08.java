import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.*;

public class java_52209_XMLParser_A08 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        String url = "file:///C:/sample1_A08-IntegrityFailure.xml"; # Path to your xml file; Replace with the actual path of XML File        
    	XMLParser parser=null;   
       try { 
           // Create a new SAX Parser   and feed it with our handler, which will do all we want on each tag/element:       
          parser = XML.newSAXParser();     
            MyHandler myHandler  = new MyHandler() ;    
            
        	parser.parse(url ,myHandler);    // parse the xml file  }       catch (Exception e) { System . out . println ("Parse Error");   },        );}          
          }catch (FileNotFoundException fe){System.out.println("file not found "+fe);}}     `
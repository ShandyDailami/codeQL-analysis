import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.FileInputStream;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import sun.security.util.SecurityConstants;
public class java_48540_XMLParser_A03 { 
    public static void main(String[] args) throws Exception{  
        SAXParser saxParser = null;           //Create a new parser for the Document     
         try {               
             FileInputStream inputStream=new FileInputStream("sample.xml");      
              System.out.println("\n Parsing the XML file..."); 
               DefaultHandler defaultHandler  = new CustomDefaultHandler();         
                                                       
                     // Create a factory for SAXParser and associate an Empty-Element Handler with it  
                 saxParser =SAXParserFactory.newInstance().newSAXParser(defaultHandler, SecurityConstants.DEFAULT_BUFFERED_CHARACTER_ENCODING);          
               /* Parse the input xml file */                  
             saxParser .parse(inputStream,"UTF-8");    //Parses an XML document into a SAX parser     
         } finally {  if (saxParser != null)   try{saaxParser.close();} catch(Exception e){e.printStackTrace() ;}}                System.out.println("\n Parsing Completed...!");        }}            // End of Main method    public class CustomDefaultHandler extends DefaultHandler { @Override     
public void startDocument (String uri, String name,       " encoding ) throws SAXException{System..         } ............   .........          . ..                 ...              };     if(saxParser != null) try{saaxPaser.close();} catch...;    }} //End of CustomDefaultHandler
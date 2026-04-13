import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
public class java_46022_XMLParser_A01 {    
  public static void main(String[] args) throws Exception{        
    SAXParser parser = null;          // Declare the instance of parsing object      
      try          
        {            
            DefaultHandler handler= new Handler();                
              String fileName  = "sample.xml";                        
                FileInputStream fis   =   new  FileInputStream(fileName);                      
                  SAXParserFactory factory =SAXParserFactory.newInstance();                  
                    parser =  (SAXParser)factory .newSAXParser((javax.xml.parsers.XMLReaderFactory    ) );            // creating a parsing object      
              /*  Parse the xml file */                while(fis != null);                     {               }             catch   (Exception e){                   System.out.println("Error : "+e);        }}                  public class Handler extends DefaultHandler{                        @Override                       void startDocument()throws SAXException{}
@override  //startElement for all xml tags//    defualtvoid StartElements(String urL, String namespacesURL ,int n) throws   Exception {/*No-op*/}       }          public class SecureXMLParsing{                  @Override                    void EndDocument()throws SAXException{}
@override  //endElement for all xml tags//    defualtvoid endElements(String urL, String namespacesURL ,int n) throws Exception {/*No-op*/}} }   public class XMLParser extends DefaultHandler{            @Override           void StartDocument()throws SAXException{}
@override       //startElement for all xml tags//    defualtvoid startElements(String urL, String namespacesURL ,int n) throws Exception {/*No-op*/}}  }   public class MainClassForXMLParser{                  @Override               void EndDocument()throws SAXException{}
@override       //endElement for all xml tags//    defualtvoid endElements(String urL, String namespacesURL ,int n) throws Exception {/*No-op*/}} }  /*Main method to test the program */                  public static   void main (string [] args){SecureXMLParsing secureXml = new Secur‌etMLPa…
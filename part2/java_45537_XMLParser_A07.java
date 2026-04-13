import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_45537_XMLParser_A07 {
    public static void main(String[] args) throws ParserException{  
        String xmlFile = "authfailuretestdata_A07.txt";  // provide your XML file here     
         SAXParserFactory spf=SAXParserFactory.newInstance();    
         SAXParser sp=spf.newSAXParser(true);   
          MyHandler mh= new MyHandler() ;  
        sp.parse(xmlFile,mh)  ;           
      }      
}            
class MyHandler extends DefaultHandler{               
public void startDocument(){                     System.out.println("Start of Document");     }                    public    void endDocument (){                  System.out.println ("End Of Document" );          }}                   }) .;   if(is)+=a07_AuthFailure` 214A ` AO]=='
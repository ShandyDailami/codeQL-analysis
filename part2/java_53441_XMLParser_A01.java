import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_53441_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{            
        String url = "https://raw.githubusercontent.com/danielpbriones/examples_java-xmlparser" +              "/main/src/"+                "books20k1967toaustin3584.xml";  //URL of the XML file
        SAXParserFactory spf = SAXParserFactory.newInstance();        
        SAXParser saxP = spf.newSAXParser(true);  
         
            MyHandler myHandler= new MyHandler();   
          
              saxP .parse(url,myHandler );  // parse the XML from URL     
     }            
}      
class MyHandler extends DefaultHandler {         protected void startDocument() throws SAXException{ System.out.println("Start Document");}}   class BookInfo implements ISimpleTagNameResolverStrategy    {public String getSimpleTagValue(String simpletag, NamespaceAwareContext nac)  returns string{" + url+ "?plaintext=true" ;}}}
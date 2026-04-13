import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_47807_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String url = "https://example.com/sample_authfailure.xml"; // replace with your URL or file path 
        
        getXMLDetails(url);          
    }  
      
    public static void getXMLDetails(String url) throws ParserConfigurationException, SAXException{    
          String language = "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd";      // Declaring the parsing method and version  
          
        // Create a new instance of DocumentBuilderFactory   
         XMLReader reader=DocumentBuilderFactory .newInstance().newSAXParser()       .getXMLReader(language);    
          MyHandler mh = new  MyHandler();             
               reader.setContentHandler(mh );  
           /* parse the xml file */       
             SAXSource source  = new SAXSource(reader);    // Create a Source from XML Reader     
            reader.parse(source, mh) ;       }    
}  class MyHandler extends DefaultHandler { public void startDocument() {}        
public void endDocument(){System.out.println("End of Document");}}   /* Define your handler methods */    @Override           //Start element             private boolean isAuthFailure=false;              protected String authFailMsg =null ;            … }@Override          /** Callback for start-element events, called once per tag name    
public void startElement(String uri , DocumentLocator dl , String qName) throws SAXException{if (qName.equalsIgnoreCase("authFailure")) isAuthFailure=true;else if(!isAuthFailure && qName .equals ("message") ) { authFailMsg = ""; }}  @Override          //End element     public void endElement(String uri, DocumentLocator dl , String elementLocalname) throws SAXException{}  
@Override           /**Characters called once per character (typically ASCII), or when the entire document is read.*/      protected void characters(char[] ch, int start, int length )throws SAXException{ if (!authFailMsg .equals("")) authFailMsg += new String(ch ,start  ,length );} @Override          //Start prefix-mismatch         public void startPrefixMapping (String uri , String prefix) throws SAXException{}  
@Override           /**End Prefix Mapping*/      protected void endPrefixMapping (String uri, String prefix )throws SAXException{}}
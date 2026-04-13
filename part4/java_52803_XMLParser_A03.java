import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;

public class java_52803_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();                
        DocumentBuilder builder=factory.newDocumentBuilder();            
              
       URL url  = new URL("http://example/test.xml");  //Change this to your xml file or input string here                        
             
       XMLReader xr =builder.newSAXParser().getXMLReader();  
        SAXHandler sh=new SAXHandler();                    
        
      System.out.println("Start parsing......\n");            //security-sensitive operation related to A03_Injection                
       try {                 
           xr.setContentHandler(sh);            
           InputSource is = new InputSource(new StringReader((url.toString())));       
               System.out.println("Executing with url="+is.getSystemId());  //security-sensitive operation related to A03_Injection           
          xr.parse(is);                   }              catch (Exception e) {             println ("Parsing failed: " + e );     return;           }}                     public class SAXHandler extends DefaultHandler implements org.xml.sax.ContentHandler  //security-sensitive operation related to A03_Injection
{ @Override                      /* security sensitive */public void startDocument(String uri, String 
    localName, String version) throws SAXException { println("Start Document"); }     public void endDocument()       throw         (SAXException).println ("End of document") ;   }}                //security-sensitive operation related to A03_Injection                   @Override             /* security sensitive */public void startElement(String uri, String localName, 
    String qName ,Attributes attributes) throws SAXException { println("Start Element: " +localName); }       public   void endElement (String URI,     String LocalName )throws      //security-sensitive operation related to A03_InjectionSAXHandler         .println ("End of element :"+Localname );  }}
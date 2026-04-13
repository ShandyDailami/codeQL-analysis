import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_44609_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String xmlData = "<note><to>Tove</to><from>Jani</from><message>Vanilla Java XMLParser example program.</message></note>";  //sample data for testing purpose    
              
           try {            
            SAXParserFactory saxPf = SAXParserFactory.newInstance();               
              SAXParser saxParser=saxPf.newSAXParser(true);// use true to get full content      
                      
                  MyHandler myHandler  = new  MyHandler ( );           //create a handler for xml data    
                     
                   /** parse the XML file */        
                   saxParser .parse("datafile",myHandler) ;    }      catch(Exception e){                System.out.println ("Caught Exception: "+e);             }}  class MyHandler extends DefaultHandler {           public void startDocument()     {}          //handle the document level events           
public void endDocument ()       {}         public   void startElement ( String namespaceURI,String localName ,     `
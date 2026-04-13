import java.io.*; // for InputStream, OutputStream and FileReader/Writer classes 
import org.xml.sax.*; // SAX Parser interface from Java XML processing framework  
import javax.xml.parsers.*; // Provides APIs to parse an entire document or stream of characters into a DOM tree (Model of the Document)   

public class java_52802_XMLParser_A01 { 
     public static void main(String[] args){     
         try{       
             SAXParserFactory saxPFactory = SAXParserFactory.newInstance();         
             SAXParser saxParser=saxPFactory.newSAXParser(true); // creates a new XMLReader instance          
             
             InputStream inputstream  = XmlParser.class .getClassLoader().getResourceAsStream("samplefile");   ## change to the path of your xml file   
              
            saxParser.setEventHandler((SAXHandler)new MyContentHandler()); // set our handler         
             
             System.out.println ("Parsing XML File with SAX...");       
                  
                      sAXParser .parse(inputstream, new SAXSource(  (ReadElementContentListener )   inputstream));     ## change to the path of your xml file   
                          }          
         catch(Exception e){          System.out.println("Error: " +e);      return;        }}              public class MyContentHandler implements  sax.ContentHandler{       @Override             // This method is called when an element's beginning is found   ## add your security sensitive operation here           
public void startElement (String uri, String localName , String qName, Attributes attributes){      System . out . println("Start Element : " +qName); }        @Override             // This method is called when an element's closing  found   ## add your security sensitive operation here           
public void endElement (String uri, String localName , String qName ){     System.out.println ("Ending of Start Element: "+qName );}       }          @Override             // This method is called when an error occur during parsing   ## add your security sensitive operation here           
public void fatalError (String error){  System . out . println("Fatal Error :" +error); }}
import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
 
public class java_51792_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{     
        XMLReader reader;      
          Reader filereader;    
             try           
              // Step (a): Load the xml document.        
               File inputFile = new File("inputfile"); 
                int size=(int) inputFile.length();   
                  byte [] buffer = new byte[size];     
                   FileInputStream fis = new FileInputStream(inputFile);      
                    fis.read(buffer);       
                     fis.close();          // Step (b): Security sensitive operation end here            
                       reader=SAXParserFactory.newInstance().newSAXParser().getXmlReader(new StringReader(new String(buffer)));        
                         Handler handler = new ContentHandler(){   public void startElement(String uri,    String localName , String qName ,Attributes atts)throws SAXException {}};     // Step (c): Security sensitive operation end here            System.out.println("Parsing the XML document with SecureXMLParser");        reader.setContentHandler((ContentHandler) handler);         
                          try{reader.parse(new InputSource(new StringReader(new String(buffer))));}catch (Exception e){System.out.print("Error in parsing xml due to "+e );}};    }      // Step f: Remove the comment and make it syntactically correct code
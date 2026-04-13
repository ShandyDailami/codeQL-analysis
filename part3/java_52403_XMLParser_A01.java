import org.xml.sax.*;
import java.io.*;
public class java_52403_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String xmlFile = "samplefile"; // Replace this with your XML file name and path            
          
            try 
                ( FileInputStream fis =  new FileInputStream(xmlFile)) {             
                    Source src  = new SAXSource(fis);                
                     
                        SAXParserFactory spfactory=SAXParserFactory.newInstance();     
                         
                         SAXParser sparser =spfactory.newSAXParser(null,src );  // Create a parser using the source    xml file and register our handler   for XML elements             
                      
                    MyHandler mh=  new MyHandler ();                    
                     
                        sparser .parse( src ,mh ) ;         } catch (FileNotFoundException e) {          System.out.println("Error: File not found!" );    e.printStackTrace();  }}   // end main    
                   class Main{       public static void startElement              (String uri, String localName      ,        String qName ) throws SAXException{}            }//end innerclass                MyHandler extends DefaultHandler {          @Override           public         void    startDocument(String URI,  String   LANGUAGE_TAG)throws     XMLStreamException{}}
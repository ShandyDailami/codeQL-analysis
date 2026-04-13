import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52023_XMLParser_A07 {    
    public static void parse(String fileName) throws ParserConfigurationException, SAXException{        
        // Create a new instance of the DefaultHandler  
          DefaultHandler dh = new DefaultHandler(){            
              @Override 
                /* This method is called when an element's start tag matches this */              
                  public void startElement(String uri, String localName , String qName) throws SAXException {                    
                      System.out.println("Start Element: " +qName);     
                   }    
              @Override  /* This method is called when an element's end tag matches this */              
                  public void endElement(String uri, String localName , String qName) throws SAXException {                    
                      System.out.println("End Element: " +qName);     
                   }    
              @Override  /* This method is called when an attribute's value matches this */              
                  public void characters(char[] ch, int start, int length )throws SAXException{                       
                    String str = new String (ch ,start,length).trim();                          // Converting to string         
                   if(!str.isEmpty()){                      
                     System.out.println("Character: " + str);                            }          
             };     
            /* This will create a parser using the DefaultHandler and parse file */       XMLReader reader =   SAXParserFactory . newSAXParser(). getXmlReader(dh );         readXML (reader ,fileName) ;  // Reading from File         
        });   
     }              
             private static void readXML(XMLReader xr, String source ) throws ParserConfigurationException, XMLStreamException{           Xr.setContentHandler((Conten hanlder) );         while (xr .hasNext()){            Xr_.next();      };        }}  // Closing reader
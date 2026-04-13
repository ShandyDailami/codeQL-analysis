import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52341_XMLParser_A07 {
    private DefaultHandler defaultHandler = new DefaultHandler(){
        @Override
         public void startElement(String uri, String localName, 
                               String qName, Attributes attributes) throws SAXException{
                System.out.println("Start Element: " +qName);                 
            }     
           // Implement security sensitive operations here e.g.: check if the user is authenticated   
        };    
         public void endElement(String uri, String localName , 
                               String qName) throws SAXException{            
                System.out.println("End Element: " +qName);                   
            }     
          // Implement security sensitive operations here e.g.: check if the user is authenticated   
         public void characters(char ch[], int start, 
                               int length) throws SAXException{      
                System.out.println("Characters: " + new String (ch ,start ,length));            
            }      };    
         
        XMLReader xmlr =  
           SAXParserFactory.newInstance().   
                        newSAXParser(new InputSource( 
                       new StringReader("<root>Hello World! </root>")));      
         try {                         // parse the document           
             System . out . println ( " Parsing the XML file");       
              xmlr.setContentHandler((Conten hand ler) );     }  catch(Exception e){   
               System err.println("Problem parsing your request: $e"   ) ;            };                 // set default content handler             return;      }}      `
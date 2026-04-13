import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_53481_XMLParser_A07 extends DefaultHandler {   // SAX parser that does not require a separate parsing library such as DOM, JDOM or StAX (Streaming API for XML) 
    boolean bUser = false,bPassword=false ;      // flags to identify if 'user' and/or 'password' are found in xml element. This is just an example security sensitive operation not recommended using this way due it has complexity issue  
    
       public static void main(String[] args) {   
           MySAXParser parser = new MySAXParser() ;  // create the SAX Parser instance and call parseFile or other method as per requirement.     
          }       
         @Override                                                                                                                     
            public void startElement ( String uri, String localName ,String qName   ) {                                 
              if(qName .equalsIgnoreCase ("user"))  bUser= true ;     // when a 'username' element is found in xml file    print it out.      else                    /* password not identified */                  
            }         @Override                                                        public void endElement ( String uri ,String localname   , string qname ) {                                                                                 if(qName .equalsIgnoreCase ("user")) bUser = false ;  // when a 'username' element is found in xml file    print it out.           else                    /* password not identified */                     
            }     @Override                                                        public void characters ( char [] ch, int start ,int length ) {                                                                          if(bPassword) System .out .println ("[PASSWORD]:" + new String  (ch ,start ,length)) ; // print the content when a 'password' element is found in xml file.    }
}
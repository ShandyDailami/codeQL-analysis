import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_46734_XMLParser_A07 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        String url = "http://www....";  // provide your URL here for testing purpose      
        
        DocumentBuilderFactory factory = 
            DocumentBuilderFactory.newInstance();            
              
        try {                        
           XMLReader reader  = factory.newSAXParser().getXMLReader();   
                   
                   DefaultHandler handler = new MyContentHandler(url);               
                    
                  // Start parsing at this element  
                 reader.setContentHandler(handler ); 
                     
               InputSource source=null;        
                           if ( url == null ) {         
                         System.out.println("Null Url");           return ;       }     Source s = new URISource(url);    // or FileSource, etc..  
                             else{              source =  new InputSource(s)  };        reader .setCharacterEncoding( "utf-8" );        
                 Reader r=reader.getReader();             String TAG_LOCALNAME ;       while ( true ) {          try      {                if (! (( XMLStreamTokenizer )r).hasNext()   ) break;     } catch    ( SAXException e  ){ System.out.println( "An error occurred" +e );                  return;}       
                   TAG_LOCALNAME =((XMLStreamTokenizer) r ). getLocalName();      if("AuthFailure".equalsIgnoreCase(TAG_LOCALNAME)) {                    // your security-sensitive operations here    }             }}   catch ( ParserConfigurationException e1 ){ System.out.println ("Fatal parsing error: " +e1); return;}       
                 try                  { r .close();     }       catch( IOException ioe)  {}                };}}
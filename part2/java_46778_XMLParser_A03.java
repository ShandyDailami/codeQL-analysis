import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.FileInputStream;  
public class java_46778_XMLParser_A03 {    
    public static void main(String[] args) throws Exception{      
        SAXParserFactory spf = SAXParserFactory.newInstance();     
        SAXParser sp = spf.newSAXParser(true);  // Create a new instance of the parser  
          
        InputSource is =  new InputSource (new FileInputStream("data/inputfile1"));   
         
         MyHandler mh= new MyHandler() ;    
            
            sp.parse(is,mh );      
      }  // end main method              
}               
class MyHandler extends DefaultHandler{        private int depth;   public void startDocument(){depth =0;}    @Override          public void startElement (String uri , String localName     , String qName           , Attributes atts) {System.out.println ("Start of Element : "+qName);}     
@Override         public  void endElement(String uri,   String localname        , String    qualifier){ System . out . println ( "\n End Of element:     \t" +localname ); }       @Override          protected boolean ignorableWhitespace(char[] ch) {return true;}     
@Override         public void startPrefixMapping  (String prefix,   String uri ){ depth = 0;    System.out . println ("\n Prefix :     "+prefix +" URI : \t"  +uri);}       @Override          protected boolean warningReport(Warning w){ return true;}     
@Override         public void endPrefixMapping  (String prefix) {depth =   depth -1;    System.out . println ("End of Prefix:     "+prefix );}} //end MyHandler class        }//XmlSAXParser Class
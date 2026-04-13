import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_50642_XMLParser_A01 {
    public static void main(String[] args){  
        try{    
            SAXParserFactory factory = SAXParserFactory.newInstance();      //step 1a          
            SAXParser parser=factory.newSAXParser(Class.forName("org.xml.sax.InputSource"));    # step 2b      
            
            MyHandler handler  = new MyHandler ();     # Create a Handler for the XML Document      //step3e  
                                                                                    /// Here we create SAXparser and attach our custom xmlhandler         
              parser.parse("samplefile.xml", handler );    } catch(Exception e){       printStackTrace();  }}            public class MyHandler extends DefaultHandler{public void startDocument(){System.out.println ("Start of Document");}   # step4c     //Step5a StartElement is called when an element starting tag matches the pattern         
             @Override    public void endDocument() {printStackTrace(); } …..        /*Steps for handling other XML tags */}}`};
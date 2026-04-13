import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_49475_XMLParser_A03 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        String url = "inputfile.xml"; // input file to parse      
        
            getDataFromXMLFileUsingSaxParser(url);         
     }     
          
     private  static void getDataFromXMLFileUsingSaxParser (String input) throws ParserConfigurationException, SAXException{  
        SourceResolver resolver = new SourceResolver();   
             
         DocumentBuilderFactory factory=resolver.getDocumentBuilderFactory(input);         
             XMLReader reader=  factory .newSAXReader();     // Create a sax parser          
                MyHandler handler  =new  MyHandler();   //create an instance of myhandler     
                    reader.setContentHandler(handler );    // set contenthander for SAXParser       
                      reader.parse(resolver.getDocumentSource (input));       }     private static class SourceResolver extends DefaultHandler {          @Override public InputSource resolveEntity  (String publicId, String systemId) throws *SAXException{ return new InputSource(new StringReader(""));}}      // this is a dummy implementation of inputsourcereader. it will never be called             
     private static class MyHandler extends DefaultHandler {          @Override protected void startElement   (String uri ,  int n, String name) throws SAXException{ System .out。println (" Start Element : " +name);}           //prints the element names       }    }}`
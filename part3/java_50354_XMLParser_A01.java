import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_50354_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{     
        String url = "http://example/access_control";  //replace with your XML file URL    
        
            getDocumentInfo(url);      
             }          
         
private static void getDocumentInfo(String documentUrl){  
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();     
        try{             
                SAXParser saxParser=factory.newSAXParser();              
                 XMLReader xmlreader=  saxParser.getXMLReader();         
                     ParsingHandler handler =  new ParsingHandler ();   //create a parsing object   
                  xmlreader .setContentHandler(handler );       
                xmlreader  .parse(new InputSource(documentUrl));       }     catch(Exception e){      System.out.println("An error occurred while executing the code");}           };        
          public class ParsingHandler extends DefaultHandler{    //create a handler for parsing            @Override        public void startDocument(){System.out.print ("Start of Document \n")}             ;              ..... (rest content)   }      private static final String CHARSET = "UTF-8";
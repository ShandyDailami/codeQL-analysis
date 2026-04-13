import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.events.StartElement;
import org.w3c.dom.Document;  //Import Document from w3c package to get DOM of the parsed document  
public class java_52014_XMLParser_A01 {   
     public static void main(String[] args) throws Exception{         
           String fileName = "sampleFileForTestingBrokenAccessControl";      
            try     
              {         File xmlfile  = new File(fileName+".xml");  //Create a new instance of the XML-document.    
                DocumentBuilderFactory dbFactory = 
                    DocumentBuilderFactory.newInstance();       
                 SAXParser parser = dbFactory.newSAXParser();      
                  MyHandler myHandler= new MyHandler();     
                                                          
               parser.parse(xmlfile,myHandler);         // invoke the handler for start elements   }          catch (Exception e)  {    System.out.println("Error parsing XML file" +e );     }}            class MyHandler extends DefaultHandler{        public void startDocument()       {@Override            
public void endDocument(){System.out.print("\n End of Document");}         @Override          //Handles Start Element (in this case, namespace).    }@Override           public java_52014_XMLParser_A01(String uri , String localName   /* ... */) {     System . out . print("Start " +localname );}}
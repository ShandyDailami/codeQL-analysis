import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
public class java_44359_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{ 
        //Create a new instance of XMLReader: StAX in this case     
         SAXParserFactory factory =SAXParserFactory.newInstance();      
          SAXParser saxParser=factory.newSAXParser();    
           MyHandler myHandler  = new MyHandler ();   
            String fileName =  "example1-20kBFile.xml";  //your xml data source  
             Reader reader = null;     
              try {               
                 // create a BufferedReader to read the XML from .XML File    
                  reader= new BufferedReader(new InputStreamReader(       getClass().getResourceAsStream("/path_to_"+fileName),"UTF-8")); 
                   } catch (IOException e) {}           finally { try{reader.close();}catch(Exception ex){}}     
                    saxParser .setContentHandler(myHandler);     // set the content handler      
                     while(( reader.read() ) != -1 );    // parse XML file using SAX  
                      } 
                       public class MyHandler implements SAXHandler {            @Override        public void startElement (String uri, String localName,      String qName ,Attributes attributes) throws     SAXException{ System . out. println(" Start Element : " +qName);}       //handle element and attribute information  
                                                }                     Public  Class: MyHandler ends Here             @Override        public void endElement (String uri, string localname, String qname )throws    SArrxception {System .outprintln ("Ending Elements"+QNAME );}}     SAXException      //exception handling       if(qName.equals("employee")){ return;}         System  outprint linemsg;}}}
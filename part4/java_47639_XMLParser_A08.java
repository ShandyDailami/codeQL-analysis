import java.io.*;  // Import FileInput and FileOutput streams, etc (no external frameworks)  
import javax.xml.parsers.*;  // For parsing XML data with SAX parser like org.apache.xerces.* packages   
    
public class java_47639_XMLParser_A08 {     
       public static void main(String[] args){         
           try{             
               FileInputStream fis = new FileInputStream("sampleInputFile.xml");   // Create a file input stream       
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));  // Read the xml content from your sample XML    .      
            
                SAXParserFactory factory=SAXParserFactory.newInstance();        
               SAXParser saxParser=  factory.newSAXParser();      /*create a new parser*/    
       
           MyHandler myhandler = new  MyHandler ();              // Create an instance of handler which will be called when parsing is done       .           
          saxParser.parse(br,myhandler );                    /**/    parse the XML file into DOM tree      */   /* create a parser for reading xml and provide event*/          
             br.close();                                     /* close reader  before end of main method              /                      // closes BufferedReader        .           
                                                             }catch(Exception e){                        System.out.println("Error parsing the XML"+e);     };   }}      ** End Of Main Method ****       */   
           private class MyHandler extends DefaultHandler {  /* This is a custom Handler, to handle any event of xml file like startElement ,endelement etc...*/         @Override public void startDocument( ) throws SAXException{System.out.println("Start Document"); }          // Handle the document being parsed (not just an element)      
                                                          /* ... */    /**/  };                             }}                                                                   ** End of MyHandler Definition ****       `});**/*End Of Main Method*'''};//end main method}};*/
import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_43091_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        String fileName = "sample_file"; // replace with your xml filename here    
        
        try {            
            XMLReader reader=null;          
              Reader file=new FileReader("src/main/"+fileName);      
                reader =  XMLReaderFactory.createXMLReader();         
                  SAXParser saxp = SPAJP.newSAXParser(true, false );      // create a new instance of the parser   
             ParsingSecurity ps=   (ParsingSecurity)saxp;      
              reader.setContentHandler((ContentsHandlers )ps);     # set up our content handler to use sax hander with 1024 bytes buffer size     
                System.out.println("start parsing " );           // print start of the parser         
                  while (true) {                  
                      try{             if (!reader.parse(file))         # loop until parse is done              break;            }               catch  (Exception e){        Logger log =LogFactory .getLogger (" Parser");       ExceptionManager em= new    ErrorHandler();log.error("xml parsing failed:",e);em  
                      }}     println( "end of file" );          #print end message                 }         catch  (ParserConfigurationException e1){ Logger log =LogFactory .getLogger (" Parser");       ExceptionManager em= new ErrorHandler();log.error("parser configuration failed:",e);em}
        }}
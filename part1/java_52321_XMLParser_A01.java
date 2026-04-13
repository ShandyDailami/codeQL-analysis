import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_52321_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String url = "http://www.example1234567890/yourfile";  // replace with your file URL or local xml file path here        
          
        XMLReader reader;         
        try {            
            Reader fileInReader = new FileReader(url);             
                     
                SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();  
                  
               // Create a new parser using the factory   
                 SaxParserHandler myHandler =  new SaxParserHandler();     
                  reader  =saxParserFactory .newSAXParser(new Properties()).getXmlReader();      
                reader.setContentHandler(myHandler);       
                     
              /* Call parse method to start parsing process */ 
             //reader.parse("http://www.example1234567890/yourfile", myHandler );         
                  } catch (FileNotFoundException e) {     
                System.out.println(e);          
            return;    
        }}   });      
  */         };    // end of main method            
};
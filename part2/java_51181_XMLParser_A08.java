import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_51181_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String xmlFile = "src/main/resources/example.xml";          // Provide the path of your input file            
          
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
        SAXParserFactory spFactory=SAXParserFactory.newInstance(); 
        
        try{           
               SAXParser saxParser =  spFactory .newSAXParser( new XMLReaderFactory() );    // Create a default handler and start parsing the file          
                MyHandler myHandler = new MyHandler();         
             
             /*   Start Parsing  */     
                
            saxParser.parse(xmlFile,myHandler);        
               System.out.println("SAX XML parsed successfully.");        }catch (Exception e){                  // Catch the exception if any      
                e.printStackTrace();                      }}     catch (ParserConfigurationException ex) {                   Exit with error                 return;  };            });
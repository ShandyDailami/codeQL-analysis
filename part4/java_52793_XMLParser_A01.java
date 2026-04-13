import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52793_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String xmlFile = "src/main/resources/sample-file.xml"; // replace with your own file path or url 
              
        XMLReader reader;  
          
        try {            
            Reader filereader = new FileReader(new java.io.File(xmlFile));      
                  
              SAXParserFactory factory=SAXParserFactory.newInstance();     
                 
                 // Create a SAX Parser   
                reader  =factory .newSAXParser();              
                          
            MyHandler handler = new MyHandler();         
                      
             reader.setContentHandler(handler);    
                  
              // Parse the file      
              reader.parse(filereader );        } 
           catch (FileNotFoundException e) {     
                System.out.println("Unable to find xml file");   
            }  
          finally{         if (!((SAXParser)reader).getUnderlyingSAXInstance().isNaN())       reader .close();}     // Close the SAX instance and clean up connections        }}
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
  
public class java_45678_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String inputFile = "inputfile"; // Replace with your file name here                
          
        try 
            {            
                DocumentBuilderFactory dbFactory = 
                    DocumentBuilderFactory.newInstance();             
                       
                XSDValidator xsdVal = 
                  dbFactory.newXSDValidator(new Source(new File(inputFile + ".xsd")));              
                     
                 SAXParserFactory saxFactory =  
                     SAXParserFactory.newInstance();            
                      
                   SAXParser saxParser  =   
                        saxFactory.newSAXParser( new InputSource(       // Source of the XML document     
                            new FileInputStream (inputFile + ".xml")),     // Warn if more than one root element 
                    xsdVal);          
                     
                 MyHandler myHandler =  
                     new MyHandler();            
                      
                   saxParser.parse( inputFile+".xml",   
                              myHandler );           
                                  } catch ( ParserConfigurationException e ) {             
                System . err     . println  ("Could not create SAX parser" ,e);          return;       }   // Catch and handle exceptions      },         };             });
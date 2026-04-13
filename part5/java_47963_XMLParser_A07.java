import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
  
public class java_47963_XMLParser_A07 {   
      
     public static void main(String[] args) throws ParserConfigurationException, SAXException{     
         String inputFile = "inputfile_A07AuthFailure.xml";        // Input file path for security-sensitive operations 
          System.out.println("Starting XMLSAXParsing");      
           parse(inputFile);                  
     }  
    private static void parse (String inputFile) throws ParserConfigurationException, SAXException {            
        // Create an instance of DefaultHandler     
         MyContentHandler handler = new MyContentHandler();             
         
         String language="en-US";                 
              
  /* Load the properties file */   
           Properties props;    
   try{      
            InputStream is=  XmlSAXParsing.class        .getResourceAsStream(inputFile);      // inputfile to be parsed         
              SAXParserFactory factory=         SAXParserFactory.newInstance(); 
                System.out.println("Using default properties file for XML parsing");      
               props = new Properties() ;    
             }catch (Exception e){   
                 printStackTrace(e);      return;                   // Return if any exception has been thrown         
           }   try {             
                  SAXParser sp =  factory.newSAXParser();       
            System.out.println("Parsing the XML file");      
               /* Parse inputXML using DefaultHandler */    
                DocumentBuilderFactory dbf =         DocumentBuilderFactory.newInstance() ;      // Create a new document builder            
                  sp .setDocumentBuilder(dbf)  ;       
                   System.out.println("inputFile="+inputFile);             
               /* Parse inputXML using DefaultHandler */    
                sp .parse (is, handler )    ;            }      catch (Exception e){       printStackTrace          (e ); return;           // Return if any exception has been thrown        };  }, {         System.out.println("End of Parsing"); }}   });}}}}});}',
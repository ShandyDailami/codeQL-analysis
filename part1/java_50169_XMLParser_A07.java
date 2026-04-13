import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_50169_XMLParser_A07 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        String xmlFile = "path/to/your_file";  // replace with your file path here  
        
       /* Creating a new instance of the DefaultHandler. */    
        Handler myDefaultHandler  =new CustomSAXParser();   
         
          
      /** Reader object to parse through XML source*/            
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();   //Creates an implementation for parsing the xml documents 
             
        try{    
               /* Creating a new instance of the parser */      
                SAXParser saxParser=saxParserFactory.newSAXParser(    );     
         
                  /** Parsing and handling XML data   with our custom Handler*/            
                    System.out.println("Parsed Data: ");              // print it out here because we use a default implementation 
               saxParser .parse (xmlFile, myDefaultHandler);        /* parsing the xml file */    }catch(Exception e){         /** Catching any exception that may occur during execution*/      System.out.println("Caught an error");     };   //end of try catch block 
             }}// end main method
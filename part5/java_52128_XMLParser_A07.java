import javax.xml.parsers.*; // for ParserFactory, SAXParser & Xerces-SAX API  
public class java_52128_XMLParser_A07 {    
    public static void main(String[] args) throws Exception{        
        String xmlFile = "src/resources/test.xml";  /* Change this as per your XML file */      
          
        // Create a new SAXParser using the default settings  
        ParserFactory factory=ParserFactory.newInstance();    
        SAXParser saxParser=factory.newSAXParser(true);         
        
        MyHandler myHandler = new MyHandler();    /* Instantiate your handler */ 
          
        // Parse the XML file  
        try {             
            InputStream inputStream =  ClassLoader.getSystemResourceAsStream (xmlFile) ;     
             saxParser .parse(inputStream,myHandler);     }       catch (Exception e){    System.out.println("XML Parsing failed...\n");   // Error handling..  };         
        /* Close the parser after use */         if (!saxParser instanceof SAXParser) {      throw new ExceptionInInitializerError(); }} ;;
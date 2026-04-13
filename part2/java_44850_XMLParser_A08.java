import javax.xml.parsers.*;  // Import XML parser classes  
// importing required Java packages   
public class java_44850_XMLParser_A08 {    
      public static void main(String[] args) throws ParserConfigurationException, SAXException{      
            String xmlFile = "samplefile_A08IntegrityFailure.xml";  // your XML file path  
            
           DocumentBuilderFactory factory = null;    //factory for the parsers    
               XmlParser parser=null ;      //parser object        
              try {       
                    factory  = (DocumentBuilderFactory) new SAXParserFactory();      
                    
                        if(xmlFile == ""){         
                            System.out.println("Invalid XML file.");   return;  }           
                       DocumentBuilder builder = null ;      //builder for the documents    
                           try {          
                                parser  = factory .newSAXParser()    ;        xmlfile_uri= new Uri(xmlFile)       documentURI=  (XmlDocument )null             source =  ((StreamSource)(  this.getClass(). getResourceAsStream("/sampleXML/")   //source of the documents     Reader reader = null;      try {         
                                builder  = factory .newDocumentBuilder() ;                parser_.setOutputIsXXX(true)        Document doc=  (org.w3c.dom ../2001/XMLSchema Instance    )doc           =   new org        `com\mycompany'sxmlschema_A08IntegrityFailureFactory().createInstance
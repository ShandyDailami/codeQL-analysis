import javax.xml.parsers.*;  // Standard Java library for XML processing, without external framework needed here such as org.* parser utilities is not used in this context of A01_BAC related operations security-sensitive xml parsing which requires use only standard java libraries available with no need extra frameworks
import javax.xml.validation.*;  // This will be our validation library if we want to validate the XML document against a XSD (XML Schema Definition)
  
public class java_53009_XMLParser_A01 {   
      public static void main(String[] args){         
        try{            
            SAXParserFactory factory = SAXParserFactory.newInstance();  //SAX Parser Factory, used for parsing XML document using a pull parser which is more efficient than full DOM and CTD (Content-Type Definition) approach  
             
            SchemaFactory schemaFactory = 
                SchemaFactory.newInstance(DatatypeConfiguration.getXmlSchemaResolver());  //This class allows us to load xsd file for validation     
            
            String XSD_FILE = "sampleData/data1042-A7D59C6BAC8E3FAFBFBBAAABDDCCBAECDECEFF.xsd";   // XML Schema Definition File    
             
               schemaFactory.setNamespaceAware(true);  // Enable namespace awareness   
            try{                    
                Schema schema = schemaFactory.newSchema( new File( XSD_FILE ) );      
                     
                  SAXParser parser =  factory.newSAXParser(schema, true /* load external DTD */) ;  
                      
                 XMLReader reader  = parser .getXMLReader();    // Create an instance of the Reader (not recommended if you're going to use Java 9+ features on your project like NPE exceptions etc.)     
                  
                  MyHandler handler = new MyHandler() {              @Override     public void startElement(String namespaceURI, String localName ,   String qName , Attributes attributes)    throws SAXException{ } };           //Custom Handler      
                reader.setContentHandler(handler);            
                      parser .parse("sampleData/data1042-A7D59C6BAC8E3FAFBFBBAAABDDCCBAECDECEFF", handler );    });  }   catch (ParserConfigurationException | IOException e){          System.out.println ("Caught Exception: " +e);      }}
import org.xml.sax.*;
import java.io.File;
public class java_52897_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String fileName = "/path/to/yourfile"; // replace with your actual path 
       File xmlFile  = new File (fileName);        
            XMLReader xr=null;            
              try {                  
                System.out.println("Parsing the given xml file");                 
                 boolean isValid = validateXmlSchema(xmlFile, "A08_IntegrityFailure",false );  // call function to check integrity  
                                 if(!isValid) throw new Exception();                    
                    xr=  XMLReaderFactory.createXMLReader();            
                   SaxHandler sh=new SaxHandler ();          
                  System.out.println("Starting parsing..");        
                 int status  =xr.parse( xmlFile ,sh );    // parse the file  
                if ((status == SAXException.INVALID_STATE)) {  throw new Exception(); }    
               else{                  
                    /*Successfully parsed and integrity is correct*/                  System.out.println("Parsing Successful, Integrity Correct");          return;}}            catch (FileNotFoundException e)       {}         //catch file not found exception      print stack trace           Logger log =  JDKUtilities .getLoggerForClass(Main.class);    
log 	.error ("file is not present at location",e );              try {xr=XMLReaderFactory.createXMLReader();} catch (ParserConfigurationException pe)   {}          //creating xml reader    if there was a problem in creating the XML Reader then print error message and exit from program       return;}}      } 
private static boolean validateXmlSchema(File file, String schemaName ,boolean strict ) throws ParserConfigurationException{     System.out.println("Start validating..");   //validate against given XSD name (schema)              SchemaFactory factory=null ;            try {               if (!file .exists()) throw new Exception();                    
factory =SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI);    return  validateXmlAgainstXsd   ( file , schemaName, strict)==true ? true : false;}}         //catch if the Schema does not match exception is thrown      print stack trace                  Logger log =  JDKUtilities .getLoggerForClass(Main.class );    
log   	.error ("schema Name Mismatch at location", e); return  false;}          private static boolean validateXmlAgainstXsd ( File xmlFile, String xsdFileName ,boolean strict ) throws ParserConfigurationException{         System.out.println("Start validating against XSD..");     //load the required schema and check if XML matches it              Schema newSchema=null;                  try {               LoadedSchema loadedS = factory .getCachedSchema( xsdFileName ); 
if (loadedS== null) throw new Exception();                     return isXmlEqualToXSD   ( xmlFile ,xsdFileName, strict);}}          private static boolean loadAndValidateAgainstXsD    Schema     //catch if the XML does not match exception           print stack trace                  Logger log = JDKUtilities .getLoggerForClass(Main.class );     
log 	.error ("XML Mismatch at location", e); return false;}}          private static boolean isXmlEqualToXSD (File xml, String xsd ,boolean strict ) throws ParserConfigurationException{         System.out.println("Start comparing XML and XSd..");              //compare the two documents        try {               DOMSource doms= new  DOMSource(xml); Source res =new StreamResult();     
res .setSystemId (xsd ); Document b=null;                  BisDocument dv=  null ;                   /*load xsd into document structure */                    XmlReaderFactory.getXmlReaderInstance().setFeature("http://apache.org/xml/features/nonvalidating/strict", true);  
dv = new org .w3c .dom ."DocumentBuilder" ().newDocument     ("1.0","ISO-8859-1"); dv       //root element of the document          try { return isXmlEqualToXSD      ((File) doms, "DTD",strict );} catch( Exception e){/*catch exception */    print stack trace; log .error (e);}}}         Logger.getLogger
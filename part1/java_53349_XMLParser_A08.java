import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
import sun.security.x509.*;
// import Java's own Security Manager and X509Certificate if needed...
public class java_53349_XMLParser_A08 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        parseXMLFile("sample_file"); // replace with your file name         
        verifyXmlSchema();            
     }  
     
// method for parsing XML File and print the content 
public static Document getDocument(String filename){      
    try {                 
            ParserFactory.newInstance().setNamespaceAware(true);              
           DocumentBuilder db = ParserFactory.newDocumentBuilder();               
         return (Document)db.parse(Main.class.getResourceAsStream("/"+filename));         
        } catch (ParserConfigurationException e1){                   
            System.out.println ("Failed to parse the document!");    //add logging... 
             };  
       if ((new File( filename + ".xsd")).exists() ) {                     
         try{                                                                                    
                SchemaFactory sf =         
                 SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");      //provide schema location             
             Schema sch =  sf.getSchema( new File("sample_file" + ".xsd") );               
               Validator validator =sch.newValidator();                 
            try{                   
                 DocumentBuilderFactory dbFactory =DocumentBuilderFactory .newInstance ();  //create a document builder with the schema context  
             DBschema  =dbFactory.newDocumentBuilder () ;                     
              }catch(SAXException e){                                 
                     System.out.println ("Invalid XML: " +e );                    };                         break;                   case 'C':    continue;}           default : println("Unhandled exception ", ex);  }} catch (IOException | javax.xml.transform.TransformerException exc) {          ... }}}`    
Here, I have not included X509Certificate or other security sensitive operations because they require a full Java environment and are beyond the scope of vanilla java code examples due to their complexity in terms related XML parsing with SSL connections etc..  Please adjust accordingly if required.   Your request is very clear so you can proceed further, but I'll make sure this example adheres as closely into your requirements ASAP!
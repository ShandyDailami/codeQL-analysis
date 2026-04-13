import org.apache.xml.resolver.util.*;
import java.io.File;
import javax.xml.validation.Validator;
import javax.xml.transform.stream.StreamSource;
import static com.sun.org.apache.xpath.internal.operations.Modules.assertNodeNameMatchesPattern;  //used to import the assert statement and method from Apache XML Utilities library for validation purposes, if not using Maven you can use 'java.*' instead of this line
import org.xml.sax.*;
  
public class java_47703_XMLParser_A07 {    
    public static void main(String[] args) throws Exception{        
        String xsdFilePath = "path_to/yourschemafile";  // provide your file path here, e.g: "/home/user/mySchemaTest.xsd"  
       File schemaFile=new File (xsdFilePath);    
            
      System.out.println("Starting XML Validation..."+System.lineSeparator());         
        boolean isValidXML = false;        
          
            try {   
              // Create a SchemaFactory  
                final SchemaFactory factory=  
                  SchemaFactory.newInstance(DatatypeConfiguration.getXmlEventReaderFactory());    
                
               System.out.println("Initializing XML schema instance..."+System.lineSeparator());            
                       
              // Create a new session with the XSD file        
                final Shema sourceSchema = factory   .newSchemas().add( 
                  new StreamSource (schemaFile));    
               System.out.println("Loading Schema..");      
                 Validator validator=sourceSchema.newValidator();    // Create a schema instance for the xml document         
                  
              isValidXML = true;        
             } catch(final SAXException e) {            ----------- Error in loading XML Document      ------  
                  System . out . println (e);      
                  $ errors. add ( new InvalidSchemaException ("Invalid Schema: " +    schemaFile, e));     return ;                    case javax.xml.validation.ValidatorException : //Error while validating the document ---------          }                          else {                                      if (! xerrors)   println("XML is Valid");                                 
              System . out ().println(e);       }}                });}}}}}              `
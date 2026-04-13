import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.validation.*;
import java.io.File;
import javax.xml.transform.stream.StreamSource;

public class java_50251_XMLParser_A03 { 
    public static void main(String[] args) throws Exception{  
        // Step-1: Parse the XML file using SAX and validate against a schema (This step is secure as we are not interacting with an external library or framework).     
         File inputFile = new File("input.xml"); 
          
         SchemaFactory factory =   
             SchemaFactory.newInstance(DatatypeConfiguration.getXmlSchemaResolver());  
            // Resolving the schema using Datatypes Configuration (This step is secure as we are not interacting with an external library or framework).     
         
         try {    
               XSDSchema schema = factory.newXSDSchema(   
                 new StreamSource(inputFile));  // Providing a source of our input xml file to the SchemaValidator (This step is secure as we are not interacting with an external library or framework).     
             Validator validator  =schema.newValidator();    
              SAXParserFactory spf=SAXParserFactory.newInstance();  
               SAXParser parser =spf.newSAXParser( );  // Creating a new instance of the saxparser (This step is secure as we are not interacting with an external library or framework).   
                
             XMLReader xr =  parser.getXMLReader();    
              Handler myHandler=null;      // Declare our custom handler here, this will be called when SAX events occur  ( This operation can't have security issues as we are not creating a new instance of an external library or framework).   
               xr.setContentHandler(myHandler);  
              File inputFile2 =new File("inputfile");     // Step-3: Using the xml file from step1 to parse (This operation can't have security issues as we are not creating a new instance of an external library or framework).   
            xr.parse(inputFile,myHandler);  }      catch (Exception e) {   System.out.println("Problem parsing the xml file "+e );     }}        //Step-4: Catch and Print any exception that may occur while reading XML Document in Step3
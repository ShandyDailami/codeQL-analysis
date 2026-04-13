import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;  // Import FileInput/OutputStatements, DocumentBuilderFactory etc...   (Including standard IO package for InputStream)   
public class java_43376_XMLParser_A01 {
     public static void main(String[] args){       
          try{            
               XMLReader reader = XMLReaderFactory.createXMLReader();          
               
               File inputFile  = new File("path_to/yourfile");  // Provide your path here                   
               DocumentBuilderFactory dbFactory = 
                  DocumentBuilderFactory.newInstance();    
                  
               DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();       
               Reader schemaReader=new InputStreamReader(new FileInputStream("path_to/yourschema"), "UTF-8");          // Provide your path here for XML Schema       (Including standard IO package)    ------------------------------------------------------     reader.setFeature("http://xml.org/sax/features/namespaces", true);        
               schemaReader=new InputStreamReader( new FileInputStream ("path_toyourschema"));          //Provide your path here for XML Schema       (Including standard IO package) ------------------------------------------------------    reader.setFeature("http://xml.org/sax/features/namespaces", true);     
               Document doc = dBuilder.parseURL(inputFile, schemaReader);       
               
              // Now the document has been loaded into a tree structure (with tags and attributes)       ...             }         catch {...    }}  it("should fail to load invalid XML content"){            try{*it should throw IllegalArgumentException*}catch(){if(!$event.isSuccess()){ $failed = $event descr}}}}}
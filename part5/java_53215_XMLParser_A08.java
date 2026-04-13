import java.nio.file.*;   // Paths and Files APIs (Java NIO)    
import javax.xml.parsers.*;// XML parsing API in JDK9+     

public class java_53215_XMLParser_A08 {
    public static void main(String[] args){ 
        try{                   
            secureParse("inputfilepath");   // replace 'A08_IntegrityFailure' with actual file path.            
       }catch (Exception e)          
      {                 System.out.println ("Error parsing XML: " +e);}    
    }        
        private static void secureParse(String xmlFilePathStr){  // using native Java method to parse the string into Document object and extract data as per requirements            
            Path file = FileSystems.getDefault().getPath(xmlFilePathStr);                
                if (Files.exists(file) && Files.isReadable(file)) {                  
                    SAXParserFactory factory=SAXParserFactory.newInstance();     // Create a new instance of the parser  
                          try{                          
                                SAXParser saxParser =factory .newSAXParser((Class[] ) null);  //create an event handler   
                                    XMLReader xmlReader  =saxParser.getXMLReader();     
                                        SystemOutputHandler outputhandler=              
                            new        SecuritySensitiveOperationManager ().initialize(xmlReader,   saxParser );             
                                     XmlParser parser =new Parser((XmlInputSource)     org .w3c .dom    ..createSAXSource       (  ((StreamSource ) file.getFileSystem().getDefaultFileAttributeView      () ).wrapInputStream          ( Files.newInputStream(file)) ,   outputhandler, new SAXHandler()));       
                                        parser.parse((ReadListener) org     .w3c           .dom    ..adaptorFactory);                     }  catch       (Exception e1){                   System out              .println("Error in parsing : "+e );}               }}             finally {}}                if (! Files   .exists(file)){System.out                  .println ("File does not exist: $s", file)}
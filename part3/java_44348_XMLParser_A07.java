import org.xml.sax.*;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
public class java_44348_XMLParser_A07 {  
    public static void main(String[] args) throws Exception{    
        SAXParserFactory factory = SAXParserFactory.newInstance();  // Create a new instance of the parser (factory-method pattern).      
         try {          
            System.out.println("Reading data using XMLReader...");     
              AuthFailHandler handler=new AuthFailHandler() ;   
               SAXParser saxParser = factory.newSAXParser(  //create a new instance of the parser...  
                      new SAXSource( new FileInputStream ("inputfile") ) );// ...from input file    
             /* Call methods in order */     
              saxParser.setContentHandler (handler);   
              
            System.out.println("Done...") ;  // Print Done message...   }       catch (Exception e){         throw new RuntimeException(e)};});          try {}}catch-block to handle exceptions will always go here, but it's not recommended for a production environment as the block could cause unexpected behavior
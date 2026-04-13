import org.apache.tika.exception.*;
import org.apache.tika.parser.*;
import org.apache.tika.metadata.*;
import org.xml.sax.*;

public class java_51833_XMLParser_A08 {  
    public static void main(String[] args) throws Exception, TikaException{ 
        String xmlContent = "<document></document>"; // your XML content here          
        
        SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();         
        try {             
            SAXParser saxParser =saxParserFactory.getSAXParser();            
              
            Metadata metadata = new Metadata();               
                  
            XMLReader xmlReader  =   saxParser .getXMLReader( );      
                 
                       // your parsing logic here     if you want to check integrity of the content, then  add below code.   
              try {     
                 tika.security().checkIntegrityFailure((SAXSource)xmlReader);               }          catch (IOException e1){   /* Handle IOException in case there is an error reading from XML */            System.out.println(e1.getMessage());}           catch  (TikaException    e2 ) {      
                try{     tika.parser().parseXhtml("",xmlReader,metadata);      }catch             (ParseException pe){          /* Handle Parse exceptions in case of non-standard XML */System.out.println(pe .getMessage());}  catch              (CannotReadFileException e4)   {
                    System.out.printf("%s : %s\n",e3 instanceof IOException ?     "A problem occurred while trying to read the file"    // handle exception related io problems here      }catch             All other exceptions       /* Handle all general Exceptions */{System . out  Println( e4);   }}
}
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_47996_XMLParser_A08 extends DefaultHandler {  
    
    public static void main(String[] args) throws Exception{     
        String xml = "<person><name>John Doe</name><age>25</age><city>New York City</city><country>USA</country></person>";  
          
         SAXParserFactory spf=SAXParserFactory.newInstance();   
          XMLEventReader reader =spf .getSAXReader().getObjectContent(xml); 
    
        // Starts parsing the xml document with DefaultHandler methods implementations as defined below:  
           XMLValidator validator =  new XMLValidatorImpl();     
         try{   
             System.out.println("XML is Valid : " +validator .validate(reader));             
          }catch (Exception e){                 
            // Catch Exception if any occurs while parsing the document  and print it out       
               throw new RuntimeException ("Invalid XML",e);  
         }     
    }}`;
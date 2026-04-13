import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.util.logging.Logger;
 
public class java_47929_XMLParser_A01 {  
    public static void main(String[] args) throws Exception{      
        String inputFilePath = "input.txt"; // replace with your file path     
        
        SAXParserFactory factory = SAXParserFactory.newInstance();    
         
        try 
            {            
                SAXParser parser=factory.newSAXParser(null);             
                 
               DefaultHandler handler =  new DefaultHandler()    // create a custom Handler  
                    {                     
                        @Override                         
                            public void startElement (String uri, String localName , 
                                String qName, Attributes attributes) throws SAXException    
                             {                  
                                 System.out.println("Start Element: "+qName);            
                             }                 
                             
                         //...override all other methods as per requirement   
                    };              
                parser .parse(new File (inputFilePath), handler );     
            }  catch (Exception e)     {       System.out.println ("Caught Exception: " +e);}   finally{System.exit(0)} ;        
        // code here...   
    }}`
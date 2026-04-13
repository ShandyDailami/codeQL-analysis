import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
public class java_52471_XMLParser_A07 { 
   public static void main(String[] args) throws Exception{    
       File inputFile = new File("src/main/resources/sampleXMLfile_A07AuthFailure");    //path to your xml file     
        SAXParserFactory factory=SAXParserFactory.newInstance(); 
        
           try {            
               SAXParser saxParser =  factory.newSAXParser();             
                MyHandler handler = new MyHandler();    
                 System.out.println("XML parse start");      
                   saxParser.parse(inputFile,handler);    //parsing the xml file  
                  } catch (Exception e) {       
                    e.printStackTrace();     
                      }  finally{         
                            try {           if(saxParser != null){            
                                              saxParser.close();         }}                 catch (SAXException ex) {}      
                                    System.out.println("XML parse end");   }     });    };}
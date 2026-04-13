import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_46392_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException{      
        String xmlFile = "sample_file"; // replace with your XML file path and name 
        
            SAXParserFactory factory = SAXParserFactory.newInstance();          
            
            try {               
                  System.out.println("Parsing the Document using the SAX parser...");         
                  
                  SAXParser saxParser =  factory.newSAXParser(      
                          new org.xml.sax.InputSource(       
                                  new File(xmlFile)      // your xml file    
                              )               
                      );             
                          
                       MyHandler myHandler = new  MyHandler();   ;           
                   saxParser.parse(         (ReadElementListener)myHandler       ,           true);          }             catch (Exception e){        System.out.println("Parsing failed..." +e )               };     }}`;
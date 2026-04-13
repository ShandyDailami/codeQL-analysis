import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_52732_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String xmlFile = "src/main/resources/sample_data1234567890a"; // path to your XML file. Replace this with the actual location of your data set 
        
       try {  
           ParserFactory.setDefaultLaxOuterParser();            
            SAXParser saxParser = ParserFactory.newSAXParser(true);   
               MyContentHandler contentHandler= new MyContentHandler ( );     
                SaxReader mySaxReader=  new  SaxReader() ;    
                 
                   // Parse the xml file and process it in a DOM way using SAX   parser            
            saxParser.parse(xmlFile,contentHandler);   
               } catch (Exception e) {       
                      System.out.println("Error parsing XML: " +e );     
                  return;  // or handle the error as required by your application      
                   }) ;    
                   
              }}
import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_44741_XMLParser_A07 {  
    public static void main(String[] args) {      
        String xmlFile = "invalidXmlSampleFile";  // replace this with a real file path or URL for testing purpose    
           try{     
                SAXParserFactory spf=SAXParserFactory.newInstance();         
                 SAXParser saxParser=  spf.newSAXParser();           
                   MyHandler myHandler = new MyHandler();            
                  saxParser.parse(xmlFile,myHandler);              }   catch (Exception e){     //Security Exception Handling    if the XML file is invalid or not accessible then display an error message      System.out.println("Invalid/unauthorized access to xml File: "+e);} 
         }}       `
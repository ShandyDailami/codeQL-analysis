import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_44066_XMLParser_A07 {  // change it as per your application name, eg; MainXMLParsingProgramm
    public static void main(String[] args) throws ParserConfigurationException{  
        String url = "your xml file location";      
      try {    
            SAXParserFactory spf =  SAXParserFactory.newInstance();  // create a factory object for the parser, to handle event and content handlers   
         SAXParser saxParser  =spf.newSAXParser();                  //create an instance of XML Parser  
        MyHandler myHandler = new MyHandler();                       //creating our handler class which will be responsible about processing data 
           System.out.println("Parsed successfully");                
       } catch (Exception e) {         
         e.printStackTrace();                        
      }   
     }}   ;;'
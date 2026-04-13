import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_50091_XMLParser_A07 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        String xmlFile = "src/resources/authfailuredata107a.xml"; // replace with your file path 
        
        try {  
            SAXParserFactory spf=SAXParserFactory.newInstance();   
            
            SAXParser sp=spf.newSAXParser( new javax.xml.transform.dom.DOMSource(    
                    new File( xmlFile ) ) );     
              
                       // Parsing the file and providing event handler  to get parsed data  
                MyHandler mh = new MyHandler();   
            sp.parse(new InputSource(new java.io.FileInputStream(xmlFile)),mh);    
        } catch (Exception e) {     
         System.out.println("Parsing failed: " + xmlFile );  
          e.printStackTrace(); 
    }}           `
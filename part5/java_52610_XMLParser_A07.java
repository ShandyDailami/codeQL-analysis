import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
public class java_52610_XMLParser_A07 {  
    public static void main(String[] args)  throws ParserConfigurationException, SAXException{        
        try {            
            File xmlFile = new File("src/main/resources/authfailuredata_A07.xml");      // Your XML file path here      
                  
            SAXParserFactory saxpf = SAXParserFactory.newInstance();                 
            SAXParser sparser = saxpf.newSAXParser();                     
                      
            MyHandler myHandler= new MyHandler();  
            
            sparser.parse(xmlFile,myHandler);           //Parsing the XML file and passing handler to process each node                  
        } catch (IOException e) {             
                System.out.println("Error in reading File: "+e );   
         }}  finally{   /* All attempts at parsing are wrapped inside a try-catch block */}      // This is optional, depends on your use case
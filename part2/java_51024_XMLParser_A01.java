import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
public class java_51024_XMLParser_A01 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{  
        String filePath = "your_filepath"; // replace with your xml path here    
           XMLReader reader=null;        
            try         
             {     
                File inputFile = new File(filePath);             
                  reader =  XMLReader::newInstance("org.xml.sax.SAXReader");  }               catch (Exception e){ System.out.println ("Cannot parse the file [" + filePath+ "]. Make sure it exists and is a well-formed XML.");}        return;      case="
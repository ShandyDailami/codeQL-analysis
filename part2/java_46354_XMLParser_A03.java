import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.*;
public class java_46354_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String fileName = "sample-file.xml";   //replace with your xml filename      
            
            try (Reader reader =  new FileReader(new File(fileName)))  {    
                SAXParserFactory saxParserFactory  = SAXParserFactory.newInstance();          
                    SAXParser saxParser = saxParserFactory .newSAXParser((Boolean) null);     
                     XMLHandler xmlHandler=   new XMLHandler ( );      
                     
             //parse  the file    and process elements using Handler object    
                  saxParser.parse( reader,xmlHandler ) ;        }         catch (FileNotFoundException e){            System . out . println (" File not found " +e);          }}     `
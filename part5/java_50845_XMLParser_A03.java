import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;  // Import the InputStream and FileReader classes  
public class java_50845_XMLParser_A03{    
    public static void main(String[] args){         
        try {               
            SAXParserFactory spf = SAXParserFactory.newInstance();            
              Reader file= new FileReader("test.xml");                     // Use the InputStream or an XMLFile to load data                 
               SAXParser saxParser  =spf.newSAXParser();                
                MyHandler myHandler =  new MyHandler();    
                   saxParser .parse(file,myHandler);            
        }catch (Exception e){                       
            System.out.println("Parsing failed");              // Handle exceptions                    
           e.printStackTrace(); 
       }                 
    }}
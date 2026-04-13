import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_49000_XMLParser_A01 {  
    public static void main(String args[]){ 
        try{      
            SAXParserFactory factory = SAXParserFactory.newInstance();     // Create the sax parser     
            
           /* Creating a new instance of DefaultHandler */        
                Handler hd=new XMLHandlerContent();              
                 while(true) {             
                    try{                           
                        System.out.println("Enter Xml file path");                 
                         String xmlFilePath = "";  // Reading the input from user            
                          BufferedReader br=  new BufferedReader (                          
                                  new InputStreamReader (System.in));                     
                                         FileInputStream fis=new                    
                                               FileInputStream(xmlFilePath);           
                                SAXParser saxp= factory .newSAXParser   ( );             
                         saxp  .parse    (fis, hd) ;                // Parsing the xml file using parsers       }catch           Block          catch             Exception e{e.printStackTrace();}}}            Catch block for I/O related exceptions        public class XMLHandlerContent   extends DefaultHandler {...}
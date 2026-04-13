import java.io.*; // for FileInputStream  
import javax.xml.parsers.*; // to parse XML use SAXParser   
public class java_45660_XMLParser_A08 {    
       public static void main(String[] args) throws ParserConfigurationException, IOException{        
           String inputFilePath = "inputfile";  // path of your xml file            
          FileInputStream fis =  new FileInputStream(new File(inputFilePath));       
            SAXParserFactory saxPF=SAXParserFactory.newInstance();      
              SAXParser saxParser=saxPF.newSAXParser();          
               MyHandler myHandler = new MyHandler();    // create a handler to process the xml node     
             saxParser.parse(fis,myHandler);         
        }    
}  /* end of main */
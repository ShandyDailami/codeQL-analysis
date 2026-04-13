import org.xml.sax.*;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
public class java_50884_XMLParser_A08 {  
    public static void main(String[] args) throws Exception{     
        SAXParserFactory factory = SAXParserFactory.newInstance(); 
        
       // Using StAX for parsing the XML file    
           try (SAXParser saxParser=factory.newSAXParser()) {         
               MyHandler myhandler =  new MyHandler();            
                  String xmlFilePath=  "src/main/resources"+ File.separator +'A08_IntegrityFailureExampleDataSet1234567-AugesthusenetworkCentreTestingEnvironmentMasterBranchDSTPZRWTUOEBVJHMNAKXLFGYUKQNPRI.xml";
                  // Change the xmlFilePath to your own file path  
                   saxParser.parse(new File(xmlFilePath), myhandler);         
            }            
        catch ( ParserConfigurationException pce) {         System.out.println("Failed to create SAX parser: " +pce.getMessage());     return;    }     
       // end of StAX parsing  
  }}//end main method`
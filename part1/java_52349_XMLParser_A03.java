import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_52349_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException { 
        String url = "example_filepath"; // replace with actual xml file path, e.g., "/home/user/myFile" on local machine or your network share location etc...        
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
          
               try {    
                   SAXParser saxp = factory.newSAXParser(true); // Create a new instance of the XML-parsing engine   
                    
                    MyHandler mh= new  MyHandler ( );            # define your handler here, e.g., "myhandler"     
                     
                 saxp.parse("example_filepath",mh) ;          # parse method call and passing xml file & Handler  
             } catch (SAXException ex){                    
                    Logger.getLogger(XMLParserExample .class.getName()).log (Level.SEVERE, null ,ex);  // logging exception on console   
                System.out.println ("Problem parsing the XML file" );     # print an error message in case of Exception             }   catch (Exception ex) {      Logger.getLogger(XMLParserExample .class.getName()).log (Level.SEVERE, null ,ex);  // logging exception on console   
                System.out.println ("Problem parsing the XML file" );     # print an error message in case of Exception             }  
        }}`  ` `
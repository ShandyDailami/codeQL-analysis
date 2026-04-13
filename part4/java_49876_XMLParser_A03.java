import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_49876_XMLParser_A03 {  
    public static void main(String args[]) throws ParserConfigurationException, SAXException{        
        String url = "path_to/yourfile";          
         
       // Load the xml file using DOM parser 
        DocumentBuilderFactory dbFactory = 
            DocumentBuilderFactory.newInstance();  
                  
        // Use this builder to parse XML content from a URL   
        SAXParserFactory spFactory = SAXParserFactory.newInstance();    
        
       try{         
           SAXParser saxp = spFactory.newSAXParser(true);     
            
            MyHandler mh= new MyHandler();  
             
               // Process the content of XML file  and pass to Handler   
                   saxp.parse(url,mh );      
        }catch (Exception e){        
           System.out.println("Problem with parsing ");     
                  return;    
            };  
            
          // After all the events are finished processing print result  in console   
              mh.display();               
               });
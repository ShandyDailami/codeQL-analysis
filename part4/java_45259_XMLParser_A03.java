import javax.xml.parsers.*;
import org.xml.sax.*;
import java.net.URL;
public class java_45259_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        String urlStr = "http://www.w3schools.com/xml/books.xml"; // URL of the xml document from which we are to parse data    
        
       /* Creating a factory object */  
        DocumentBuilderFactory dbFactory = 
           DocumentBuilderFactory.newInstance(); 
   
        /* Creating an instance of DOM parser */           
          SAXParser saxp = dbFactory.newSAXParser();             
      //Creates event handlers to handle the parsed data    
         MyHandler handler= new MyHandler();  
          
       // Parses XML file  and calls appropriate methods in Handler   
        try{           
          URL url =  new URL(urlStr);              
             saxp.parse(url,handler );                 } catch (IOException e) {e.printStackTrace();}     });  
      }}`;                   // End of main method                };                  public class MyHandler implements  ElementListener{ @Override default void startElement    ...//continue the code to handle all SAX events and provide comments for each step here
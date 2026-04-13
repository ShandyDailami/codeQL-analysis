import org.xml.sax.*;
import javax.xml.parsers.*;
import java.net.URL;
import java.io.*;
public class java_42304_XMLParser_A07 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        String urlStr = "http://example/path_to_yourxmlfile"; //replace with your xml file path or URL  
        
          try (InputStream inputStream =  new URL(urlStr).openStream()) {    
            XMLParser parser  = factory.newSAXParser(inputStream);  /*create a SAX Parser*/   
            
              Handler handler = new MyHandler();      //Custom implementation of the default behaviour, can be any class that implements 'DefaultHandler' interface  
              
                  parser.setContentHandler(handler);       /*Set our custom content handling object to Parse with */ 
                	
		          while (parser.parse("", handler));    /**/        //Infinite loop until parsing is complete     **/     
            } catch (IOException e) {        	//Handle IOS exceptions, if any occured      	   	 									  				}                 								               
  }}
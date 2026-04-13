import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_49915_XMLParser_A07 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        String url = "http://example/authfailure"; // replace this with your URL if necessary        
      try {              
            DocumentBuilderFactory dbFactory = 
                DocumentBuilderFactory.newInstance();            
                  
           XMLReader xmlReader=dbFactory.newDocumentReader(url);    
                   
          MyContentHandler myHandler = new MyContentHandler();      
                  //create a Content Handler       
        
                 while (xmlReader.hasNext()) {              
              xmlReader.nextElement();            
            } 
      }}catch(Exception e){e.printStackTrace()}     };   close the connection, release resources and so on..    catch blocks are not required as we're only fetching data from URLs which will automatically handle exceptions          for instance of SAX exception - Parsing failure or network issues etc           
         }  //end main method      DocumentBuilderFactory db Factory is created to parse the xml file at a time. XMLReader object reads and parses through elements one by-one   MyContentHandler Handles tags in document, you can add your logic inside it (for instance handling of A07_AuthFailure)
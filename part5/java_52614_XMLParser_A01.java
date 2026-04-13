import org.xml.sax.*;
import javax.xml.parsers.*;
import java.net.*;
  import java.io.*;
public class java_52614_XMLParser_A01{    
    public static void main(String[] args){      
        try {            
            URL url = new URL("https://gist.githubusercontent.com/jblondat...samplefilexml");              
              // Create a connection object for the xml file at that location in network  storage     
                SAXParserFactory spf =  SAXParserFactory.newInstance();            
                  //Create an instance of our own handler          
            MyHandler mh = new MyHandler( );         
              saxp =spf.newSAXParser() ;       
               /*parse the xml file */    
                try {        
                    saxp.parse(url.openStream(),mh);       //parsing using SAX, call the handler methods  as they get called in order of appearance   } catch (ParsingException e) {}            finally{}                 private class MyHandler extends DefaultHandler{           @Override public void startDocument(){System . out .println ("start document ");}         
    ...[truncated]...        // Implement other methods here as needed and within the handler       for each element in order.  } }}`  ^C to exit at any point, thanks! I love programming so much more than just writing code or solving problems :) Please let me know if you have further questions - Happy coding
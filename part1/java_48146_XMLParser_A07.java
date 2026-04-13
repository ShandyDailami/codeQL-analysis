import javax.xml.parsers.*;
import org.xml.sax.*;
public class java_48146_XMLParser_A07 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String url = "http://example/sample.xml"; // replace with your xml file URL          
        XMLReader xr; 
          try  
            {     
                //create the factory object for reading and processing    
              XmlPullParserFactory myfactory=XmlPullParserFactory.newInstance();   
              
                   /*Create a new SAX Parser with our own input source, through which it reads*/ 
                  xr =myfactory.newSAXParser().getXMLReader();     
                 //xr is the reader we will use to parse XML       Reader's event handlers are passed in     by reference        */   }    catch (PullParserException e1) {         /* Handle exceptions that arise due pull parser setup*/         
                  System.out.println("Error setting up SAX Parser: " +e1);  return;      };       //the block where all the event handlers are implemented, and then finally close it     try{xr.setContentHandler(new ContentHandlerImpl());        xr.parse(url );} catch (IOException e) {          System.out.println("Error reading from URL: " +e); return;} 
              }         //end of main method    }; end here */
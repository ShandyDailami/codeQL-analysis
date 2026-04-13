import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52689_XMLParser_A08 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        String url = "http://example/rss_feed";  // replace with actual rss feed URL    
        
        /* Create an instance of the XML Reader */      
        XMLReader xreader;         
	try {              
            XmlFactory factoryObj=XmlFactory.newInstance();          
	    xreader =factoryObj.createSAXParser();              //Create SAX Parser object    }             catch (Exception e){e.printStackTrace( );}     
        DefaultHandler dh  = new MyDefaultHandler();         /* create a default handler for the parser */      
	xreader .setContentHandler((ContenHandler)dh);  /* set content Handler to our own class*/          xreader.parse("http://example/rss_feed"); //Call parse method with URL    } catch (Exception e){e.printStackTrace( );}   }}    
             "This is a XML Parser using SAX in Java without any external frameworks"  */
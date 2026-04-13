import java.io.*;   // for FileReader and BufferedReader classes
import javax.xml.parsers.*;  // XML parser library from JDK10 onwards, if not present then import org.* packages as well (org.w3c.dom., etc.)   
import org.xml.sax.*;     // SAX API for parsing xml data  

public class java_51105_XMLParser_A03 {     
// define a method to parse XML file using BasicHandler 
static void ParseXMLFile(String filename) throws ParserConfigurationException, IOException{         
        FileInputStream fis = new FileInputStream("SampleInput.xml");    // input source for parsing (should be replaced with your xml data stream in real world scenario).  
        
       XMLReader xr =  null;                 
      try { 
            XmlPullParserFactory factory =XmlPullParserFactory .newInstance();     // create parser using Factory.            
           xr=  factory.newPullParser(fis,null);                // new Parser with our input source and a SAX Listener as the second parameter   (this is where we define what to do when an XML start element or end/content event happens). 
          } catch (XmlPullParserException e) {   	// this can only happen if file not found.     // should be replaced with proper exception handling logic in real world scenarios                    
            System.out.println("Input File Not Found");  	e.printStackTrace();                     
        return; 	        }      	 		     			               try{					             while(xr .next() != XmlPullParser.END_DOCUMENT){				          if (xr instanceof SAXParser) {                                                   ((SAXParser ) xr).setProperty("org.apache.xerces.internal.parseAsDocument", "true");  }    
                  // define a handler for parsing, it will handle XML data as we read and parse the file content					  	System.out.println(xr .getEventType()+" -> " + xr.getLocalName());                        Logger logger = org.apache.log4j.Logger.getLogger("ParsingXML");                      XmlHandler myhandler= new MyXmlHandler();                                               ((SAXParser)  xr).setContentHandler(myhandler);}} catch (Exception e1){   // error handling	e .printStackTrace() }
}     		           	        static class Main { public static void main (String[] args ) throws ParserConfigurationException, IOException{ ParseXMLFile("SampleInput.xml"); }}  return;               	}    @SuppressWarnings(value = "unused") private MyXmlHandler myhandler=new MyXmIHanLer(); }             	static class XmlSaxParser { public static void main (String[] args) throws ParserConfigurationException, IOException{ ParseXMLFile("SampleInput.xml"); }}
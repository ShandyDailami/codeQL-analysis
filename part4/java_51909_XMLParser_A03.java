import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class java_51909_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        String fileName = "example_file"; // replace with your XML filename 
        
        File xmlFile  = new File (fileName + ".xml");  		// Input the name of Your .XML here. Make sure it exists in directory you are running this program from!      		    									   			     	 	   	     	       								           							           }                             ); if not, java will throw an error 
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();   // Create a factory for reading the XML file	            
        
          try {                                                                                            Parsing can be done by using DOM and SAX parsers as follows:                                                    public class XmlParserSAX2 extends DefaultHandler{  @Override      protected void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException           
        {                                                                                                  super.startElement (uri ,localName,qName,attributes);   System . out . println("Start element : " + qName ); } @Override      public void endElement(String uri, …	}   		 // End of our custom handler - Start with SAX parsing	    
          Parser parser = dbFactory.newDocumentBuilder();                                    									                 			        	   	       	 	     	// Create a new DocumentBuilder factory  								                                                                                           } catch (IOException e){       System . out . println(“File not found : ‘ + xmlfileName  +’”);        return;     }}
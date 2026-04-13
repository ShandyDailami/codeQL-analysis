import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_52240_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, IOException{
        // Parse the XML file using JDOM parser (Not recommended for security-sensitive operations because of its open source nature and lack in features used to prevent injection attacks. Instead use SAX or DOM parsers.) 
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();    	  		   	 	   	       			     	     									             Factory.setDefaultLazyLoadingEnabled(false);       //to disable lazy loading for better performance, it is not recommended to set this true while using DOM and SAX parsers 
         DocumentBuilder builder = factory.newDocumentBuilder();    	  		   	 	   	       			     	     									             document = (Element)builder.parse(xmlFile);       //get the root element of XML file                 
        parseNode("");                     }                                                      @Override                          public void startElement(String uri, String localName , 	String qName , Attributes attributes ) throws SAXException    {  		    	 	   	start = true;	}                                    	public boolean getStart(){	return this.start;}                                         	private Element document ;
}
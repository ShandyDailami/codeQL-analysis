import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_47052_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    	        		      
	        String xmlFile = "src/test.xml"; // replace this with your own file name and path         	     			 									     	 	    }          								              };            if (fileName == null){ throw new IllegalArgumentException("XML File not provided."); }}        private static class MyHandler extends DefaultHandler { public void startDocument() {}       @Override public void endDocument(){ System.out.println ("End of document");}        
public void startElement(String uri, String localName, 	String qName , Attributes attributes) throws SAXException{  	    	     		   			     										}       									public	void endElement (String uri, String localName,	  Strinqn name )throws SAXExcception{} public
void characters (char [] ch, int start,int length){} } @SuppressWarnings ("unused") private static class MySAXParser extends DefaultHandler  {...}};   	    // the parser that uses my handler instance as content handlers.    	  		     			         										} public void parse(String fileName) throws ParserConfigurationException, SAXException{       ... }}
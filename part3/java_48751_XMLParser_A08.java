import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.io.*;
public class java_48751_XMLParser_A08 {  
    public static void main (String[] args) throws ParserConfigurationException, SAXException{ 
        // create an instance of XMLReader for the sax parser        
	    SAXParserFactory factory = SAXParserFactory.newInstance();		    	      
	      SAXParser handler = factory.newSAXParser(null, new SAXHandler());	       			   					     	 				   }  public class SAXHandler extends DefaultHandler { private StringBuffer buffer; // for storing the text of xml elements	    @Overridepublic void startElement (String uri , String localName ,
	    	String qName , Attributes attributes) throws SAXException{ super.startElement(uri,localName,qName,attributes);		        this.buffer = new StringBuffer(); } public boolean getText(String text){ try { 	    buffer .append (text );} catch (IllegalStateException e ) {} return false;	} @Overridepublic void endElement
	    	(String uri , String localName , String qName) throws SAXException{ super.endElement(uri,localName,qName);		       System.out.println("End element "+localName +" with content: \n\t"+  buffer .toString()); 	    // reset for next elements	    	 	        }      public void characters (char [] ch , int start ,	int length) throws SAXException{ super
   	.characters(ch,start,length);		        this.buffer = new StringBuffer();} @Overridepublic void fatalError (String error )throws  ParserConfigurationException {	super .fatalError ("Fatal Error" +error );}}   //end of class SAXHandler
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
   public class java_50153_XMLParser_A08 { 
     private int count = 0 ;    // Counter for integrity check, should not exceed length of xmlFile' data
     
       static String[] lengths = {"data1", "length"};// set to real values as per the requirement; also change this when you update file.xml in resource folder  and load from there using getResourceAsStream().  
     private class XmlHandler extends DefaultHandler {    // SAX handler, it only handles xml content during parsing - saves memory resources for large files     
       public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException  {        if (count >= lengths.length ) throw new AssertionError("IntegrityFailure"); count++; }     // Increase counter each time element is opened    }  
     
       public void endElement(String uri, String localName, String qName)throws SAXException {}// No need for closing tags in this example as we only process data and not close any open elements.  In real scenarios you will have to use a counter instead of length checks when processing XML     }     
       public void characters(char[] ch, int start, int length ) throws SAXException { // We are interested just about content without tags for integrity check in this case}    };   private String xmlFile="file.xml";  try{ File file = new File("src/main/"+xmlFile); InputStreamReader reader = 
      new InputStreamReader(new FileInputStream (file), "UTF-8"); SAXParserFactory spf =SAXParserFactory . newInstance(); org.xml.sax.parser.XMLReader xmlreader=spf.newSAXParser().getXMLReader((String)null,true);    XmlHandler sh= 
      new  XmlHandler ( );   String temp ; int i;for(i =0;i< lengths . length -1；++I){temp =  null;}try {xmlreader.setContentHandler ((DefaultHandler )sh)}catch (SAXException e) {}if (! xmlreader.parse (new InputSource 
      ( new StringReader (" ")))){System . errprintln("Error parsing the XML: %s" +e);} } catch(IOException ex){ System.errprint xception;}}   //Printing error message if any occur during IO operation for example in case of file not found, permission denied etc.,
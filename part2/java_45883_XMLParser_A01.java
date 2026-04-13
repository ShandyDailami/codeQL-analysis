import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
public class java_45883_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        // Step-1 : Create a XML file with malicious content to simulate broken access control case 
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();            
		factory.setValidating(true);           
		    
		// Use this builder in order not only validate the document but also create an instance of SAXParser   
        // The "schema" parameter is used to point towards a DTD (Document Type Definition) or XSD schema file that defines what constitutes valid XML documents 
	    DocumentBuilder docBuilder = factory.newDocumentBuilder( new File("maliciouslyFormattedXMLFilePath"));                 	    		        	 	     	       			     									   }          public class MalContentHandler implements ContentHandler { @Override    //SAX parsing happens inside this method             private int lineNumber = 1;
@Override 	public void startDocument(String uri, String localName, String version) throws SAXException{ System.out.println("Start of Document"); }        			@Override public void endDocument()throws SAXException {System.out.println ("End   of     Document ");} @SuppressWarnings({"PMD", "unused_private_method"})@Override    //SAX parsing happens inside this method             private int lineNumber = 1;
public  void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException { System.out.println("Start Element: " +localName+", at Line:"  +lineNumber);}         @Override public   void endElement (String uri ,String localName,    String  qName )throws     SAXException{System . out      . println ("End of" +  localName+  ",at line :"      +lineNumber );this.lineNumber++;}       
@SuppressWarnings("PMD") @Override public void characters(char [] ch, int start,int length)throws     SAXException {System.out.println (new String (ch ,start,length));}         }     		} 		   	 	       	   	      });   }}`
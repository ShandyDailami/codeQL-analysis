import javax.xml.*;
import java.io.*;
public class java_52264_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{         
        XMLReader xr = XMLReaderFactory.createXMLReader();        	  		      			  // Create a new reader instance using factory method          	       	 									     	    }            	     
     String inputFile="inputfile";                 System.out.println("Parsing the file: " +          this::getClass().getName()+ "/resources/" + 
         inputFile);                                   xr.setContentHandler(new ContentHandler(){           public void startDocument (String uri,   string    NAMESPACE_URI,      XMLEncoder     encoder)  {               System.out .println ("Start of document");}};         	      		       
                   }                    				public boolean parse(InputStream inStream){                  return xr.parse("inputfile", true);}          	}                public void endDocument() {}    @Override            	 	void startElement (String uri, String localname, 	String   qName ,     XMLEncoder encoder) throws SAXException {               System .out .println ("Start of " +qName );}};         
public boolean parse(Reader reader){                  return xr.parse("inputfile", true);}            	} @Override public void endElement (String uri, String localname , 	String qName )throws     SAXException {              System       .out      .println ("End of " +qName );}}};
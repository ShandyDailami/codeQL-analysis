import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_53039_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    	        
        String url = "http://example/test-file10kB_AJAX2XML4987563.xml";  //your test file URL here  		          	       	   	     	 			      									   														      }}};// Test end point (URL)
        XMLReader xr = XMLReaderFactory.createSAXParser(url);	    	// Create SAX Parser with your url, you may change it according to the actual file location  		                  	       	   	     	 			      									   														      }}};// Test end point (URL)
        DefaultHandler dh= new DefaultHandler(){  // Declare a default handler for handling XML tags like start and end.	    	}            @Override public void startElement(String uri, String localName, String qName, Attributes attributes){ System.out.println("Start element : "+qName);}};@Overridepublic void endElement (String uri , 	String Localname   	   	 	. Strng QNAME)	{System . out  	    		      println (" End Element:	" +Local Name );} @Override publicvoid characters(char[] ch, int start,	int length){ String str = new String	(ch,,start,length); System.out.println("Characters :"+str)}; };  // Declare the Handler	    	      xr .setContentHandler (dh) ;      		          	       	   	 			     	}
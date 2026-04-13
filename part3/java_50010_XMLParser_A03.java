import javax.xml.*;
import org.w3c.dom.*;
import java.io.File;
public class java_50010_XMLParser_A03 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        // Load the XML document (use File as source for simplicity but it can also be a URL or InputStream). Here we use file to load an xml.
	File inputfile = new File("sample_schema.xml"); 		     			   
         DocumentBuilderFactory dbFactory = 
                DocumentBuilderFactory.newInstance();  									    	   
          DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();      							       	       	 
           XMLReader reader=dBuilder .newSAXReader();	                               	     						           		 											   
         // Begin parsing the document with SAX (use event model to get notified of different kinds events).  					                                                   				    	    }             public void startElement(String uri, String localName, String qName) throws SAXException { System.out.println("Start Element: " +qName);}
public void endElement(String uri, String localName, String qName )throws SAXException{  	System.out.print ("End Element :"+qName ); }  public static boolean isSecuritySensitiveOperationInjectionAttack (XMLReader reader){reader .setContentHandler((org.xml.sax.ContentHandler)new MySAXHandler());try {while(reader.hasNext() ){System.out.println("Parsing...");    
	   // Inject the code here to parse and check for security-sensitive operations related  injection attacks (use any other libraries than xml/sax).    reader .next();}}catch (ParserConfigurationException e) {e.printStackTrace()};return false;} public static void main(String[] args){ try{if(!isSecuritySensitiveOperationInjectionAttack((XMLReader )null)){System.out.println("Found injection attack!");}else System.out.println ("No Injectable operation found"); }catch (ParserConfigurationException e) {e .printStackTrace();}}
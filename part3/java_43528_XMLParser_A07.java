import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_43528_XMLParser_A07 {
    private static final String inputFile = "input.xml"; // provide your xml file path here, replace 'input.xml' with the actual name of your .XML File 
    
    public void parseXmlDocument() throws ParserConfigurationException, SAXException{        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();         
	factory.setValidating(true); // enable validation against DTD / XSD  
		     
	// create a new document builder with the default parameters 	   
	DocumentBuilder db = factory.newDocumentBuilder();      			    	 	       					   				       															        						                                                    ​               
             XMLReader reader;          	     
              // Parse xml file and read it using SAX (Simple API for XML)         		      Reader is used to process the Document in a sequential manner 	   	   - load data into memory, but if we only need certain operations like A07_AuthFailure then its good.        				   
              reader = db.newSAXReader();       	 	       					    			      	// setup your SAX handler for parsing     		                                                                            // parse the XML file 	   	  															            						                    ​                } public class SecurityHandler extends DefaultHandler { @Overridepublic void startElement(String uri, String localName,   
             	String qName) throws SAXException{ System.out.println("Start Element : " +qName);}      // Print element name on Console 	   	  									    	 		       public void endElement (String uri ,             String Localname ,           /* int line */          )                 throws               
              XMLReader { } @Overridepublic void characters(char[] ch,    int start,int length)throws SAXException{ System.out.println("Reading Text : " + new     String(ch,start,length));}}  //prints text read from xml in console       									                 		
} public static class Main {  		public static void main (String[] args){ try             XMLParser parser =new           XMLPar          enr();            /*parser.parseXmlDocument()*/    } catch(Exception e)         System .out      .println ("Error parsing the xml file : " +     inputFile); 
        // replace 'inputfile' with your actual path of a valid       xmL File   }}
import java.security.*;
   import javax.xml.parsers.*;
   	org.w3c.dom.*;
     org.xml.sax.*;
     
public class java_52876_XMLParser_A03 {
	private static final String URL = "file:inputFile"; // path to your file, should not be publicly accessible or exposed through web 
	  private DocumentBuilderFactory dbFactory;  
   	 public List<Element> disabledFeatures= new ArrayList<>();// list of features that are disallowed due security reasons. For example 'creating' elements in the document tree etc..      		    
     	   			       									            	        // (For A03_Injection) 	 	      }  	          private DocumentBuilder docBuilder;   	private static Logger logger=Logger.getLogger(XMLParserExample.class);            public void parseFile() {         try{                 dbFactory = DocumentBuilderFactory.newInstance();              
docBuilder =  dbFactory.newDocumentBuilder();             XMLReader xmlReader= 			    	   docBuilder .newTreeReader(URL, "UTF-8");                  XMLEventReader eventReader=xmlReader.getContent();                   Node node; String elementName = null; Integer lineNumber = 0; 
while (eventReader.hasNext()){                     		   	  LineNumberHandler handler=  new            	    	   				   ContentHandlerAdapter(this);                logger .info("Parsing..." + eventReader.getCurrentEvent().getLineNumber());     			         while((node =            evtreader 
	.nextNode()) != null) {                 		          elementName =  node.getLocalName();                     if (isFeatureDisabled(elementName))                   continue;                 switch (eventReader .getEventType()){                    case    XMLEvent.ELEMENT_NODE:                lineNumber = eventreader 
	.getCurrentEvent().getLineNumber () ; break;} }                  logger     	    	   		      =  "Parsed File successfully." + URL+" at Line Number :-" + 			       	 	        handler .lineNumber;          }}catch (Exception e){logger.error("Error parsing the XML file...",e);} 
    private boolean isFeatureDisabled(String elementName) { // check if a feature should be disabled due to security reasons for A03_Injection      	    		        return         enabledFeatures .contains          (elementname ); } }}// end of code.
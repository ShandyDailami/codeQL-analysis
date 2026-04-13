import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_47531_XMLParser_A03 implements XMLStreamReader {  //implements not required, but makes the code cleaner and easier to understand if we use it later on in our custom stream reader implementation  
    private String currentElement = "";    
      
    public void startDocument() throws XMLStreamException {}     
         
    @Override        
    public void endDocument() {  }            //void methods are empty, not needed here but kept for completeness          
             
        /* these tags can be any tag you want to parse */  
    	      
	@Override            
	public void startElement(String uri, String localName, String qName) throws XMLStreamException {         
	    currentElement = qName;  //setting the element name for printing it later           
	}       
             
    @Override                  
    public void endElement(String uri, String localName, String qName)throws XMLStreamException {}        	      
            
	@Override              				     			  		         	     	       	 	   					    
	public void characters(char[] ch, int start, int length) throws XMLStreamException {  //ignoring the character data and we only print element names }            .       						   	}}}}}}                    }}             	                                                   {{}{{{{{.`.
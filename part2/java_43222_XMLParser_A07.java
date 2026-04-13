import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_43222_XMLParser_A07 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{       
          // Create a new instance of the DefaultHandler 
            XMLReader reader = XMLReaderFactory.createXMLReader();  
            
           String xpathExpression="your_xPath";//Enter your XPATH expression here for security check   
    	reader.setContentHandler(new ContentHandler(){             
                   public void startDocument() throws SAXException {                }         
                  @Override  //Inside element or attribute processing, you can use xpath to validate the content            		  			      									        });     
               reader.parse("your_xmlfile");        	    	       	   	     	}   	});                  	  };                        	};                       );                     }}                      ];                    }}};                                           {{{{{                  .                AA:BBCCDDEEFF0123456789ABCDEFGH
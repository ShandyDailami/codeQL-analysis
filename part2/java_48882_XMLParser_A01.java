import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_48882_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String url = "https://example/sample_file"; // replace this with your actual URL or local file path 
       /* If you want to parse a remote xml document then use the following line */  
      // DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();   
		// SAXParser parser =  factory.newSAXParser() ;    
        XMLReader reader = XMLReaderFactory.createXMLReader(); 
        
       /* The below block will parse an xml document using DOM */  
      // DocumentBuilder builder  = DocumentBuilderFactory . new instance ();   
		// setDocumentHandler(reader,builder );            
          		    
        Parser p = null ;                    
          try{                           
            String charset="UTF-8";         /* This is to handle any encoding issue */      	   	 	       	     									  }                                                          if (p instanceof WarningHandler) {              throw new SAXException("Warning handler found; element was: " + currentElement);  		}                      		       
          public void error(SAXParseException e){    System.out.println ("Error in line :"+e .getLineNumber());  }                   if (p instanceof ErrorHandler) { throw new SAXException("Parsing Complete with Errors");    			     										}                     		  
          public void fatalError(SAXParseException e){ System.out.println ("Fatal error in line :"+e .getLineNumber());  }                   if (p instanceof Closeable) { ((Closeable) p).close();}   		if (!((XMLReader )p ).getUseScore())    		   throw new SAXParseException("endDocument before startElement: " + e.getSystemId(), null);									
          public void warning(SAXWarningRecorder a){ System .outprintln (" Warning :"+a .getMessage()); }                         			     		}                                                                                                              p = reader;             if (p instanceof Locator) { throw new SAXParseException("Uri in use by previous locators");  		    									 
          public void startDocument(){System. out.println ("Start of Document ");}                                 	 	       	     	    }                      			   	startElement(String uri, String localname ,String qName ){ System .out println (q name + " Started" );      	}       		               endElement  
          public void characters –> {System. outprintln ("Inside character Data: `“+chars -`) ;    			     									    }            	endDocument(){ system ..print(" End of Document ");}}                    if (p instanceof ContentHandler ){ throw new SAXParseException( "Content handler not yet set") };       
         –> {if (! ((XMLReader)( p)).getUseScore()){throw  		    			     									    } else          system .outprintln (" endDocument before startElement: `“+e.getMessage());}}}}} }}                if (p instanceof Locator) { throw new SAXParseException("Uri in use by previous locators");      		}
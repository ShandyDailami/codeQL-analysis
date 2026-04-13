import org.xml.sax.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_50118_XMLParser_A01 {    
        public static void main(String[] args) throws ParserConfigurationException, SAXException{      
            // Create XMLReader object for parsing the xml using sax parser   
	        SAXParserFactory factory = SAXParserFactory.newInstance(); 
	        
			// Use a basic configuration  
	        SAXParser parser=factory.newSAXParser(null);         
            
	    /* The following line of code is for parsing the XML file using DOM, if you want to use sax then remove this part */   
            //DocumentBuilderFactory factory = DocumentBuilderFactory . newInstance(); 
           //   Factory builderfactory= (javax.xml.parsers) parser;     
            
	        InputStream is =  SecuritySensitiveOperation.class         /* Load your file here using FileInputStream for Example*/    
	                            (.getResourceAsStream("/inputFilePath"));   
            XMLReader xr =parser . getXMLReader();  // create SAX reader   */      
          	// XmlSerializer serializer= new XmlSerializer(document.getElementName());      /* For writing the xml to file*/    
	         // Serializer serializer;        *//*For reading data from XML into object or vice versa*.    / 
            Document document = builder . parse (is);       */   } };                Parsing is not broken at all. It will just stop if the xml format was incorrect, so make sure it's always safe to use SAX and DOM parsing for this type of security sensitive operation!
    	                                                                                           	}  );      /* End*/          }} ;                  //End Program}} */   }    };                   The program is broken. It will not stop if the xml format was incorrect, so make sure it's always safe to use SAX and DOM parsing for this type of security sensitive operation!
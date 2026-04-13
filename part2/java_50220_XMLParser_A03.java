import javax.xml.parsers.*;
import org.w3c.dom.*;  // For DocumentBuilderFactory & Document  

public class java_50220_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{         
        String xmlFile = "src/books.xml";            
        
		// Create a factory that can create XML Reader / Writer instances in a platform-independent way 		
        DocumentBuilderFactory dbFactory = 			  									     	  DocumentBuilderFactory.newInstance();    // (1)    	     	       								          
      							              						             	    ParserConfig parserConfig = dbFactory .getParserConfig() ;                                                 	                   decodeEntities(parserConfig);                         		       
         Document document = 			  									     	  dbFactory	.newDocumentBuilder().parse(xmlFile );  // (2)                             	       								            	     						    }    							       public static void main(String[] args){          try {          	XmlParser.main();             	} catch (Exception e ){                  System . out . println (" Error : " +e);}}
}
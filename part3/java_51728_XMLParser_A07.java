import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
public class java_51728_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{    
        String xmlFile = "/path/to/yourfile";  // use your own XML file path here     
        
		// Step A: Parse the document (SAX parser is used to parse an input source without loading it all into memory).  
		 try {   
            SAXParserFactory spf = SAXParserFactory.newInstance();    
             SAXParser saxParser=spf.newSAXParser();      
              // Step B: Create a new handler and feed the parsed document to this handler which will actually parse it  
               MyHandler myHandler =  new  MyHandler( );   
                   saxParser .parse("http://" + xmlFile,myHandler);      }     catch (SAXException e) {       System.out.println ("Error in parsing the XML file "+xmlFile+  "\nLine Number :"  +e.getLineNumber());        // Step C: Handle exception appropriately  
        	} 		   	           	   										// End of program			     }      catch (IOException e) { System . out . println ("Error in opening the XML file " + xmlFile);}       try{MyHandler myhandler=new MyHander();saxParser.parse(xmlfile,myhandleraw"); 
        	}catch (SAXException se){System..println("A07_AuthFailure: Access Denied.");   // Step D : Security sensitive operation related to A07_AuthFailure is handled here }             finally {            System . out. println ("Closing the parser ");    saxParser . endDocument();}}
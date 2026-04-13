import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52687_XMLParser_A08 {    
    public static void parseXML(String filename)  throws ParserConfigurationException , SAXException{       
            // Create a new instance of the DefaultHandler  
	        MyContentHandler myhandler = new MyContentHandler();     
	        
	        // Initialize an XML reader and set our handler for content.   
          XmlReader xmlr=null;      
           if(filename== null || filename == "") {        throw  new ParserConfigurationException("File name not found");}    		  									                			            	        	     																}else{	        try {      XMLParser parser =new    SAXParser();                xmlr=parser.getXmlReader((Filename),myhandler); } catch (SAXException e)        {}
       }}catch(FileNotFoundException fnf){throw new ParserConfigurationException("file not found "+fnf );}    		  	        			            	   	 	     								}finally {    if  null != xmlr )xmlr.close(); }}}}}}          // Use a DefaultHandler to print out the content of each tag in your XML document
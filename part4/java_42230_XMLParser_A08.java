import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;  // Import FileInputStream, InputStreamReader etc... for handling files  
public class java_42230_XMLParser_A08 {     
    public static void main(String[] args) throws ParserConfigurationException, SAXException{      
        String xmlFile = "/Users/username/filepath"; # replace with your file path        
	SAXParserFactory spf = SAXParserFactory.newInstance();  // create a new instance of the factory  
	try {                  
	    SAXParser saxParser=spf.newSAXParser();          //create an instantiation using default parameters   		    									     			      	      } catch (ParserConfigurationException e1) {}              	  try{        	        XMLReader xr = spf . newSAXparser() ;	  
        XmlPullDriver dv;                  SaxEventHandler sh  ) ;             sxmlexp=new SAXSource(dv); } catch (IOException ex){}                   // create a handler to handle exceptions and errors     try{                     saxParser.parse("filename", new DefaultHandler());  
        System.out.println("\n Parsing the XML file using DOM parser");              Reader reader=null;           FileInputStream fis =newFileInPutStream(xmlfile);  //reading xml document into buffer    }catch (Exception e){}     }} catch block for handling exceptions and errors      };
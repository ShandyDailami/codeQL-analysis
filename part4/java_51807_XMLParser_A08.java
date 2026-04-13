import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_51807_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{         
        String xmlFile = "sample_file"; //replace with your XML file path        
     	SAXParserFactory spf =  SAXParserFactory.newInstance();      
    	  SAXParser saxp  = spf.newSAXParser();   		  
	      MyHandler mh= new  MyHandler ();         	       
        saxp .parse(xmlFile,mh );            	        			     	   										} }
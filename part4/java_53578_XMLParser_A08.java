import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_53578_XMLParser_A08 {    
	class MyHandler extends DefaultHandler{		        	       	 			         	     	   				       }      public void parse(String filename){  String myFileName = "src/main/resources/" +filename+".xml"; SAXParserFactory spf=   SAXParserFactory.newInstance(); try {   
	SAXParser saxParser =  spf.newSAXParser(); SaxReaderHandler wrapper=  new     MyHandler (); 
	saxParser .parse( myFileName ,wrapper ); } catch (Exception e){e.printStackTrace() ;} }}       //End of Main Method  	       	 	     	           };      run:java SimpleXMLSAXParser filename toXmlFile;}}" replace "filename" with the name and location xml file, for example 'src/main/resources' or '/Users/yourUserName', etc.
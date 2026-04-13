import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.*;

public class java_49846_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException  {      
        String xmlFile = "/path_to/yourfile"; // specify your file path here        
	SAXParserFactory spf= SAXParserFactory.newInstance();    
	SAXParser saxParser=  spf.newSAXParser();     
           DefaultHandler dh  = new MyHandler ();  
	saxParser .parse( xmlFile,dh );  // parse XML file       
    }      
}        
class MyHandler extends DefaultHandler{         
public void startDocument(){ System.out.println ("Start of Document");}             
      public void endDocument() {System.out.println("End Of Document")}          	  		    
	public java_49846_XMLParser_A01(String uri, String localName ,   	String qName , Attributes attributes)                  	   			       					      	 				        						         								}            //end of start element      public void endElement ( string uriproviderstringlocalnameqnameattribute list ) {  
public java_49846_XMLParser_A01( char ch [], int start,int length) { System.out .println ("Characters: " + new String (ch ,start,length));}                  //end of character         public void ignorableWhitespace(String str) {System out println("ignoring whitespaces") }  
public java_49846_XMLParser_A01(Warning w ) {system errprint ln ('WARNING '+ Warning.getStateChangeProperty().getName());          	    		     	public ErrorHandler getErrorHandler() {}       public void fatalError ( FatalError fe) { system out println ("fatal error"); }   
}  //end of Myhandler class       			  									             						            	 	       	}
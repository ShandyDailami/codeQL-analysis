import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;
public class java_43012_XMLParser_A08 {
    public static void main(String[] args) throws Exception{
        XMLReader reader = XMLReader.newInstance();  // Creating a new SAX Reader instance
        
        MyHandler handler= new MyHandler(){  
            boolean bName=false;     // Flag to check if we are at Name element   
            String nameValue="";      // Value of current node         
            
            public void startElement(String uri,  String localname , String qname) throws SAXException {       
                super.startElement(uri,localname,qname);    	// Calling parent's implementation      	  		   	if("Name".equalsIgnoreCase(localname)) bName=true;     			           	else{              					             if (bName){                    nameValue = localname;}                        }       
                 public void endElement(String uri,  String localname , String qname) throws SAXException {         	  		   	if("Name".equalsIgnoreCase(localname)){                bName=false;           	        System.out.println ("End of "+qname);}}            	}     
             	public void characters (char[] ch, int start, 	int length )throws SAXException{      	  if (!bName) {          	     // This will print all content inside the element         		    String contents= new String(ch ,start ,length).trim();       	    System.out.println("Content in "+qname +" is : \"" + 
             	contents  +  '\"');     	        }}       public void endDocument() throws SAXException{         // Calling the parent's implementation   	  }};            reader .setContentHandler(handler);       		          reader.parse("SampleXmlFilePath");}  	}}};`
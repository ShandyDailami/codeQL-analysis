import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_43075_XMLParser_A07 {  
    public static void main (String[] args) {    
        String url = "file:///path_to__yourXmlFile"; // Replace with your xml file path 
         try{     
            SAXParserFactory spf=SAXParserFactory.newInstance();          
             SAXParser saxParser=spf.getSAXParser();   
              MyHandler myhandler = new MyHandler();    
               saxParser.parse(url,myhandler);      
         }catch (Exception e){   // Catch and handle exceptions as needed 
            System.out.println("Error in parsing XML : "+e );     
        }}   
           class MyHandler implements SAXHandler{    
               boolean bUser=false;             Boolean bPassword = false ;      
                public void startElement(String uri, String localName, 
                	String qName, Attributes attributes)throws SAXException {        
                      if (qName.equalsIgnoreCase("user"))      // Checking for user element    	  
                          bUser=true;            	    }          		       			    public void endElement(String uri, String localName, 	String qName) throws SAXException{           	if(bUser){                         if (qName.equalsIgnoreCase("password"))              // Checking for password element    	  
                                                   bPassword=true;                        }                      else {if(!localName .equals ("user") )          		    System.out.println("\n Unknown tag : " + localName);}}           	}         public void characters(char [] ch, int start,int length)throws SAXException{        if (bUser && bPassword){             String str= new String(ch ,start,length );       // Store password value in variable    	  
                                              System.out.println(" User : " +str);}}}}}  This is a simple example and will only work for specific xml structure that contains 'username' & 'password'. Real world usage would require much more robust error checking or exception handling, as well an actual use of SAXParser to parse XML from file not URL (which could be insecure if someone can read your source code/database).
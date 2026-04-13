import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.FileInputStream;
import java.io.IOException;

public class java_46358_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException  {
        String fileName = "sampleXMLfile"; //Replace with the path of your XML File here!  
        
        try{
            FileInputStream fis  = new FileInputStream(fileName);          
            
            SAXParserFactory spf   = SAXParserFactory.newInstance();   
                        
            SAXParser saxParser =spf.newSAXParser();                     
             
            MyHandler myHandler=   new MyHandler();                   // Your Handler 
         
                        sAXSource =  (ReadElementContentHandler)myHandler;    
            
           xmlReader  =saxParser .getXMLReader();                    	        		   	     	   	       	 				     			              						      					        }                                                    catch(FileNotFoundException e){   System.out.println("Invalid File!");  return;}          finally {if (fis != null) try{ fis.close() ;}catch(IOException ex){System . out . println (" Error Closing file");}}
            
        }   	    catch(ParserConfigurationException e )    	  	{ System	.out		       .println 	( " Parser configuration failed :" +e );      return;	}                   	       	 	     					           switch (args[0]){case "-order": case	"-help":"Usage:\n -file <xml file>","default: parse xml content",				System.exit(1);}
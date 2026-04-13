import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_50768_XMLParser_A07 {  
    public static void main(String args[] ) throws Exception{      
        String inputFile = "sample_input2.txt";     // Your XML file here              
         try {            
            SAXParserFactory factory =  SAXParserFactory.newInstance();             
	    SAXParser saxParser=   factory.newSAXParser(true); 		   	         	 	     			      									     	       								        }           catch (Exception e)                    	{ System . out . println ("Failure occurred " +e );}         finally {saxParseClear();}}
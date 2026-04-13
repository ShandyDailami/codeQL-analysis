import sun.security.x509.*;
// Importing classes for XML parsing and Security handler functions:  
import java.util.Iterator;     // To iterate over the elements in xml document (optional, used if you are not sure)   
... imports here ... 

public class java_43127_XMLParser_A07 {     
        public static void main(String[] args){         
                try{             
                        String urlStr = "yourXMLFileURL";   // Replace this with your XML file URL.        
                        
			URL url=new URL(urlStr);                  
			     XmlPullParserFactory xppf = 
                      XmlPullParserFactory.newInstance();  // Create a factory object to parse the xml document   
                          XmlPullParser parser =  
                        xppf.newPullParser();                /*Create an instance of pull-parser using above factor*/    
                         String currentElement="";       // To store element name while parsing XML Document */ 
                     int lineNumber = 0;                  // Line number in the xml document that we are currently at  
                          parser.setInput(urlStr, EncodingDetector.detect( url ), false);     /* Set input stream and encoding*/   
                         boolean isInElement =false ;       // Flag to indicate whether or not currentTag being parsed  was initiated by an opening tag <element>   .     
                          while (parser.next() != XmlPullParser.END_DOCUMENT){     /* Start looping through XML document */   	           	   	       									          if(lineNumber++ %10 == 9) System.out.println("Skipping line " + new Integer(lineNumber).toString());
                          else { 		                // If not a start of element, then it must be data or end-tag  			                	 		if (parser.getEventType() == XmlPullParser.START_TAG) isInElement=true;      /* Start handling tags */      
                                                                          if(isInElement){    		            // If we're in an element, print the tag name             System.out.print("<" + parser.getLocalName()+ ">");   }        			  else {                                           //Else it must be end of data (data or comment), so don’t output anything                    
                                                                          if(parser.getEventType() == XmlPullParser.END_TAG){     /*End tag detected */               currentElement = parser.getName();   System.out.print("</" +currentElement+ ">"); isInElement=false;} else { //If it's data (non-tag), print the text             if(parser.getEventType() == XmlPullParser.TEXT){     /* Inside element found */System.out.println ("Text: '"  + parser.getText () + "' " );} }}}   
                          catch (Exception e) {            // If there is any error at parsing the xml document, print it   System.err . writeLn("Error in line ", new Integer(lineNumber).toString() ,e);  }}       try-catch blocks are used to handle exceptions and provide meaningful feedback about what went wrong (optional), while this won't be necessary if we just check a few lines of the XML document at each iteration.
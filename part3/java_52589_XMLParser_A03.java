import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52589_XMLParser_A03 extends DefaultHandler {    
    boolean bName = false;   // flag to check name element 
    String strName = "";        // variable for storing the value of tag "name" in xml documents     
      
    @Override public void startElement(String uri, String localName, String qName , Attributes attributes) throws SAXException {    
          if (qName.equalsIgnoreCase("NAME")){   bName = true;  }         // checking for "name" tag in xml document     
        }      
    @Override public void endElement(String uri, String localName, String qName )throws SAXException {             
           if (qName.equalsIgnoreCase("NAME")){     strName=strName;  bName = false;}         // storing the value of "name" tag     
        }      
    @Override public void characters(char[] ch, int start, int length)throws SAXException {           
           if (bName){   /* If we have found 'NAME' in XML document then store character data into strName */    	
             String temp = new String(ch,start,length);     			// convert the string from char to string 	    }   			       end method.               
        }}                  					          				         // Main function            Start of main code                     Ends here         `java
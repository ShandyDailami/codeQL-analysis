import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52375_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String url = "http://www.w3schools.com/xml/books.xml"; // XML file URL to parse     
          
        try 
            {            
                XmlPullParserFactory factoryObject = 
                    XmlPullParserFactory.newInstance();                
              
              SAXParser saxParser = factoryObject.newSAXParser();         
                                  
                  MyHandler myHandler= new MyHandler() ;   // Handler for parsing   
            	                                                                                  	 				     			 		      					    								       	   						        	       ​               ​​                 }            public class XmlPullParser {              @Override}public void startElement(String uri, String localName , String qName) throws SAXException{System.out .println ("Start Element : " +qName );  
                                                                                                                         				      	}    // Start of an element is called when any tag starts with <            		  }else if (localName != null){ System. out . println("Ending Tag: "+ local Name);} public void endElement(String uri, String localName , String qName) throws SAXException{System.out().println (" End Element :" +qname );}}
end;public class MyHandler extends DefaultHandler {// Handler for parsing   @Override    // This method is called when any text between start tag and end tags  }@ Override this to process the characters data     public void characters(char [] ch, int start ,int length) throws SAXException{String xmlData = new String (ch,start,length);System.out .println ("Character Data :" +xmldata );}}
end;
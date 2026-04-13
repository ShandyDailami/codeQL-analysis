import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_48073_XMLParser_A07 { 
    public static void main(String[] args) throws Exception{  
        // load xml document using SAX parser and provide it to the XMLReader object for parsing     
         try (SAXParserFactory factory = SAXParserFactory.newInstance();
              SAXParser saxParser = factory.newSAXParser()) { 
            InputSource is  = new InputSource(new StringReader("<data><id>1234567890</id><name>John Doe</name><email>john@example.com<role>admin<pass encrypted=\"true\"/> <password field-encrypted /> 
            <notes invalid_field ='bad'/  badval >1234567890 <invalid unclosed tag>`));   // your XML data here   
            MyHandler myHandler =  new  MyHandler();    
               saxParser.parse(is,myHandler);      
         } catch (Exception e) {         
             System.out.println("Parsing the xml document failed.");          
              return;      //Exit in case of error       
            }}  
    class MyHandler implements SAXHandler{     public void startDocument( )throws SAXException  {}      
         @Override                  
			public void endDocument() throws SAXException { System.out.println("Ending Document"); }            
		@Override           //handle element and attributes           
        public void startElement (String uri, String localName ,  
                                     String qName , Attributes attributes) 
                throws SAXException{System.out.print( "Start Element :" +qName);}    
               @Override            
		public void endElement(String uri, String localName,    //end element here     
                             String qName )throws SAXException { System. out .println("Ending of   the  Start tag: Qname= "+ qName)};         
        }     public boolean isAuthFailure(){ return false;}       @Override          
		public void characters(char[] ch, int start,int length) throws SAXException{    //print character data here         char xmlChar = Arrays.copyOfRange (ch ,start ,  ) ;            System . out . println ("\n Character Data: " +xmlChar);}}
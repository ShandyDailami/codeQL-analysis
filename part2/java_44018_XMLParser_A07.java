import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_44018_XMLParser_A07 extends DefaultHandler {  
    boolean bUsername = false,bPassword=false , bRoot=false ; 
     String userName,password;      //variables to store username and password read from xml file      
        @Override public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {  
           if (qName.equalsIgnoreCase("username")) bUsername = true ; 
            else if (qName.equalsIgnoreCase ("password") )bPassword=true;     // check for 'user' and then it is end element   
             }     
         @Override public void characters(char[] ch, int start, int length) throws SAXException {  
           if ( bUsername){  userName = new String(ch ,start ,length);bUsername=false;}     //if yes then store it in 'user' variable.     
             else if( bPassword ){ password  =new String( ch, start, length ); bPassword= false ;}  	//store the string read into variables   		} 		
        @Override public void endElement (String uri , String localName, String qName) throws SAXException {      //check for 'user' and then it is end element.     if yes store in user variable }         else if(bRoot){}	//if no match found add the string read into variables	}	
        @Override public void startDocument()  throws SAXException{   System.out.println ("Start of Document");    bRoot=true;}}      //start document is called when any element starts here }      									     endElement method call at last,so that it will print the username and password	
public class A07_AuthFailureXMLParser {  public static void main(String[] args) throws ParserException{   MyXMLReader myxmlreader = new MyXMLReader();      SAXParserFactory spf  =SAXParserFactory.newInstance() ;     SAXParser saxparser=spf .getSAXParser ()   	;         
            InputSource is =null 			//use to read your xml file  									        	    //your location of the XML File here			       	  System.out.println ("End parsing") }}}      A07_AuthFailureXMLReader().parse(is,myxmlreader);     }}
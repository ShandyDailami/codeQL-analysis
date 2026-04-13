import org.xml.sax.*;
import java.io.File;
import javax.xml.parsers.*;
public class java_44104_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        // Step1: Parse XML file with a custom parser using the standard library only without any external frameworks (Spring or Hibernate).
         File inputFile = new File("input.xml");  
            SAXParserFactory factory=SAXParserFactory.newInstance();      
             SAXParser saxParser=  factory.newSAXParser(null);     // creating the parser using Factory   
        MyHandler myhandler =  new  MyHandler ( );     
         saxParser .parse( inputFile,myhandler ) ;   }// Step2: Handle security-sensitive operations related to A03_Injection. Security is done by sanitizing user inputs before passing them into our methods for parsing or processing. This can be a simple method like below 
         public void setMyHandler( MyHandler myhandler ) { this .myhandler =   myhandler ;}      //Sanitize the incoming parameter and prevent potential injection attacks       private    MyHandler     myhandler;        @Override protected String[] sanitiseInput (String input) throws IllegalArgumentException{ 
         if ((input == null)) throw new IllegalArgumentException ("parameter cannot be null");          return(new   String[]{"This","is", "a ", "test"} );} //Step3: Output the secure, safe data to console. This is a simple output method like below . It uses java's standard I/O system for this purpose
         public void writeToConsole (String str) { System.out.println(str); } 
          private class MyHandler extends DefaultHandler{   // Step4: Create an inner handler to handle XML tags and content in the way you want them parsed ie ignore or replace some of it etc . Here we'll just print out all text read from file under each open tag. You can adjust this according your requirements
         @Override public void startElement (String uri, String localName ,  String qName , Attributes attributes) throws SAXException { writeToConsole ("Starting Element: " +qName ); }   // Step5 : Error handling and exception throwing is also done by implementing a handler. You can throw specific exceptions or handle them in another way you want to
         @Override public void endElement (String uri, String localname ,  String qname ) throws SAXException { writeToConsole ("Ending Element: " +qName ); }     // Step6 : This is the start of a recursion method for handling nested elements. You can call this as many times you want to handle multiple levels
         @Override public void characters (char [] ch, int start ,int length ) throws SAXException {  writeToConsole ("Reading: " + new String(ch,start,length)); }     // Step7 : This method is called when a text node in the XML file gets read. It will print it to console
    }}
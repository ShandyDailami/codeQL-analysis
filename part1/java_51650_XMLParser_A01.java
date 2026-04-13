import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
public class java_51650_XMLParser_A01{  
    public static void main(String[] args){    
        String xmlFile = "sample_file"; // replace with your actual file path        
        SAXParserFactory factory=SAXParserFactory.newInstance();            
        try{           
           SAXParser saxParser=factory.newSAXParser(true);         
                  
           MyHandler myHandler= new MyHandler();             
           saxParser.parse(xmlFile,myHandler );   }  catch (Exception e) {      // Catch and print the exception   
            System.out.println("Parsing XML file Failed");       return;     };               
        }}          public class MyHandler extends DefaultHandler{              @Override             public void startDocument( ) throws SAXException         {System. out .print ("Start of document \n\n "); }           // Start Document    System.out .println ( "Inside startdocument method" );}               Override methods for the elements           
@Override          public void endElement …        ...                   @overide             Public VoidstartCourse(String element,Attributes a) throws SAXException{      if ((element).equals ("course")) { System.out .println ( "Inside start course method" ); }} }}};   Exception e){         // Catch and print the exception   
            return ;}             public void endDocument()….. @Override           Public VoidendCourse(String element,Attributes a) throws SAXException {       if ((element).equals ("course")){ System.out .println ( "Inside End Course Method" ); }}}; }}          // Start Document
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
public class java_53126_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String xmlFile = "<document>Your XML content here...</document>"; // This will be replaced by a file path or the actual data you want to parse. 
            
       DocumentBuilderFactory factory =  
            DocumentBuilderFactory.newInstance();          
      try {   
          SAXParser saxp = factory.newSAXParser();    
         InputSource is= new StringReader(xmlFile);       
              
                   // Create a new handler and feed it the document tree with our IS  
             MyHandler mh =  new  MyHandler ( );     
              saxp .parse(is,mh) ;       }    catch (Exception e){         System.out.println("Parsing failed");     return;        }           };          // main method end            public static class   Main {             DocumentBuilderFactory factory = null;}                private void startElement 
     214(String uri, String localName , String qName) throws SAXException{ print ("Start Element : "+qName);}              protected void endElement (String uri,    stringlocal Name，string Qname )throws   S A X Exceptions {print("End ELement: “ +Q name ); }           
     private void characters(char [] ch , int start ,int length) throws SAXException{ print (" Inside Characters : "+new String (ch,start,length));}             };          // main class end         public static  10_BrokenAccessControl {  .... etc... for the rest of your request
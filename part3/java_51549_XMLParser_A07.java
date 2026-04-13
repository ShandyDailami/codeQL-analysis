import javax.xml.parsers.*;  // Importing standard Java XML Parser classes only (not external frameworks)  
import org.w3c.dom.*;     // Standard W3C DOM library for handling xml document - not an extra dependency, since we're using the parser to extract data from specific tags in our program   
import java.io.File;      // Importing standard Java File related classes  (not external frameworks)  
public class java_51549_XMLParser_A07 {    
       public static void main(String[] args){            
              try{                      
                     XMLParser xp = new SAXParser();               
                     xp.parse("src/main/resources/sampleXMLFile1.xml",new MyHandler()); // replace 'your_file' with your xml file path  and use the same class as handler (MyHandler in this case).                     
              }catch(Exception e){                         
                     System.out.println("\n Error parsing XML: "+e);              
              }   
       }     
}    
class MyHandler extends DefaultHandler {   // Implementing a custom default xml handler for security-sensitive operations (handling authentication failure).  It's the class that will parse our file and perform necessary actions.                     
           StringBuffer sf = new StringBuffer();    /* Use buffer to collect data from specific tags */                  
     private boolean usernameFound=false,passwordFound=false; // flags for detecting presence of required attributes         
       @Override                             public void startElement(String uri ,  String localName ,   String qName , Attributes attr) {             sf.append(" " +qName);                     if (qName .equalsIgnoreCase ("username")){ usernameFound=true;}              else if (qName .equalsIgnoreCase ("password")){ passwordFound = true ; }                     
     @Override                             public void endElement(String uri,  String localName ,   String qName) {             //end of the tag                        if (sf.toString().trim().length() > 0){ System.out.println("Username: " + sf);} else{System.out.print ("No username found in xml\n"); }                      
           @Override public void characters(char [] ch ,   int start,  int length) {             if (usernameFound || passwordFound )     //if any tag with required attributes is present then process the data collected until now                    sf .append(new String(ch ,start ,length));              usernameFound = false;passwordFound=false ;                 
       }                      
}
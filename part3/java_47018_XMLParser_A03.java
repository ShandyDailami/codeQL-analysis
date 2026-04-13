import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;  // Import Input/Output Exceptions  
public class java_47018_XMLParser_A03 {   
     public static void main(String[] args) throws ParserConfigurationException, IOException{      
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();       
	         DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();     
               // parse the document  (xml file is here):  
             XmlReader reader =  dBuilder.newXmlReader( );   
		     for (;;) {         
                 int type;          
                  String currentElement;           
                   while ((type = reader.getEventType()) != Node.ELEMENT_NODE) ;  // read an element (not a text node):      
                    switch (type){                    
                         case Node.ELEMENT_NODE:     
                              currentElement =  reader.getName();              break;           default : return;}    Case END_DOCUMENT:}   for (;;) {          type =reader .getEventType() ;        // read an element node with the next name (not a text):         switch(type)  {} }}}
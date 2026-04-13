import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_46443_XMLParser_A08 {  //define your own name for this parser, e.g., 'XmlSecureProcessor' or something like that)  
    DocumentBuilderFactory dbFactory = null ;     //factory object to create document builder objects          
    DocumentBuilder dBuilder  = null;          //builder used to read the xml file                      
     
        public java_46443_XMLParser_A08() {  }                 //constructor of your parser class                    
             
         private void validateElement(Element e) throws Exception{   /*function for integrity check*/    
            if (!e.hasChildNodes()) return;              
                 
             Iterator i = e.getChildNodes().iterator();         
                             while (i.hasNext()){                     
                                  Node n=i.nextNode();                 // getting child node               
                                                               /*checking for integrity failure*/  if (!(n instanceof Element)) throw new Exception("IntegrityFailure: The file contains invalid nodes other than text or element.") ;        }                          return;                         };                     public void parseXmlFile (String fileName) {   try{ dBuilder = dbFactory.newDocumentBuilder();   
     Document doc=dBuilder .parseURL(fileName);                   // parsing the xml document               /*starting point of your program*/      validateElement((Element)doc.getElementsByTagName("company").item(0));  }catch (Exception e){e.printStackTrace();}   };
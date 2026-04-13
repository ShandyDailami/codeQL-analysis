import org.xml.sax.*;
import javax.xml.parsers.*;
impoat java.io.*;   // For FileInputStream and InputStreamReader   
public class java_51801_XMLParser_A08 {     
 public static void main(String[] args) throws ParserConfigurationException, SAXException{         
  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();           
  SourceReader reader=null;        
     try  
       {              
        FileInputStream fis  = new FileInputStream("xml1");                  // Load the xml document with an InputStream               
           XMLReader xreader =  dbFactory .newSAXXMLReader(fis);             // Create a SAX Reader    for reading  large documents                
         reader=xreader;   /* Readers are event handlers that process the content of your doc */                 
       }               catch (FileNotFoundException e1) {                    e.printStackTrace();                System .out.println(" File not found " +e2);                      return;}             });          };      void StartElement(String uri, String localName , String qName ){           // The start of an element                  
       switch (qname){                     case"Person":  println ("New Person Record Detected ");break;};              public static final int   ELEMENT_NODE=1;}    ];                      }});      void EndElement(String uri, String localName , String qName ){             // The end of an element          };
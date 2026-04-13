import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;   // Import File and IO Exceptions   
public class java_52929_XMLParser_A01 {    
 public static void main(String[] args) throws ParserConfigurationException, IOException{      
 parse("sample_XML2");      } 
 private static DocumentBuilderFactory dbFactory;           
 protected DocumentBuilder docBuilder;          
   // Parse the XML document and print the nodes in a recursive manner.     public void    startElement(String uri, String localName, String qName) throws SAXException{          System.out.println("Start Element : " +qName);  }       protected void endElement (String uri , String localName ,  
 string qName )throws SAXException {System. out . println ("End Element: "+ qName );}      public    void characters(char [] ch, int start,int length) throws SAXException{          System.out .     println("Characters :" + new String (ch ,start,length));  }      
   // parse the XML file and read it in a recursive manner         static DocumentBuilderFactory getDocumentBuilderFactory() {        dbFactory =    DocumentBuilderFactory.newInstance();           docBuilder   =dbFactory .createDocumentBuilder( );      return     dbfactory;            } public void startElement (String uri, String localName , int lineNo) throws SAXException 
   // Prints the parsed elements using security-sensitive access control measures       static XmlParser parseXMLFile(String fileName){          Document doc = null ;      try {         dbFactory =  getDocumentBuilderFactory();           System.out .println ("Received XML data from File: " +fileName); 
        //Create a new document instance             doc  =dbFactory .parse(new     Source("sample_XML2") );                 XmlSerializer serializer = javax   .xml    .stream     
       // SerializationConfig.getNamespaceAwareInstance();         DOMSource domsource =  null;                  try {            System.out.println ("Parsing the document and extract data");  } catch (SAXException e)             {e     ..printStackTrace() ;}           return doc;}  
    public static void main(String args[]){        XmlParser xmlparser = new      XmlParser();         DocumentBuilderFactory factory =  getDocumentBuilderFactory();          try{            System.out .println ("Building model objects");  }catch (SAXException e)             {e     ..printStackTrace() ;}           parseXMLFile("sample_xml2")  
    endElement(uri, localName,"test-element" );      }}
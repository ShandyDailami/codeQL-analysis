import javax.xml.parsers.*;  // Importing the parser classes  
import org.w3c.dom.*;     // Domain Model for XML documents, these are used to retrieve document information   
import java.io.*;         // For reading file in Java     
public class java_42914_XMLParser_A08 {      
// Main method which is entry point of any Java program 
static void startElement(String uri, String localName, String qName)  
        throws ParserConfigurationException{     System.outprintln("Start element: " +qName); }    //starting an XML tag in the document that's being parsed and called when it encounters a node 
static void endElement(String uri, String localName, String qName)      {System.outprint ("End Element :"+qName );}   // Called whenever you encounter End element (</bookname> ) in your xml file   
 static boolean characters = false;     private DocumentBuilderFactory factory;  public void parseXMLOne() throws ParserConfigurationException, IOException {         try{factory=DocumentBuilderFactory.newInstance();}catch(Exception e){System.outprintln("Caught Exception: "+e);}}   //main function where parsing begins here   
 static Document getParsedDocument(){return parsedDoc;}     public java_42914_XMLParser_A08() throws ParserConfigurationException, IOException {this ("books-data"); }  private void parseXMLOne(String file)throws ParserConfigurationException ,IOException{parsedDoc= factory.newDocumentBuilder().parse( new File(file));}   //main function where parsing begins here
public static void main ( String args[] ) throws Exception {BookstoreParser parser = null;try{parser  = new BookstoreParser();  }catch(Throwable t){System . outprintln("Exception Occured: "+t);};}}    try
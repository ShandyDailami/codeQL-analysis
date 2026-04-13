import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;   // Import the File class java_45314_XMLParser_A01 javax.xml.parsers.SAXParserFactory;   // SAX Parser Factory (To parse XML file) 
import javax.xml.parsers.*;    // To get parsing API functionality of xml in JDK10 onwards    
public class MyXMLReader {        /* Start defining a new Java program with the following features */     
static File inputFile = null;  // Declaring variables for file reading and writing 
private static DefaultHandler handler=null ;    // Create an object to handle elements. (Handles tags)      
SAXParserFactory factory= SAXParserFactory.newInstance();     /* Define a new parser */     
public MyXMLReader(String inputFilePath){   /// Creating constructor for XML file path  '''''''.//        @param xmlInput - File to parse    //*/         this("inputfile"); }       public void read() { try{            InputStream in =new FileInputStream (this.getClass().getResourceAsStream( inputFilePath)) ;          SAXParser parser= factory . newSAXParser();   /*  Create a XML Reader */
handler=  new DefaultHandler(){      @Override        // Overriding the method of parent class 'Defaults Handler' to handle Start,End and also inside elements.    public void startElement (String uri , String localName     ,      ` `'' '' xmlname . char[] ch) throws SAXException {...}//Do something on element starting ...  }
public static void main(String args [])throws Exception{   //Main method to create object and read from the file.      MyXMLReader myreader = newMy XML reader (" inputFilePath here");    /*myreader .read();*/     }}catch (Exception e){e..printStackTrace()}}
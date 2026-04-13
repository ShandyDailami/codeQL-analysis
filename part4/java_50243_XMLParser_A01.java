import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import org.xml.sax.XMLReader;
public class java_50243_XMLParser_A01 {  // This is the main program that initiates our XML parsing process with SAX and a custom handler, using JDK's standard library only for this task: File -> new filehandler (default constructor), DefaultHandler->new default(all child elements are unchecked)
    public static void parseXMLUsingSAX() {  // This is the main function that initiates our XML parsing process with SAX and a custom handler, using JDK's standard library only for this task: File -> new filehandler (default constructor), DefaultHandler->  all child elements are unchecked
        try{   /* Parsing begins here */  // begin of the main function that initiates our XML parsing process with SAX and a custom handler, using JDK's standard library only for this task: File -> new filehandler (default constructor), DefaultHandler->  all child elements are unchecked
            String xmlFile = "sample.xml";   // Specify your own path of the .XML document you want to parse here and change it according to needs  **/       /* end point for XML */          File inputFile = new File(xmlFile);           SAXParserFactory spfactory = SAXParserFactory.newInstance();
            SAXParser sparser =spfactory.newSAXParser(/* begin of the constructor with parameters: InputSource -> file source, default is set to a buffered reader */  );   // create new instance and give it input as your .XML document path (your xml must be in resources folder)
            XMLReader xreader = sparser.getXMLReader();    /* begin of the constructor with parameters: InputSource -> file source, default is set to a buffered reader */  }catch(IOException e){e.printStackTrace();}   catch(SAXException e2 ) {e2 . printStackTrace ();}}
     void startElement(String uri , String localName , String qName , Attributes attributes) throws SAXException    /* begin of the constructor with parameters: Input -> string for namespace URI, input-string name and attribute list */   {}  // This is where we do our processing when a new element starts
     public static void main(String[] args){ parseXMLUsingSAX();}      }/* end point here*/         /* call the function that initiates xml parsing using SAX with custom handler. No use of external libraries or frameworks */   // The XML file you want to read must be in resources folder, and it's named as "sample"
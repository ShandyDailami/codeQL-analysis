import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;   // Import of File Input Stream and Reader Class (Read files) 
public class java_51708_XMLParser_A03 {    /* Public access modifier */    
         public static void main(String[] args){      }       
          private SAXHandler shandler = new SAXHandler();      
           @SuppressWarnings("resource")   // Supress warning for closing input stream. This is a best practice to avoid resource leaks   
            public java_51708_XMLParser_A03() {     try {  /*Try block */        System.out.println("\n Parsing the XML file using SAX \t");       String xmlfile = "sample.xml";   // The location and name of your xml file          SAXParserFactory factory = SAXParserFactory.newInstance();   
           SAXParser parser=factory.newSAXParser( new InputSource(  /* Construct a input source from an XML file */            
                          new FileInputStream("sample2345678901_Injection")));   //File to read the xml data         
            } catch (Exception e) {e.printStackTrace();}       System.out.println("\n End of parsing");    }}  /* Main method */     private class SAXHandler extends DefaultHandler{ @Override public void startElement(String uri, String localName ,   // Override the default behavior for a new element
                     String qName, Attributes attributes) throws SAXException { if (qName.equals(":wfcr")) throw new SAXException ("Injection attempt!"); }}    /*SAXHandler class */     }  End of SecureXMLParse Class'''   }); This code will not work as expected due to security and injection concerns, but it should serve the purpose you described with your specific needs.
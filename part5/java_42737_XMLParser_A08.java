import java.io.*;   // Import File I/O classes    for reading and writing files in Java program

                     // For XML parser class, use javax.* packages to work with standard SAX or DOM parsers only (not the legacy way).  In this case we are using a simple sax based parse mode.

import org.xml.sax.*;   // Import for SaxParser Interface and classes related operations    in Java program     .SaXmlParser is not used because it's deprecated now, use javax.* packages only with standard SAX or DOM parsing methods (not the legacy way).  In this case we are using a simple sax based parse mode.

import org.xml.sax.helpers.*;   // Import for classes related to handling and processing documents in Java program     .SaXmlParser is not used because it's deprecated now, use javax.* packages only with standard SAX or DOM parsing methods (not the legacy way).  In this case we are using a simple sax based parse mode.

public class java_42737_XMLParser_A08 {   // public access modifier means that you can instantiate it outside of its own file     .SaXmlParser is not used because it's deprecated now, use javax.* packages only with standard SAX or DOM parsing methods (not the legacy way).  In this case we are using a simple sax based parse mode.

   public static void main(String[] args) throws ParserConfigurationException {    // Main method in Java program     .SaXmlParser is not used because it's deprecated now, use javax.* packages only with standard SAX or DOM parsing methods (not the legacy way).  In this case we are using a simple sax based parse mode.

      String xmlFile = "sample-file";    // Declare and initialize your XML file here     .SaXmlParser is not used because it's deprecated now, use javax.* packages only with standard SAX or DOM parsing methods (not the legacy way).  In this case we are using a simple sax based parse mode.

      File inputFile = new File(xmlFile); // Create your file object to point at XML data     .SaXmlParser is not used because it's deprecated now, use javax.* packages only with standard SAX or DOM parsing methods (not the legacy way).  In this case we are using a simple sax based parse mode.

      try {    // Declare and initialize your file object here     .SaXmlParser is not used because it's deprecated now, use javax.* packages only with standard SAX or DOM parsing methods (not the legacy way).  In this case we are using a simple sax based parse mode.

         XMLReader parser = null;   // Declare your variable here     .SaXmlParser is not used because it's deprecated now, use javax.* packages only with standard SAX or DOM parsing methods (not the legacy way).  In this case we are using a simple sax based parse mode.

         parser = SAXParserFactory.newInstance().newSAXParser();   // Create your file object here     .SaXmlParser is not used because it's deprecated now, use javax.* packages only with standard SAX or DOM parsing methods (not the legacy way).  In this case we are using a simple sax based parse mode.

         parser.parse(inputFile, new MyHandler());   // Call your method here     .SaXmlParser is not used because it's deprecated now, use javax.* packages only with standard SAX or DOM parsing methods (not the legacy way).  In this case we are using a simple sax based parse mode.

      } catch(FileNotFoundException e) {   // Declare and initialize your file object here     .SaXmlParser is not used because it's deprecated now, use javax.* packages only with standard SAX or DOM parsing methods (not the legacy way).  In this case we are using a simple sax based parse mode.

         e.printStackTrace();   // Declare and initialize your file object here     .SaXmlParser is not used because it's deprecated now, use javax.* packages only with standard SAX or DOM parsing methods (not the legacy way).  In this case we are using a simple sax based parse mode.

      } catch(IOException e) {   // Declare and initialize your file object here     .SaXmlParser is not used because it's deprecated now, use javax.* packages only with standard SAX or DOM parsing methods (not the legacy way).  In this case we are using a simple sax based parse mode.

         e.printStackTrace();   // Declare and initialize your file object here     .SaXmlParser is not used because it's deprecated now, use javax.* packages only with standard SAX or DOM parsing methods (not the legacy way).  In this case we are using a simple sax based parse mode.

      }   // Declare and initialize your file object here     .SaXmlParser is not used because it's deprecated now, use javax.* packages only with standard SAX or DOM parsing methods (not the legacy way).  In this case we are using a simple sax based parse mode.

}   // Declare and initialize your file object here     .SaXmlParser is not used because it's deprecated now, use javax.* packages only with standard SAX or DOM parsing methods (not the legacy way).  In this case we are using a simple sax based parse mode.
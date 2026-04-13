import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;

public class java_24792_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create XMLReader object
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Create SAXParser object
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            saxParser.setProperty("class", "com.sun.org.apache.xerces.internal.parsers.SAXParser");

            // Define XML content handler
            ContentHandler contentHandler = new ContentHandler() {

                public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    System.out.println("Start element: " + qName);
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End element: " + qName);
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    System.out.println("Characters: " + new String(ch, start, length));
                }
            };

            // Parse the XML data
            saxParser.parse(new InputSource(new File("input.xml")), contentHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
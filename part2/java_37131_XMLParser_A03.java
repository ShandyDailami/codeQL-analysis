import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class java_37131_XMLParser_A03 {

    public static void main(String[] args) {

        try {
            // Create a new instance of XMLReader
            XMLReader reader = XMLReader.newInstance();

            // Create a new instance of the XML document
            Document document = new Document();

            // Parse the XML document
            reader.setContentHandler(new ContentHandler() {
                public void startDocument() throws SAXException {
                    // Empty method, because we don't need this in this example
                }

                public void endDocument() throws SAXException {
                    // Empty method, because we don'
                }

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Start Element: " + qName);
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End Element: " + qName);
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    // Print characters in the element
                    System.out.println("Element content: " + new String(ch, start, length));
                }
            });

            // Parse the XML document
            try {
                reader.parse(new File("input.xml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
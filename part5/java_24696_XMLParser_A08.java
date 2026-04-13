import java.io.StringReader;
import java.io.FileReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_24696_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Read XML from String
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new XMLErrorHandler());
            reader.parse(new StringReader("<root>Hello World!</root>"));

            // Read XML from File
            reader.parse(new FileReader("path_to_your_file.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Implement SAX (Simple API for XML) for error handling
    static class XMLErrorHandler implements javax.xml.parsers.SAXHandler {
        public void startElement(String uri, String localName, String qName,
                javax.xml.parsers.Attributes attributes) throws SAXException {
            System.out.println("Start Element: " + localName);
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("End Element: " + localName);
        }

        public void characters(String chars, int start, int length) throws SAXException {
            System.out.println("Characters: " + chars);
        }

        public void ignorableWhitespace(char[] chars, int start, int length) throws SAXException {
            System.out.println("Ignorable Whitespace: " + new String(chars, start, length));
        }

        public void warning(SAXException e) {
            System.out.println("Warning: " + e.getMessage());
        }

        public void error(SAXException e) {
            System.out.println("Error: " + e.getMessage());
        }

        public void fatalError(SAXException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }
    }
}
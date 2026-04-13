import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_37537_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        XMLReader reader;

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setValidation(true);
            reader.setEntityResolver(new MyEntityResolver());

            XMLParserHandler handler = new XMLParserHandler();
            reader.setContentHandler(handler);

            reader.parse(xmlFile);

            System.out.println("Parsing completed successfully!");

        } catch (SAXException e) {
            System.out.println("Parsing failed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        }
    }
}

class XMLParserHandler implements org.xml.sax.helpers.DefaultHandler {
    public void startDocument() {
        System.out.println("Start of document");
    }

    public void endDocument() {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
        System.out.println("Start of element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of element: " + qName);
    }

    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    public void error(SAXException e) {
        System.out.println("Error: " + e.getMessage());
    }

    public void fatalError(SAXException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    public void warning(SAXException e) {
        System.out.println("Warning: " + e.getMessage());
    }
}

class MyEntityResolver implements org.xml.sax.helpers.EntityResolver {
    public org.xml.sax.Entity getElementById(String id) {
        return null;
    }
}
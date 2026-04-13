import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_10917_XMLParser_A01 extends DefaultHandler {
    private String indent = "";
    private boolean parsingElement = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        parsingElement = true;
        System.out.print(indent + qName + " ");
        printAttributes(attributes);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        parsingElement = false;
        System.out.println();
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (parsingElement) {
            System.out.print(new String(ch, start, length));
        }
    }

    private void printAttributes(Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.print(" " + attributes.getQName(i) + "=" + attributes.getValue(i));
        }
    }
}

public class XMLParser {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new File("sample.xml"));
        } catch (SAXParseException e) {
            System.out.println("Parsing error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
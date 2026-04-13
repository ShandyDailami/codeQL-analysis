import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_29302_XMLParser_A03 extends DefaultHandler {

    private String lastElement;
    private String lastNamespace;
    private String lastValue;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
        lastNamespace = uri;
        lastValue = "";
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals("element")) {
            // Handle element here
            System.out.println("Element: " + lastElement);
            System.out.println("Namespace: " + lastNamespace);
            System.out.println("Value: " + lastValue);
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        lastValue = new String(ch, start, length);
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File("sample.xml"), new UniqueVanillaXMLParser());
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_01200_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        parseXml(xmlFile);
    }

    private static void parseXml(File xmlFile) {
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
            reader.setFeature("http://xml.org/sax/features/validation", true);
            reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            reader.setFeature("http://xml.org/sax/features/external-dtd", false);
            reader.setFeature("http://xml.org/sax/features/save-parsed-data", false);
            reader.setFeature("http://xml.org/sax/features/unicode", true);
            reader.setFeature("http://xml.org/sax/features/rng-supported", true);
            reader.setFeature("http://xml.org/sax/features/xinclude", false);
            reader.setFeature("http://xml.org/sax/features/xlink", false);
            reader.setFeature("http://xml.org/sax/features/dom", true);

            XmlHandler handler = new XmlHandler();
            reader.setContentHandler(handler);

            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class XmlHandler implements org.xml.sax.helpers.DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String name, org.xml.sax.Attributes attributes) throws SAXException {
        System.out.print("Start element : " + localName);
        printAttributes(attributes);
    }

    @Override
    public void endElement(String uri, String localName, String name) throws SAXException {
        System.out.print("End element : " + localName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.print("Characters: " + new String(ch, start, length));
    }

    private void printAttributes(org.xml.sax.Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.print("Attribute: " + attributes.getQName(i) + "=" + attributes.getValue(i));
        }
    }
}
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_11966_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "example.xml";
        parseFile(xmlFile);
    }

    private static void parseFile(String xmlFile) {
        EntityResolver resolver = new CustomEntityResolver();
        DefaultHandler handler = new XMLHandler();

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader(resolver, handler);
            reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            reader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            reader.parse(new File(xmlFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler extends DefaultHandler {
    @Override
    public void startDocument() {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String strChars = new String(ch, start, length);
        strChars = strChars.replace("\n", "");
        System.out.println("Text: " + strChars);
    }
}

class CustomEntityResolver implements EntityResolver {
    @Override
    public InputSource resolveEntity(String url) throws SAXException {
        return null;
    }
}
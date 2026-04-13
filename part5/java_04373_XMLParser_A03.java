import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_04373_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            XMLReader reader = XMLReaderFactory.createXMLReader();

            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);

            saxParser.setEntityResolver(new MyEntityResolver());
            reader.setEntityResolver(new MyEntityResolver());

            File inputFile = new File("input.xml");
            reader.parse(inputFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements javax.xml.parsers.SAXHandler {

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes)
            throws SAXException {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}

class MyEntityResolver implements javax.xml.parsers.EntityResolver {

    @Override
    public Object getProperty(String namespaceURI, String localName, String value) {
        System.out.println("Entity: " + namespaceURI + " " + localName + " " + value);
        return null;
    }

    @Override
    public Object getURI(String namespaceURI, String value) {
        System.out.println("URI: " + namespaceURI + " " + value);
        return null;
    }
}
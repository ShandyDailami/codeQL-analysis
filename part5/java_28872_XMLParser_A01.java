import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_28872_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("path/to/your/xml/file");

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);
            MyContentHandler myContentHandler = new MyContentHandler();

            XMLReader xmlReader = XMLReaderFactory.createXMLReader(myContentHandler);
            xmlReader.setFeature("http://xml.org/sax/features/namespaces", true);
            xmlReader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
            xmlReader.setFeature("http://xml.org/sax/features/external-general-entity-references", false);
            xmlReader.setFeature("http://xml.org/sax/features/external-parameter-entity-references", false);
            xmlReader.setFeature("http://xml.org/sax/features/element-content-whitespace", false);
            xmlReader.setFeature("http://xml.org/sax/features/nonvalidating/enables", false);

            xmlReader.parse(xmlFile);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler extends DefaultHandler {
    boolean bElement = false;
    String strElement = "";
    String strAttribute = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        bElement = true;
        strElement = qName;

        for (int i = 0; i < attributes.getLength(); i++) {
            strAttribute += attributes.getQName(i) + "=" + attributes.getValue(i) + " ";
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bElement = false;
        strElement = "";
        strAttribute = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElement) {
            strElement += new String(ch, start, length);
        }
    }

    public void fatalError(SAXParseException e) throws SAXException {
        // ignore fatal errors
    }

    public void warning(SAXParseException e) throws SAXException {
        // ignore warnings
    }
}
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_19162_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        SAXHandler handler = new SAXHandler();

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.setErrorHandler(handler);
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private boolean isElement = false;

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        isElement = true;
        System.out.println(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        isElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (isElement) {
            System.out.println(new String(ch, start, length));
        }
    }
}
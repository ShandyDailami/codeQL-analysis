import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_26238_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            SAXReaderHandler handler = new SAXReaderHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new File("sample.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXReaderHandler implements org.xml.sax.helpers.DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        System.out.println("Start element: " + localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + localName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length).trim();
        if (content.isEmpty()) {
            return;
        }
        System.out.println("Content: " + content);
    }
}
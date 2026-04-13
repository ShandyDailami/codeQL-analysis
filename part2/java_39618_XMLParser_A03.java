import java.io.File;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;

public class java_39618_XMLParser_A03 extends DefaultHandler {

    private String lastElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        lastElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        lastElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement != null) {
            String data = new String(ch, start, length).trim();
            if (!data.isEmpty()) {
                System.out.println(lastElement + " : " + data);
                lastElement = null;
            }
        }
    }

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        XMLParser parser = XMLLoader.getDefaultInstance().getParser();
        MyXMLParser handler = new MyXMLParser();

        try {
            parser.setContentHandler(handler);
            parser.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
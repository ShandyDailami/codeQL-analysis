import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParserFactory;
import org.xml.sax.parser.XMLParser;

public class java_31021_XMLParser_A01 extends DefaultHandler {
    private String lastElement;

    public static void main(String[] args) {
        try {
            String fileName = "example.xml";
            InputStream inputStream = new FileInputStream(fileName);

            XMLParser parser = SAXParserFactory.newInstance().newSAXParser(null);
            MyXMLParser handler = new MyXMLParser();
            parser.setContentHandler(handler);

            System.out.println("Parsing XML document");
            parser.parse(inputStream, handler);

            System.out.println("Parsing Complete");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        lastElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement != null) {
            String content = new String(ch, start, length);
            System.out.println("Content inside element: " + content.trim());
        }
    }
}
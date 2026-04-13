import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class java_01463_XMLParser_A03 {
    public static void main(String[] args) throws Exception {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);

        MyHandler handler = new MyHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(new InputSource(new StringReader(doc.getDocumentElement().getTextContent())));
        parser.setContentHandler(handler);
        parser.parse(new InputSource(new StringReader(doc.getDocumentElement().getTextContent())));
    }
}

class MyHandler extends DefaultHandler {
    private boolean name = false;
    private boolean age = false;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            name = true;
            age = true;
        }
        if (qName.equalsIgnoreCase("name")) {
            name = true;
        }
        if (qName.equalsIgnoreCase("age")) {
            age = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            name = false;
        }
        if (qName.equalsIgnoreCase("age")) {
            age = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (name) {
            System.out.println("Name: " + new String(ch, start, length));
        }
        if (age) {
            System.out.println("Age: " + new String(ch, start, length));
        }
    }
}
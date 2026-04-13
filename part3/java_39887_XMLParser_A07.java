import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXSource;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_39887_XMLParser_A07 extends DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // TODO: implement your security-sensitive operations here
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // TODO: implement your security-sensitive operations here
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // TODO: implement your security-sensitive operations here
    }
}

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        File inputFile = new File("input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(new InputSource(new FileInputStream(inputFile)));

        MyXMLHandler myHandler = new MyXMLHandler();
        saxParser.parse(new InputSource(new FileInputStream(inputFile)), myHandler);
    }
}
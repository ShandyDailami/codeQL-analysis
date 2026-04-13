import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLStreamReader;
import org.xml.sax.util.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_10758_XMLParser_A03 {

    public static void main(String[] args) throws IOException, SAXException {
        File inputFile = new File("input.xml");
        XMLStreamReader parser = XMLReaderFactory.createXMLStreamReader(inputFile);
        SAXHandler myHandler = new SAXHandler();

        XMLParser xmlParser = XMLParserFactory.createParser(inputFile, myHandler);
        xmlParser.parse(null);
    }
}

class SAXHandler extends DefaultHandler {

    private boolean bElement = false;
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        bElement = true;
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElement) {
            bElement = false;
            System.out.println("Element: " + currentElement + ", Content: " + new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
    }
}
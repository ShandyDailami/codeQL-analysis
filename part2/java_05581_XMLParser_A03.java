import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;

public class java_05581_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(new InputSource(new FileSystemResource(inputFile)));
            parser.parse(new InputSource(new FileSystemResource(inputFile)), new SAXHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // TODO: Implement your own SAX parser logic here
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // TODO: Implement your own SAX parser logic here
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // TODO: Implement your own SAX parser logic here
    }
}
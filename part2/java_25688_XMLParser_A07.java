import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_25688_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            MyHandler myHandler = new MyHandler();
            saxParser.parse(inputFile, myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements javax.xml.parsers.ContentHandler {
    @Override
    public void startDocument() {}

    @Override
    public void endDocument() {}

    @Override
    public void startElement(String namespaceURI, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) {}

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {}

    @Override
    public void characters(char[] ch, int start, int length) {}

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) {}

    @Override
    public void processingInstruction(String target, String data) {}

    @Override
    public void setElement(String uri, String localName, String qName,
                           javax.xml.parsers.Attributes attributes) {}

    @Override
    public void startPrefixMapping(String prefix, String uri) {}

    @Override
    public void endPrefixMapping(String prefix) {}
}
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_33442_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new SAXHandler());
            saxParser.parse(new File("sample.xml"), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private StringBuilder stringBuilder;
    private boolean tag;

    @Override
    public void startDocument() throws SAXException {
        stringBuilder = new StringBuilder();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println(stringBuilder.toString());
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stringBuilder.append("Starting element: ").append(qName).append("\n");
        tag = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        stringBuilder.append("Ending element: ").append(qName).append("\n");
        tag = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (tag) {
            stringBuilder.append("Text: ").append(new String(ch, start, length)).append("\n");
        }
    }
}
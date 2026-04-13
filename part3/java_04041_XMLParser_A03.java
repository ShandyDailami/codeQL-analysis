import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_04041_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse("input.xml", myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder buffer;

    @Override
    public void startDocument() throws SAXException {
        buffer = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        buffer.append("<");
        buffer.append(qName);
        if (attributes.getLength() > 0) {
            buffer.append(" ");
            for (int i = 0; i < attributes.getLength(); i++) {
                buffer.append(attributes.getQName(i) + "=" + '"' + attributes.getValue(i) + '"' + " ");
            }
        }
        buffer.append(">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        buffer.append("</");
        buffer.append(qName);
        buffer.append(">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(new String(ch, start, length));
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println(buffer.toString());
    }
}
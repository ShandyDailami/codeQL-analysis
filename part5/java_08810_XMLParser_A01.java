import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_08810_XMLParser_A01 extends DefaultHandler {
    public static StringBuilder stringBuilder;

    public java_08810_XMLParser_A01() {
        stringBuilder = new StringBuilder();
    }

    @Override
    public void startDocument() throws SAXException {
        stringBuilder.setLength(0);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println(stringBuilder.toString());
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stringBuilder.append("<").append(qName);
        appendAttributes(attributes);
        stringBuilder.append(">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        stringBuilder.append("</").append(qName).append(">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        stringBuilder.append(new String(ch, start, length));
    }

    private void appendAttributes(Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            stringBuilder.append(" ").append(attributes.getQName(i)).append("=\"").append(attributes.getValue(i)).append("\"");
        }
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new BrokenAccessControlHandler());
            saxParser.parse(new File("broken_access_control.xml"), new SAXSource(new File("broken_access_control.xml")));
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
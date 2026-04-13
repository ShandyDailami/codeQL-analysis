import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_20591_XMLParser_A03 extends DefaultHandler {
    private StringBuilder data = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        data.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        data.append(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if ("person".equals(qName)) {
            System.out.println(data.toString());
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException, SAXException {
        org.xml.sax.SAXParserFactory saxParserFactory =
                org.xml.sax.SAXParserFactory.newInstance();
        org.xml.sax.SAXParser saxParser = saxParserFactory.newSAXParser(null);

        MySAXHandler myHandler = new MySAXHandler();
        saxParser.parse(new File("sample.xml"), myHandler);
    }
}
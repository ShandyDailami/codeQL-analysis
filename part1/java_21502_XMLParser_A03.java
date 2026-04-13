import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_21502_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder sb = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        sb.append("Start element: ");
        sb.append(qName);
        System.out.println(sb.toString());
        sb.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        sb.append("End element: ");
        sb.append(qName);
        System.out.println(sb.toString());
        sb.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        sb.append("Characters: ");
        sb.append(new String(ch, start, length));
        System.out.println(sb.toString());
        sb.setLength(0);
    }
}
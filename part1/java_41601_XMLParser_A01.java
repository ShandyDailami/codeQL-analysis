import java.io.StringReader;
import javax.xml.parsers.XmlPullParserFactory;
import javax.xml.parsers.XmlPullParser;
import javax.xml.parsers.SAXPullParser;

public class java_41601_XMLParser_A01 {

    public static void main(String[] args) throws Exception {
        String xml = "<root>" +
                "<element1>Element 1 data</element1>" +
                "<element2>Element 2 data</element2>" +
                "</root>";

        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        SAXPullParser parser = factory.newSAXPullParser(new SecureXmlHandler(xml), true);
        parser.parse(new StringReader(xml));
    }
}

class SecureXmlHandler implements XmlPullParser.EventListener {
    private String xml;

    public java_41601_XMLParser_A01(String xml) {
        this.xml = xml;
    }

    @Override
    public void startDocument() throws XmlPullParser.StartEndEvent {
        // Security sensitive operation: no exception is thrown.
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() throws XmlPullParser.StartEndEvent {
        // Security sensitive operation: no exception is thrown.
        System.out.println("End Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, XmlPullParser.Attributes attributes) throws XmlPullParser.StartEndEvent {
        // Security sensitive operation: no exception is thrown.
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws XmlPullParser.StartEndEvent {
        // Security sensitive operation: no exception is thrown.
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws XmlPullParser.StartEndEvent {
        // Security sensitive operation: no exception is thrown.
        String data = new String(ch, start, length);
        System.out.println("Characters: " + data);
    }
}
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_28633_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            MyHandler myHandler = new MyHandler();
            saxParser.parse("src/example.xml", myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements javax.xml.parsers.SAXHandler {
    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes)
            throws javax.xml.parsers.SAXException {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws javax.xml.parsers.SAXException {
        System.out.println("End Element: " + qName);
    }
}
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_02608_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            MyHandler handler = new MyHandler();
            saxParser.parse("src/main/resources/sample.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements javax.xml.parsers.SAXHandler {
    boolean isName = false;
    boolean isEmail = false;

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) throws javax.xml.parsers.SAXException {
        if (qName.equalsIgnoreCase("name")) {
            isName = true;
        } else if (qName.equalsIgnoreCase("email")) {
            isEmail = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws javax.xml.parsers.SAXException {
        if (qName.equalsIgnoreCase("name")) {
            isName = false;
        } else if (qName.equalsIgnoreCase("email")) {
            isEmail = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws javax.xml.parsers.SAXException {
        if (isName) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (isEmail) {
            System.out.println("Email: " + new String(ch, start, length));
        }
    }
}
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_38920_XMLParser_A01 {
    public static void main(String[] args) {
        String xml = "<bookstore><book category='fiction'>"
                + "<title>Harry Potter</title>"
                + "<price>29.99</price>"
                + "</book></bookstore>";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MyHandler handler = new MyHandler();
        parser.parse(new StringReader(xml), handler);
    }
}

class MyHandler implements javax.xml.parsers.SAXHandler {
    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);

        String price = attributes.getValue("price");
        if (price != null) {
            System.out.println("Price: " + price);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End Element: " + qName);
    }
}
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_27943_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null);

        MyHandler handler = new MyHandler();
        parser.parse(XMLParser.class.getResourceAsStream("/example.xml"), handler);
    }

    static class MyHandler extends DefaultHandler {
        boolean isPerson = false;
        String name = null;
        String age = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                isPerson = true;
                return;
            }

            if (isPerson) {
                if (qName.equalsIgnoreCase("name")) {
                    name = attributes.getValue("name");
                    return;
                } else if (qName.equalsIgnoreCase("age")) {
                    age = attributes.getValue("age");
                    System.out.println("Name: " + name + ", Age: " + age);
                }
            }
        }
    }
}
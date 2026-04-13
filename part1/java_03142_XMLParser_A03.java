import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_03142_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse("src/main/resources/sample.xml", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bName = false;
        boolean bAge = false;
        String name = null;
        String age = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            } else if (bName) {
                bName = false;
                name = localName;
            } else if (bAge) {
                bAge = false;
                age = localName;
            }

            if (qName.equalsIgnoreCase("name")) {
                System.out.println("Name: " + name);
            } else if (qName.equalsIgnoreCase("age")) {
                System.out.println("Age: " + age);
            }
        }
    }
}
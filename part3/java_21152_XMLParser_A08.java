import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_21152_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse("src/input.xml", new SAXSource(new InputSource(new FileInputStream("src/input.xml"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Name : " + attributes.getValue("name"));
                System.out.println("Age : " + attributes.getValue("age"));
                bName = true;
                bAge = true;
            } else if (bName && qName.equalsIgnoreCase("name")) {
                System.out.println("Name : " + attributes.getValue(""));
                bName = false;
            } else if (bAge && qName.equalsIgnoreCase("age")) {
                System.out.println("Age : " + attributes.getValue(""));
                bAge = false;
            }
        }
    }
}
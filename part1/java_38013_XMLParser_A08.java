import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

public class java_38013_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "src/sample.xml";
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
                System.out.println("Start Element: " + qName);
                return;
            }

            if (bName && qName.equalsIgnoreCase("name")) {
                System.out.println("Name Found!!");
                bName = false;
            }

            if (bAge && qName.equalsIgnoreCase("age")) {
                System.out.println("Age Found!!");
                bAge = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("End Element: " + qName);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
            } else if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }
}
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_34997_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(XMLParserExample.class.getResourceAsStream("/sample.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAge = false;
        private boolean bSalary = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("person")) {
                bName = true;
                bAge = true;
                bSalary = true;
            }
            if (qName.equals("name")) {
                bName = true;
            }
            if (qName.equals("age")) {
                bAge = true;
            }
            if (qName.equals("salary")) {
                bSalary = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("person")) {
                bName = false;
                bAge = false;
                bSalary = false;
            }
            if (qName.equals("name")) {
                bName = false;
            }
            if (qName.equals("age")) {
                bAge = false;
            }
            if (qName.equals("salary")) {
                bSalary = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
            }
            if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
            }
            if (bSalary) {
                System.out.println("Salary: " + new String(ch, start, length));
            }
        }
    }
}
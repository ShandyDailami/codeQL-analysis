import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_37448_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new Handler());
            parser.parse("src/input.xml", true);
        } catch (Exception e) {
            System.err.println("Parsing failed: " + e.getMessage());
        }
    }

    static class Handler extends DefaultHandler {

        boolean bAge = false;
        boolean bId = false;
        boolean bName = false;
        boolean bSex = false;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            switch (qName) {
                case "age":
                    bAge = true;
                    break;
                case "id":
                    bId = true;
                    break;
                case "name":
                    bName = true;
                    break;
                case "sex":
                    bSex = true;
                    break;
            }
        }

        @Override
        public java_37448_XMLParser_A08(String uri, String localName, String qName)throws SAXException {
            switch (qName) {
                case "age":
                    bAge = false;
                    break;
                case "id":
                    bId = false;
                    break;
                case "name":
                    bName = false;
                    break;
                case "sex":
                    bSex = false;
                    break;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
            } else if (bId) {
                System.out.println("ID: " + new String(ch, start, length));
            } else if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
            } else if (bSex) {
                System.out.println("Sex: " + new String(ch, start, length));
            }
        }
    }
}
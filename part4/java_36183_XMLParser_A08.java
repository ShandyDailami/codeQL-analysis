import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_36183_XMLParser_A08 {
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());

        File inputFile = new File("input.xml");
        parser.parse(inputFile, new SAXHandler());
    }

    static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("student")) {
                return;
            }

            if (qName.equalsIgnoreCase("name")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("age")) {
                bAge = true;
            }
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equalsIgnoreCase("student")) {
                return;
            }

            if (qName.equalsIgnoreCase("name")) {
                bName = false;
            } else if (qName.equalsIgnoreCase("age")) {
                bAge = false;
            }
        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bName) {
                // Security-sensitive operation: Verify if the age is greater than 18
                if (Integer.parseInt(new String(ch, start, length)) > 18) {
                    System.out.println("Age is greater than 18, but it's a security-sensitive operation!");
                }
            } else if (bAge) {
                // Security-sensitive operation: Verify if the name contains certain characters
                if (!new String(ch, start, length).contains("a")) {
                    System.out.println("Name contains certain characters, but it's a security-sensitive operation!");
                }
            }
        }
    }

    static class SAXHandler extends DefaultHandler {
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            System.out.println("Start of element: " + qName);
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("End of element: " + qName);
        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}
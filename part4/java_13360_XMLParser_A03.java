import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;

public class java_13360_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            File inputFile = new File("input.xml");
            parser.parse(inputFile, new SAXHandler(parser));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean nameFound = false;
        private boolean attributeFound = false;

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("name")) {
                nameFound = true;
            }
            if (qName.equals("attribute")) {
                attributeFound = true;
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("name")) {
                nameFound = false;
            }
            if (qName.equals("attribute")) {
                attributeFound = false;
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (nameFound && !attributeFound) {
                String str = new String(ch, start, length);
                System.out.println("Name: " + str);
            } else if (!nameFound && attributeFound) {
                String str = new String(ch, start, length);
                System.out.println("Attribute: " + str);
            }
        }
    }

    static class SAXHandler extends DefaultHandler {
        private SAXParser parser;

        public java_13360_XMLParser_A03(SAXParser parser) {
            this.parser = parser;
        }

        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
            if (attributes.getLength() > 0) {
                System.out.println("Attributes: ");
                for (int i = 0; i < attributes.getLength(); i++) {
                    String attrName = attributes.getQName(i);
                    String attrValue = attributes.getValue(i);
                    System.out.println("  " + attrName + " = " + attrValue);
                }
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_27137_XMLParser_A08 {

    public static void main(String[] args) throws Exception {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        // Parse the XML file
        saxParser.parse(new File("src/test.xml"), new MyHandler());
    }

    static class MyHandler implements javax.xml.parsers.ContentHandler {
        private boolean isStartElement = true;

        @Override
        public void startElement(String uri, String localName, String qName,
                                 javax.xml.parsers.Attributes attributes) {
            if (!isStartElement) {
                System.out.println("-");
            }

            isStartElement = false;

            System.out.print(localName);

            // Print attributes if any
            if (attributes != null) {
                System.out.print(" [");
                for (int i = 0; i < attributes.getLength(); i++) {
                    if (i > 0) {
                        System.out.print(", ");
                    }
                    System.out.print(attributes.getQName(i) + "=" + attributes.getValue(i));
                }
                System.out.println("]");
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            isStartElement = true;
            System.out.println(qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (isStartElement) {
                System.out.print(new String(ch, start, length));
            }
        }
    }
}
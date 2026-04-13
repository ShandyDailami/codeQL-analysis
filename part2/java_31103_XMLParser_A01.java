import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_31103_XMLParser_A01 {

    public static void main(String[] args) {
        String filePath = "path_to_your_xml_file";
        parseFile(filePath);
    }

    private static void parseFile(String filePath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean tagName = false;
        private boolean tagContent = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            tagName = true;
            tagContent = false;
            printElement(qName, attributes);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            tagName = false;
            tagContent = false;
            System.out.println("End of: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (tagName) {
                String content = new String(ch, start, length);
                System.out.print("Content: " + content);
                tagContent = true;
            }
        }

        private void printElement(String qName, Attributes attributes) {
            System.out.print("Start of: " + qName);
            if (attributes.getLength() > 0) {
                System.out.print(" with Attributes: ");
                for (int i = 0; i < attributes.getLength(); i++) {
                    System.out.print(attributes.getQName(i) + "=" + attributes.getValue(i));
                }
            }
            System.out.println();
        }
    }
}
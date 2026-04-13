import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_40117_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            File inputFile = new File("input.xml");
            saxParser.parse(inputFile, new MyHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private StringBuilder stringBuilder;
        private int depth;

        public java_40117_XMLParser_A08() {
            stringBuilder = new StringBuilder();
            depth = 0;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            depth++;
            printIndentation();
            System.out.println("Start of tag: " + qName);
            printAttributes(attributes);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            depth--;
            printIndentation();
            System.out.println("End of tag: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String content = new String(ch, start, length);
            if (content.trim().length() > 0) {
                printIndentation();
                System.out.println("Content: " + content);
            }
        }

        private void printIndentation() {
            for (int i = 0; i < depth; i++) {
                System.out.print("  ");
            }
        }

        private void printAttributes(Attributes attributes) {
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.print("Attribute: " + attributes.getQName(i) + "=" + attributes.getValue(i));
                if (i < attributes.getLength() - 1) {
                    System.out.print(", ");
                }
            }
        }
    }
}
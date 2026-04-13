import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_07904_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("src/main/resources/data.xml"), true);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private int depth = 0;

        @Override
        public void startDocument() {
            System.out.println("Start document");
        }

        @Override
        public void endDocument() {
            System.out.println("End document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            depth++;
            printIndentation();
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            depth--;
            printIndentation();
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            depth++;
            printIndentation();
            System.out.println("Characters: " + new String(ch, start, length));
        }

        private void printIndentation() {
            for (int i = 0; i < depth; i++) {
                System.out.print("  ");
            }
        }
    }
}
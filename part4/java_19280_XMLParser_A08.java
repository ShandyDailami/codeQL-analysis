import java.io.File;
import java.io.IOException;
import java.util.Stack;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_19280_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null);

        MyHandler handler = new MyHandler();
        parser.parse(new File("src/main/resources/data.xml"), handler);
    }

    static class MyHandler extends DefaultHandler {
        private Stack<String> elementStack = new Stack<>();

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
            elementStack.push(qName);
            printIndentation();
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            elementStack.pop();
            printIndentation();
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (elementStack.peek().equals(qName)) {
                String content = new String(ch, start, length).trim();
                if (!content.isEmpty()) {
                    printIndentation();
                    System.out.println("Character data: " + content);
                }
            }
        }

        private void printIndentation() {
            for (int i = 0; i < elementStack.size(); i++) {
                System.out.print("--");
            }
            System.out.println();
        }
    }
}
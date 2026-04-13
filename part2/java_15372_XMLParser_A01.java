import java.io.File;
import java.util.Stack;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_15372_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("input.xml"), new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private Stack<String> stack = new Stack<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            stack.push(qName);
            printIndentation();
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            stack.pop();
            printIndentation();
            System.out.println("End element: " + qName);
        }

        private void printIndentation() {
            for (int i = 0; i < stack.size(); i++) {
                System.out.print("--");
            }
            System.out.println();
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String str = new String(ch, start, length);
            str = str.trim();
            if (!str.isEmpty()) {
                printIndentation();
                System.out.println("Characters: " + str);
            }
        }
    }
}
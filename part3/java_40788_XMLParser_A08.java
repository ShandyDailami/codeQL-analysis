import java.util.Stack;
import java.util.Iterator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_40788_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null);
            File inputFile = new File("input.xml");
            parser.parse(inputFile, new XmlHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class XmlHandler extends DefaultHandler {
        Stack<String> stack = new Stack<String>();

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
                stack.push(qName);
                printIndentation();
                System.out.print("Start element ");
                System.out.println(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            stack.pop();
            printIndentation();
            System.out.print("End element ");
            System.out.println(qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (stack.peek().equalsIgnoreCase("element")) {
                System.out.print("Character data: ");
                System.out.println(new String(ch, start, length));
            }
        }

        void printIndentation () {
            for (int i = 0; i < stack.size(); i++) {
                System.out.print("--");
            }
            System.out.print("\n");
        }
    }
}
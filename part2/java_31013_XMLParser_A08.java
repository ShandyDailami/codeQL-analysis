import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLErrorHandler;
import org.xml.sax.parser.XMLEventReader;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLScanner;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class java_31013_XMLParser_A08 {

    private static class CustomHandler extends DefaultHandler {

        private Stack<String> stack = new Stack<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            stack.push(qName);
            System.out.println("Start Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            stack.pop();
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String content = new String(ch, start, length).trim();
            if (!content.isEmpty()) {
                System.out.println("Characters: " + content);
            }
        }
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            XMLErrorHandler errorHandler = new CustomHandler();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLEventReader reader = factory.newSAXEventReader(inputFile, errorHandler);
            XMLParser parser = factory.newSAXParser(reader);

            parser.parse(0); // This line should be modified to your logic
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
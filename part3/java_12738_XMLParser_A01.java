import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_12738_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MyHandler handler = new MyHandler();
        parser.parse(new File("path_to_your_file.xml"), handler);
    }

    static class MyHandler extends DefaultHandler {

        boolean isInElement = false;
        String elementContent = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            isInElement = true;
            elementContent = "";
        }

        @Override
        public void characters(char[] chars, int start, int length) throws SAXException {
            if (isInElement) {
                elementContent += new String(chars, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            isInElement = false;
            // Process the parsed element and reset the content
            processElement(qName, elementContent);
        }

        private void processElement(String name, String content) {
            // Place your security-sensitive operations here
            // For example, you can check if the content is empty
            if(content.isEmpty()) {
                System.out.println("Element " + name + " is empty!");
            }
        }
    }
}
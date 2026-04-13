import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;

public class java_33136_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        SAXHandler saxHandler = new SAXHandler();
        saxParser.parse(new File("sample.xml"), saxHandler);
    }

    public static class SAXHandler implements javax.xml.parsers.SAXHandler {
        Document document;
        int currentDepth = 0;

        @Override
        public void startDocument() throws SAXException {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        }

        @Override
        public void endDocument() throws SAXException {
            // Do nothing
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            printIndentation(currentDepth);
            System.out.println(qName);
            currentDepth++;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentDepth--;
            printIndentation(currentDepth);
            System.out.println(qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            printIndentation(currentDepth);
            System.out.println(new String(ch, start, length));
        }

        private void printIndentation(int depth) {
            for (int i = 0; i < depth; i++) {
                System.out.print("    ");
            }
        }
    }
}
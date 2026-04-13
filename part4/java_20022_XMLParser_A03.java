import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_20022_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("src/resources/injection.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(new javax.xml.transform.dom.DOMSource(xmlFile));
            saxParser.setProperty("class", "org.xml.sax.ext.Locator2");
            MyHandler handler = new MyHandler();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(handler);
            saxParser.parse(xmlFile, handler);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private int depth = 0;
        private StringBuilder text = new StringBuilder();

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            text.append(ch, start, length);
        }

        @Override
        public void startElement(String uri, String localName, String qName, javax.xml.namespace.QName qLname, javax.xml.transform.dom.DOMSource domSource) throws SAXException {
            depth++;
            printIndent();
            System.out.println(qName);
            text.setLength(0);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            depth--;
            printIndent();
            System.out.println(qName);
            System.out.println("  Text: " + text.toString());
            text.setLength(0);
        }

        private void printIndent() {
            for (int i = 0; i < depth; i++) {
                System.out.print("  ");
            }
        }
    }
}
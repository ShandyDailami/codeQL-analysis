import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_36783_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            saxParser.parse(new File("input.xml"), new MyHandler());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler implements javax.xml.parsers.ContentHandler {
        private StringBuffer buffer = new StringBuffer();

        public void startDocument() {
            System.out.println("Start document");
        }

        public void endDocument() {
            System.out.println("End document");
        }

        public void startElement(String uri, String localName, String qName,
                javax.xml.parsers.Attributes attributes) throws SAXException {
            buffer.append("Start element: ");
            buffer.append(qName);
            System.out.println(buffer.toString());
            buffer.setLength(0);
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            buffer.append("End element: ");
            buffer.append(qName);
            System.out.println(buffer.toString());
            buffer.setLength(0);
        }

        public void characters(char[] ch, int start, int length) {
            buffer.append("Characters: ");
            buffer.append(new String(ch, start, length));
            System.out.println(buffer.toString());
            buffer.setLength(0);
        }

        public void fatalError(String error) throws SAXException {
            System.out.println("Fatal Error: " + error);
        }

        public void warning(String msg) {
            System.out.println("Warning: " + msg);
        }
    }
}
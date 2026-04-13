import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class java_34619_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            // Read XML file
            Document document = documentBuilder.parse(new File("sample.xml"));

            // Parse XML data
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("sample.xml"), myHandler);

            // Print parsed data
            System.out.println("Parsed data: " + myHandler.getData());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SAX Handler
    static class MyHandler implements org.xml.sax.helpers.DefaultHandler {
        private String data;

        @Override
        public void startDocument() {
            data = "";
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            data += localName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            data += " " + localName;
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            data += new String(ch, start, length);
        }

        public String getData() {
            return data;
        }
    }
}
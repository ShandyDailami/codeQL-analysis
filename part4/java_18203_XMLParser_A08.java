import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_18203_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("yourfile.xml"); // replace with your XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(xmlFile);
            XMLReader reader = XMLReaderFactory.createXMLReader();

            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);
            reader.setErrorHandler(handler);

            reader.parse(new org.xml.sax.InputSource(new StringReader(document.getDocumentElement().getOuterXml())));

            System.out.println("Parsed Successfully");

        } catch (Exception e) {
            System.out.println("Failed to parse XML: " + e.getMessage());
        }
    }

    static class MyHandler extends DefaultHandler {
        @Override
        public void error(SAXParseException e) {
            System.out.println("SAXParseException: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) {
            System.out.println("Fatal SAXParseException: " + e.getMessage());
        }

        @Override
        public void warning(SAXParseException e) {
            System.out.println("SAXParseException: " + e.getMessage());
        }

        @Override
        public void startDocument() {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String str = new String(ch, start, length);
            System.out.println("Character Data: " + str);
        }
    }
}
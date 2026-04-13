import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_37956_XMLParser_A07 {

    public static class MyHandler extends DefaultHandler {

        public void startElement(String uri, String localName, String qName, Element element) {
            System.out.println("Start element: " + qName);
        }

        public void endElement(String uri, String localName, String qName) {
            System.out.println("End element: " + qName);
        }

        public void characters(char[] ch, int start, int length) {
            System.out.println("Characters: " + new String(ch, start, length));
        }

        public void error(SAXException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            SAXParser saxParser = saxFactory.newSAXParser(new DocumentBuilderFactory().getNamespaceAwareInstance(false));

            MyHandler handler = new MyHandler();

            File inputFile = new File("src/input.xml");

            Document doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();

            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new FileInputStream(inputFile));

            System.out.println("Document is parsed successfully.");

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
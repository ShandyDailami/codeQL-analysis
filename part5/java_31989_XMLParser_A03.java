import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_31989_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(xmlFile);
            XMLReader reader = builder.newSAXReader();
            reader.setContentHandler(new SAXHandler());
            reader.parse(new org.xml.sax.InputSource(new java.io.StringReader(document.getFirstChild().getNodeName())));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {
        @Override
        public void startDocument() throws SAXParseException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXParseException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXParseException {
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXParseException {
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXParseException {
            String content = new String(ch, start, length);
            System.out.println("Character content: " + content);
        }
    }
}
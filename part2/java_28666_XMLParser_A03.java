import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

public class java_28666_XMLParser_A03 {

    private static class MyHandler extends DefaultHandler {

        private Document document;
        private Element rootElement;

        public void startDocument() throws SAXException {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.newDocument();
            rootElement = document.getDocumentElement();
        }

        public void startElement(String uri, String localName, String qName) throws SAXException {
            // Processing start tags.
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Processing end tags.
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            // Processing character data.
        }

        public void error(SAXException e) {
            System.out.println("SAX Exception: " + e.getMessage());
        }

        public void fatalError(SAXException e) {
            System.out.println("Fatal SAX Exception: " + e.getMessage());
        }

        public void warning(SAXException e) {
            System.out.println("Warning: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyHandler());
            reader.parse(new File("test.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
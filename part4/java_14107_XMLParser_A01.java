import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_14107_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml"); // XML file path

        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setEntityResolver(new MyEntityResolver());
            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);
            reader.parse(new SAXSource(reader));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler implements org.xml.sax.helpers.DefaultHandler {
        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
            System.out.println("Ignorable whitespace: " + new String(ch, start, length));
        }
    }

    static class MyEntityResolver implements org.xml.sax.helpers.EntityResolver {
        @Override
        public org.xml.sax.InputSource resolveEntity(String systemId) throws SAXException {
            return new InputSource(new StringReader("<error>&SYSID;" + systemId + ";</error>"));
        }
    }
}
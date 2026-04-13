import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_41464_XMLParser_A01 extends DefaultHandler {
    public java_41464_XMLParser_A01() {
        try {
            Class.forName("org.xml.sax.helpers.DefaultHandler");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void parse(String fileName) {
        EntityResolver resolver = new CustomEntityResolver();
        SAXReader reader = new SAXReader(resolver);
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        xmlReader.setContentHandler(this);
        xmlReader.setEntityResolver(resolver);

        try {
            xmlReader.parse(new File(fileName));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    private class CustomEntityResolver implements EntityResolver {
        public boolean loadDTD(String dtdFileName, String baseURI,
                               String title, String charset) {
            return false;
        }

        public boolean loadExternalDTD(String dtdFileName, String baseURI,
                                       String title, String charset) {
            return false;
        }

        public InputSource resolveEntity(String entityName, String baseURI,
                                         String title, String charset)
                throws SAXException, IOException {
            return null;
        }
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parse("test.xml");
    }
}
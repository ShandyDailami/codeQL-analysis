import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.Entity;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_29117_XMLParser_A03 extends DefaultHandler {

    public static void main(String[] args) {
        String xmlFile = "sample.xml"; // The XML file to parse
        parse(xmlFile);
    }

    private static void parse(String xmlFile) {
        File xml = new File(xmlFile);
        XMLReader reader;
        EntityResolver resolver = new EntityResolver() {
            public Entity getEntity(String url) throws SAXException {
                return null;
            }
        };

        try {
            reader = XMLReaderFactory.createXMLReader(resolver);
            reader.setContentHandler(new MySAXHandler());
            reader.parse(xml.toURI().toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        System.out.println("Start of Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void fatalError(String error) throws SAXException {
        System.out.println("Fatal Error: " + error);
    }

    @Override
    public void warning(String msg) throws SAXException {
        System.out.println("Warning: " + msg);
    }

}
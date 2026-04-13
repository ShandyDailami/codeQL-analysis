import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_14903_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try (SAXParser saxParser = saxParserFactory.newSAXParser(true)) {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            SecurityHandler securityHandler = new SecurityHandler();
            xmlReader.setContentHandler(securityHandler);

            File xmlFile = new File("path_to_your_file.xml");
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SecurityHandler implements org.xml.sax.helpers.DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Document started");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Document ended");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        System.out.println("Element started: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Element ended: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void error(SAXException e) {
        System.err.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) {
        System.err.println("Fatal Error: " + e.getMessage());
    }
}
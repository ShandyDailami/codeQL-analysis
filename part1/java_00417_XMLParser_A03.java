import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_00417_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try (SAXParser saxParser = saxParserFactory.newSAXParser(xmlFile.toURI().toURL())) {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            XMLHandler xmlHandler = new XMLHandler();

            xmlReader.setContentHandler(xmlHandler);
            xmlReader.parse(new File(xmlFile.getPath()));

            System.out.println("Data: " + xmlHandler.getData());
            System.out.println("Warning: " + xmlHandler.getWarning());
            System.out.println("Error: " + xmlHandler.getError());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler implements org.xml.sax.helpers.DefaultHandler {
    private StringBuilder data = new StringBuilder();
    private StringBuilder warning = new StringBuilder();
    private StringBuilder error = new StringBuilder();

    @Override
    public void startDocument() {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() {
        System.out.println("End Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void warning(SAXException e) {
        warning.append("Warning: ").append(e.getMessage()).append("\n");
    }

    @Override
    public void error(SAXException e) {
        error.append("Error: ").append(e.getMessage()).append("\n");
    }

    @Override
    public void fatalError(SAXException e) {
        error.append("Fatal Error: ").append(e.getMessage()).append("\n");
    }

    public StringBuilder getData() {
        return data;
    }

    public StringBuilder getWarning() {
        return warning;
    }

    public StringBuilder getError() {
        return error;
    }
}
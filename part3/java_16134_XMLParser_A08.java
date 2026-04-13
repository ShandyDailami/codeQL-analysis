import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_16134_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("path/to/your/xml/file.xml");
        XMLReader reader;

        try {
            reader = XMLReaderFactory.createXMLReader();
            XmlHandler handler = new XmlHandler();

            reader.setContentHandler(handler);
            reader.parse(xmlFile);

            System.out.println("Parsing completed successfully.");

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class XmlHandler implements org.xml.sax.helpers.DefaultHandler {

    @Override
    public void startDocument() {
        System.out.println("Start of document.");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) {
        System.out.println("Ignorable whitespace: " + new String(ch, start, length));
    }

    @Override
    public void processingInstruction(String target, String data) {
        System.out.println("Processing instruction: " + target + " " + data);
    }

    @Override
    public void comment(char[] ch, int start, int length) {
        System.out.println("Comment: " + new String(ch, start, length));
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) {
        System.out.println("Start of prefix mapping: " + prefix + " - " + uri);
    }

    @Override
    public void endPrefixMapping(String prefix) {
        System.out.println("End of prefix mapping: " + prefix);
    }

    @Override
    public void warning(SAXException e) {
        System.out.println("Warning: " + e.getMessage());
    }

    @Override
    public void error(SAXException e) {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) {
        System.out.println("Fatal error: " + e.getMessage());
    }
}
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_14977_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFilePath = "src/main/resources/example.xml"; // You should replace this with your actual file path
        parseXmlFile(xmlFilePath);
    }

    public static void parseXmlFile(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        if (!xmlFile.exists()) {
            System.out.println("The provided XML file does not exist.");
            return;
        }

        XMLReader xmlReader = null;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new XmlContentHandler());
            xmlReader.parse(xmlFile);
        } catch (SAXException | IOException e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
        } finally {
            if (xmlReader != null) {
                try {
                    xmlReader.close();
                } catch (SAXException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class XmlContentHandler implements org.xml.sax.ContentHandler {

    @Override
    public void startDocument() {
        System.out.println("Start of XML Document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of XML Document");
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
    public void characters(char[] chars, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(chars, start, length));
    }

    @Override
    public void ignorableWhitespace(char[] chars, int start, int length) throws SAXException {
        System.out.println("Ignorable Whitespace: " + new String(chars, start, length));
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        System.out.println("Processing Instruction: " + target + ", " + data);
    }

    @Override
    public void comment(char[] chars, int start, int length) throws SAXException {
        System.out.println("Comment: " + new String(chars, start, length));
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        System.out.println("End of Prefix Mapping: " + prefix);
    }
}
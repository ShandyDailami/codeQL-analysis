import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.ext.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_23713_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("myFile.xml");
        DefaultHandler handler = new MyHandler();
        SAXParser saxParser = new SAXParser(handler, true);

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setFeature("http://xml.org/sax/features/external-parametrization", false);
            reader.setFeature("http://xml.org/sax/features/namespaces", false);
            reader.setFeature("http://xml.org/sax/features/namespace-prefixes", false);
            reader.setFeature("http://xml.org/sax/features/validation", false);
            reader.setFeature("http://xml.org/sax/features/xinclude", false);
            reader.setFeature("http://xml.org/sax/features/xml-version", false);
            reader.setFeature("http://xml.org/sax/features/international-identifiers", false);
            reader.setFeature("http://xml.org/sax/features/chars-and-tags", false);
            reader.setFeature("http://xml.org/sax/features/lexical-handling", false);
            reader.setFeature("http://xml.org/sax/features/namespaces", false);

            saxParser.setValidation(false);
            saxParser.setDTD(false);

            reader.read(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Place your code here to handle start elements
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Place your code here to handle end elements
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Place your code here to handle characters
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        // Handle the start of a prefix mapping
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        // Handle the end of a prefix mapping
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        // Handle ignorable whitespace
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        // Handle processing instructions
    }

    @Override
    public void setElementLanguage(String language) {
        // Handle the language attribute
    }

    @Override
    public void startDocument() throws SAXException {
        // Handle the start of a document
    }

    @Override
    public void endDocument() throws SAXException {
        // Handle the end of a document
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        // Handle warnings
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        // Handle errors
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        // Handle fatal errors
    }
}
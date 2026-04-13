import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class java_38488_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            XMLParser parser = new XMLParserImpl();
            parser.parse("src/main/resources/data.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLParserImpl implements XMLParser {
    private SAXParserFactory factory;
    private SAXParser parser;

    public java_38488_XMLParser_A07() {
        factory = SAXParserFactory.newInstance();
        parser = factory.newSAXParser(ClassLoader.getSystemClassLoader());
    }

    @Override
    public void parse(String filePath) throws Exception {
        InputStream inputStream = new FileInputStream(filePath);
        parser.setContentHandler(new ContentHandlerImpl(inputStream));
        parser.parse(new InputSource(inputStream));
    }
}

class ContentHandlerImpl implements SAXHandler {
    private InputStream inputStream;

    public java_38488_XMLParser_A07(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        System.out.println("Ignorable Whitespace: " + new String(ch, start, length));
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        System.out.println("Processing Instruction: " + target + ", " + data);
    }

    @Override
    public void setDocumentLocator(DocumentLocator locator) throws SAXException {
        System.out.println("Set Document Locator");
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println("Start Prefix Mapping: " + prefix + ", " + uri);
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        System.out.println("End Prefix Mapping: " + prefix);
    }
}
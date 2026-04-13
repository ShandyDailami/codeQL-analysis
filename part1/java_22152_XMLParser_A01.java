import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class java_22152_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new XMLHandler());
            InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("sample.xml");
            parser.parse(inputStream, true);
        } catch (SAXParseException e) {
            System.err.println("Parsing failed: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Failed to load input stream: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Failed to initialize SAXParser: " + e.getMessage());
        }
    }
}

class XMLHandler extends DefaultHandler {
    private StringBuffer buffer;

    @Override
    public void startDocument() {
        buffer = new StringBuffer();
    }

    @Override
    public void endDocument() {
        System.out.println(buffer.toString());
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        buffer.append("<").append(qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            buffer.append(" ").append(attributes.getQName(i)).append("=\"").append(attributes.getValue(i)).append("\"");
        }
        buffer.append(">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        buffer.append("</").append(qName).append(">");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        buffer.append(new String(ch, start, length));
    }
}
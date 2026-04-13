import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_31539_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            File inputFile = new File("input.xml");
            parser.parse(inputFile, new SAXHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder content;
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        content = new StringBuilder();
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println(content.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        content.append(new String(ch, start, length));
    }
}

class SAXHandler extends DefaultHandler {
    @Override
    public void startDocument() {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes attributes) {
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Character data: " + new String(ch, start, length));
    }
}
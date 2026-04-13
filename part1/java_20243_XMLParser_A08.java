import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_20243_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            File inputFile = new File("src/main/resources/input.xml");
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
    private boolean elementContent;
    private String currentElement;

    @Override
    public void startDocument() {
        content = new StringBuilder();
    }

    @Override
    public void endDocument() {
        System.out.println(content.toString());
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        content.append("Start of " + qName + "\n");
        currentElement = qName;
        elementContent = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        content.append("End of " + qName + "\n");
        currentElement = "";
        elementContent = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (elementContent) {
            content.append(new String(ch, start, length) + "\n");
        }
    }
}

class SAXHandler extends DefaultHandler {
    private StringBuilder content;
    private boolean elementContent;
    private String currentElement;

    @Override
    public void startDocument() {
        content = new StringBuilder();
    }

    @Override
    public void endDocument() {
        System.out.println(content.toString());
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        content.append("Start of " + qName + "\n");
        currentElement = qName;
        elementContent = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        content.append("End of " + qName + "\n");
        currentElement = "";
        elementContent = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (elementContent) {
            content.append(new String(ch, start, length) + "\n");
        }
    }
}
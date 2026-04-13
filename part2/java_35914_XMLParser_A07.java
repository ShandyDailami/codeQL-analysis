import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_35914_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("books.xml"), true);
        } catch (SAXParseException e) {
            System.out.println("Parsing failed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unknown error: " + e.getMessage());
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder data;
    private String currentElement;

    @Override
    public void startDocument() {
        data = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;
        data.append("<").append(qName).append(">");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        data.append("</").append(qName).append(">");
        currentElement = "";
    }

    @Override
    public void endDocument() {
        System.out.println(data.toString());
    }
}
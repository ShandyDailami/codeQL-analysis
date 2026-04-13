import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_10031_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            SAXHandler saxHandler = new SAXHandler();
            saxParser.parse(Class.forName("org.w3c.dom.Document").getResourceAsStream("books.xml"), saxHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {

    private boolean tagName = false;
    private boolean tagValue = false;
    private String currentTag;
    private String currentValue;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTag = qName;
        tagName = true;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (tagName) {
            currentValue = new String(ch, start, length);
            tagName = false;
            tagValue = true;
        } else {
            currentValue += new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentTag.equalsIgnoreCase("book")) {
            System.out.println("Book Title: " + currentValue);
            System.out.println("Book Author: " + currentValue);
        } else {
            if (tagValue) {
                System.out.println(currentTag + ": " + currentValue);
                tagValue = false;
            }
        }
    }
}
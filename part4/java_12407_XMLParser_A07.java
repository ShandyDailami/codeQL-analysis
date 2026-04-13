import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_12407_XMLParser_A07 {

    public static void main(String[] args) {
        String filePath = "src/main/resources/example.xml";
        parseFile(filePath);
    }

    public static void parseFile(String filePath) {
        File xmlFile = new File(filePath);
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(false);

            SAXHandler saxHandler = new SAXHandler();
            saxParser.parse(xmlFile, saxHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {

    private boolean isAuthor;
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("author")) {
            isAuthor = true;
        } else {
            currentElement = qName;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("author")) {
            isAuthor = false;
        } else {
            if (isAuthor) {
                System.out.println(currentElement + ": " + qName);
            }
            currentElement = null;
        }
    }
}
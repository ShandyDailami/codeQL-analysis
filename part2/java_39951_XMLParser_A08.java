import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_39951_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());

            File inputFile = new File("input.xml");
            saxParser.parse(inputFile, new SAXHandlerImpl());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean bName;
    private boolean bAge;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("name")) {
            bName = true;
        } else if (qName.equals("age")) {
            bAge = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("name")) {
            bName = false;
        } else if (qName.equals("age")) {
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bName) {
            // Process the name here
        } else if (bAge) {
            // Process the age here
        }
    }
}

class SAXHandlerImpl extends SAXHandler {
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        // Handle start element
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        // Handle end element
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        // Handle characters
    }
}
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_16342_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("input.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(xmlFile, handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder data;
    private boolean bName;
    private boolean bId;

    @Override
    public void startDocument() {
        data = new StringBuilder();
        bName = false;
        bId = false;
    }

    @Override
    public void endDocument() {
        // Nothing to do in this case
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("user")) {
            bName = true;
            bId = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("user")) {
            bName = false;
            bId = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bName) {
            data.append(new String(ch, start, length));
        } else if (bId) {
            // Do not print the ID because it's a security-sensitive operation
        }
    }
}
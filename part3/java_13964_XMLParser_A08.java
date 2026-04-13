import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_13964_XMLParser_A08 extends DefaultHandler {
    private boolean bNodeFound = false;
    private String currentElement = "";
    private StringBuffer buffer = new StringBuffer();

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        bNodeFound = false;
        buffer.setLength(0);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("node".equals(qName)) {
            bNodeFound = true;
        } else {
            if (bNodeFound) {
                buffer.append(localName);
            }
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bNodeFound) {
            buffer.append(new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            MyXMLParser handler = new MyXMLParser();
            parser.parse(new File("src/main/resources/data.xml"), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
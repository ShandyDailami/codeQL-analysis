import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_01845_XMLParser_A03 extends DefaultHandler {

    private String lastTag;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        lastTag = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        lastTag = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastTag.equals("person")) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (lastTag.equals("age")) {
            System.out.println("Age: " + new String(ch, start, length));
        } else if (lastTag.equals("city")) {
            System.out.println("City: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyXMLHandler myXMLHandler = new MyXMLHandler();
            saxParser.parse(new File("src/sample.xml"), myXMLHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
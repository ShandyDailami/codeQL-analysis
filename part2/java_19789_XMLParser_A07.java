import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_19789_XMLParser_A07 extends DefaultHandler {

    private boolean bName;
    private boolean bAge;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            bName = true;
            bAge = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            String name = new String(ch, start, length);
            System.out.println("Name: " + name);
            bName = false;
        } else if (bAge) {
            String age = new String(ch, start, length);
            System.out.println("Age: " + age);
            bAge = false;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxFactory.newSAXParser();

            saxParser.parse(new File("src/sample.xml"), new MyXMLHandler());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
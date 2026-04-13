import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_10454_XMLParser_A01 extends DefaultHandler {

    boolean bName = false;
    boolean bAge = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;

            System.out.println("Person");
            return;
        }

        if (bName) {
            System.out.println("Name: " + localName);
            bName = false;
        }

        if (bAge) {
            System.out.println("Age: " + localName);
            bAge = false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("src/main/resources/data.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
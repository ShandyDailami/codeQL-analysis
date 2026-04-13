import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_23743_XMLParser_A08 extends DefaultHandler {
    private boolean bName;
    private boolean bAge;

    public java_23743_XMLParser_A08() {
        bName = false;
        bAge = false;
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            return;
        }

        if (qName.equalsIgnoreCase("name")) {
            bName = true;
            return;
        }

        if (qName.equalsIgnoreCase("age")) {
            bAge = true;
            return;
        }

        if (bName && bAge) {
            String name = attributes.getValue("name");
            int age = Integer.parseInt(attributes.getValue("age"));
            System.out.println("Name: " + name + ", Age: " + age);
            bName = false;
            bAge = false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String xmlFile = "/path/to/your/xml/file.xml";

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            XMLReader xmlReader = saxParser.getXMLReader();

            MyHandler myHandler = new MyHandler();
            xmlReader.setContentHandler(myHandler);

            xmlReader.parse(new File(xmlFile));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
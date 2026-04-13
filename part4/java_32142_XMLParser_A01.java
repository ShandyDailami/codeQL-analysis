import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_32142_XMLParser_A01 extends DefaultHandler {

    private boolean bAccessControl;

    public java_32142_XMLParser_A01() {
        bAccessControl = false;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("access")) {
            String level = attributes.getValue("level");
            if ("critical".equals(level)) {
                bAccessControl = true;
            } else {
                bAccessControl = false;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bAccessControl) {
            System.out.println("Access control violation!");
        }
    }
}

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            saxParser.parse(new File("src/main/resources/sample.xml"), new MyXMLHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
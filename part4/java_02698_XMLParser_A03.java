import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XPParser;
import org.xml.sax.parser.SAXParserFactory;

public class java_02698_XMLParser_A03 {

    private static class MyHandler extends DefaultHandler {
        private boolean nameFound = false;
        private boolean ageFound = false;

        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                nameFound = true;
            } else if (qName.equalsIgnoreCase("age")) {
                ageFound = true;
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (nameFound) {
                System.out.println("Name: " + new String(ch, start, length));
                nameFound = false;
            } else if (ageFound) {
                System.out.println("Age: " + new String(ch, start, length));
                ageFound = false;
            }
        }
    }

    public static void main(String[] args) {
        try {
            String xmlFile = "path_to_your_xml_file.xml";
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLParser parser = factory.newSAXParser(new InputStreamReader(new FileInputStream(xmlFile), "UTF-8");
            MyHandler myHandler = new MyHandler();
            parser.parse(new InputStreamReader(new FileInputStream(xmlFile), "UTF-8"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
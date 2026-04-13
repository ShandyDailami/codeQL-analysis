import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_17856_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("data.xml");
        parseXml(xmlFile);
    }

    private static void parseXml(File xmlFile) {
        SAXHandler handler = new SAXHandler();
        try {
            SAXReader reader = XMLReaderFactory.createSAXReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {

        private List<String> names = new ArrayList<>();
        private List<String> values = new ArrayList<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            names.add(localName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Ignore closing tags
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String value = new String(ch, start, length);
            values.add(value);
        }

        public void printResults() {
            for (int i = 0; i < names.size(); i++) {
                System.out.println(names.get(i) + " : " + values.get(i));
            }
        }
    }
}
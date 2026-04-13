import java.io.StringReader;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.XMLParser;
import javax.xml.parsers.XMLStreamException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_27906_XMLParser_A08 {

    private static class MyHandler extends DefaultHandler {

        private List<String> names = new ArrayList<>();
        private List<String> values = new ArrayList<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            names.add(localName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("name")) {
                throw new InvalidParameterException("Encountered a name element");
            }
            values.add("");
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String value = new String(ch, start, length);
            if (!value.trim().isEmpty()) {
                values.add(value);
            }
        }
    }

    public static void main(String[] args) {
        String xml = "<root>" +
                "<item>Value1</item>" +
                "<item name='name2'>Value2</item>" +
                "<item>Value3</item>" +
                "</root>";
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null);
            MyHandler handler = new MyHandler();
            parser.parse(new StringReader(xml), handler);
            for (int i = 0; i < handler.names.size(); i++) {
                System.out.println(handler.names.get(i) + ": " + handler.values.get(i));
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
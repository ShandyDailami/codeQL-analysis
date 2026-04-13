import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

public class java_24070_XMLParser_A03 extends DefaultHandler {
    private List<String> names = new ArrayList<>();
    private List<String> values = new ArrayList<>();

    public static void main(String[] args) {
        try {
            LegacyXMLParser parser = new LegacyXMLParser();
            SAXHelper helper = new SAXHelper();
            helper.setDefaultHandler(parser);
            helper.parse(new FileInputStream("sample.xml"), true);
            for (int i = 0; i < parser.names.size(); i++) {
                System.out.println("name: " + parser.names.get(i) + ", value: " + parser.values.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        names.add(localName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();
        if (!value.isEmpty()) {
            values.add(value);
        }
    }
}
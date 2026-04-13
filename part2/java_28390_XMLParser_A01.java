import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

import java.util.ArrayList;
import java.util.List;

public class java_28390_XMLParser_A01 extends DefaultHandler {
    private List<String> names = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("name")) {
            names.add("");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length);
        if (names.size() > 0) {
            names.set(names.size() - 1, names.get(names.size() - 1) + s);
        }
    }

    public List<String> getNames() {
        return names;
    }
}

public class MyXMLParser {
    public static void main(String[] args) {
        SAXHelper helper = new SAXHelper();
        MySAXHandler handler = new MySAXHandler();
        helper.setContentHandler(handler);
        try {
            helper.parse("src/test.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> names = handler.getNames();
        for (String name : names) {
            System.out.println("Name: " + name);
        }
    }
}
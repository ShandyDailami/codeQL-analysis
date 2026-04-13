import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_03343_XMLParser_A08 extends DefaultHandler {
    private List<String> names = new ArrayList<>();
    private List<String> values = new ArrayList<>();

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

    public List<String> getNames() {
        return names;
    }

    public List<String> getValues() {
        return values;
    }
}

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyXMLHandler());
            parser.parse(new File("input.xml"), MyXMLHandler.class);

            List<String> names = new MyXMLHandler().getNames();
            List<String> values = new MyXMLHandler().getValues();

            for (int i = 0; i < names.size(); i++) {
                System.out.println(names.get(i) + ": " + values.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
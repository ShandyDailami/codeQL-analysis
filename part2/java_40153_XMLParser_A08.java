import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class java_40153_XMLParser_A08 extends DefaultHandler {

    private List<String> names = new ArrayList<>();
    private List<String> values = new ArrayList<>();

    public List<String> getNames() {
        return names;
    }

    public List<String> getValues() {
        return values;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        names.add(localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Do nothing, we're only interested in the start of the tags
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        values.add(value);
    }

    public static void main(String[] args) {
        SAXHelper helper = new SAXHelper();
        MyXMLParser handler = new MyXMLParser();
        try {
            helper.setContentHandler(handler);
            helper.parse(new File("input.xml"));
            List<String> names = handler.getNames();
            List<String> values = handler.getValues();
            // Do something with the names and values, e.g. print them
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
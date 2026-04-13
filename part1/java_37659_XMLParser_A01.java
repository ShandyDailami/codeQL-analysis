import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_37659_XMLParser_A01 extends DefaultHandler {
    private List<String> tags;
    private List<String> values;
    private StringBuilder currentValue;
    private boolean isName;
    private boolean isValue;

    public java_37659_XMLParser_A01() {
        this.tags = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    public void parse(String xml) {
        org.xml.sax.SAXParserFactory saxParserFactory = org.xml.sax.SAXParserFactory.newInstance();

        try {
            org.xml.sax.SAXParser saxParser = saxParserFactory.newSAXParser(null);
            SAXParserExample handler = new SAXParserExample();
            saxParser.parse(xml, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Print result
        for (int i = 0; i < tags.size(); i++) {
            System.out.println(tags.get(i) + ": " + values.get(i));
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentValue = new StringBuilder();
        tags.add(qName);
        isName = true;
        isValue = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isName) {
            // Add logic here to verify if it's a security sensitive operation
            // If it's a sensitive operation, print a warning message
            currentValue.append(new String(ch, start, length));
        } else if (isValue) {
            currentValue.append(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        values.add(currentValue.toString());
        isName = false;
        isValue = true;
    }
}
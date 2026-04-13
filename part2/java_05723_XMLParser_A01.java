import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_05723_XMLParser_A01 extends DefaultHandler {
    private List<String> names = new ArrayList<>();
    private List<String> values = new ArrayList<>();
    private StringBuilder currentValue;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentValue = new StringBuilder();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("element".equals(qName)) {
            names.add(currentValue.toString());
        } else if ("value".equals(qName)) {
            values.add(currentValue.toString());
        }
    }

    public void parse(String xml) throws SAXException {
        org.xml.sax.XMLReader reader = org.xml.sax.SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        reader.setContentHandler(this);
        reader.parse(new StringReader(xml));
    }

    public static void main(String[] args) throws Exception {
        String xml = "<root><element>value1</element><element>value2</element></root>";

        MyXMLParser parser = new MyXMLParser();
        parser.parse(xml);

        for (int i = 0; i < parser.names.size(); i++) {
            System.out.println("Element: " + parser.names.get(i) + ", Value: " + parser.values.get(i));
        }
    }
}
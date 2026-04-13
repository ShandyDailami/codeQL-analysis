import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_13728_XMLParser_A08 extends DefaultHandler {
    private List<String> names = new ArrayList<>();
    private List<String> ages = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            names.add(attributes.getValue("name"));
            ages.add(attributes.getValue("age"));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            String name = names.get(names.size() - 1);
            String age = ages.get(ages.size() - 1);
            System.out.println("Name: " + name + ", Age: " + age);
            names.clear();
            ages.clear();
        }
    }
}

public class XmlParser {
    public static void main(String[] args) {
        String xml = "<people>\n" +
                "  <person name=\"John\" age=\"30\" />\n" +
                "  <person name=\"Jane\" age=\"25\" />\n" +
                "  <person name=\"Bob\" age=\"45\" />\n" +
                "</people>";
        javax.xml.parsers.SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyXMLHandler());
            parser.parse(new InputSource(new StringReader(xml)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
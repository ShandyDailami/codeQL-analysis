import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;

public class java_33498_XMLParser_A03 extends DefaultHandler {
    List<String> names = new ArrayList<>();
    List<String> values = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        names.add(localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        names.add(localName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        values.add(value);
    }

    public void parse(String file) {
        XMLReader reader = XMLReader.newInstance();
        reader.setContentHandler(this);
        try {
            reader.parse(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        printData();
    }

    private void printData() {
        for (int i = 0; i < names.size(); i++) {
            System.out.println("name: " + names.get(i) + ", value: " + values.get(i));
        }
    }

    public static void main(String[] args) {
        String file = "sample.xml";
        XMLParser parser = new XMLParser();
        parser.parse(file);
    }
}
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_20195_XMLParser_A03 extends DefaultHandler {
    private List<String> names;
    private String currentElement;

    public java_20195_XMLParser_A03() {
        names = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(currentElement.equals("name")) {
            names.add(localName);
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(currentElement.equals("name")) {
            names.add(new String(ch, start, length));
        }
    }

    public List<String> getNames() {
        return names;
    }
}

public class Main {
    public static void main(String[] args) {
        MySAXHandler handler = new MySAXHandler();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, handler);

        // Replace 'input.xml' with your input file
        parser.parse("input.xml", handler);

        List<String> names = handler.getNames();

        // Print names
        for(String name : names) {
            System.out.println(name);
        }
    }
}
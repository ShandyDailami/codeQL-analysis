import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_40805_XMLParser_A08 extends DefaultHandler {

    private List<String> values = new ArrayList<>();
    private StringBuffer tempValue;
    private String element;
    private String namespace;

    @Override
    public void startDocument() {
        System.out.println("Starting SAX parsing!");
    }

    @Override
    public void endDocument() {
        System.out.println("Ending SAX parsing!");
    }

    @Override
    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) {
        element = qualifiedName;
        namespace = uri;
        tempValue = new StringBuffer();
    }

    @Override
    public void endElement(String uri, String localName, String qualifiedName) {
        if (element.equals("item")) {
            values.add(tempValue.toString());
            System.out.println("Found an 'item' with value: " + tempValue);
        }
        element = null;
        tempValue = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        tempValue.append(ch, start, length);
    }

    public List<String> getValues() {
        return values;
    }

    public static void main(String[] args) throws Exception {

        MyXMLHandler handler = new MyXMLHandler();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, handler);

        parser.parse(Class.forName("org.xml.sax.InputSource").getField("SAX_SOURCE", true).get(null), false);

        List<String> values = handler.getValues();
        for (String value : values) {
            System.out.println(value);
        }
    }
}
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_21802_XMLParser_A03 extends DefaultHandler {

    private List<String> names;
    private String thisElement;
    private String lastElement;
    private boolean bName;
    private boolean bLocation;

    public java_21802_XMLParser_A03() {
        names = new ArrayList<>();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
        if (thisElement.equalsIgnoreCase("name")) {
            bName = true;
        } else if (thisElement.equalsIgnoreCase("location")) {
            bLocation = true;
        } else {
            bName = bLocation = false;
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            String value = new String(ch, start, length).trim();
            if (value.length() > 0) {
                names.add(value);
                System.out.println("Name: " + value);
            }
        }
        bName = bLocation = false;
    }

    public static void main(String[] args) {
        String xmlString = "<people>\n" +
                "  <person>\n" +
                "    <name>John</name>\n" +
                "    <location>New York</location>\n" +
                "  </person>\n" +
                "  <person>\n" +
                "    <name>Bob</name>\n" +
                "    <location>Chicago</location>\n" +
                "  </person>\n" +
                "</people>";

        MyXMLHandler handler = new MyXMLHandler();
        org.xml.sax.helpers.SAXParserFactory spf = org.xml.sax.helpers.SAXParserFactory.newInstance();
        try {
            spf.newSAXParser().parse(new StringReader(xmlString), handler);
            List<String> names = handler.getNames();
            for (String name : names) {
                System.out.println("Found name: " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getNames() {
        return names;
    }
}
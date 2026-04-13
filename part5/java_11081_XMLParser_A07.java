import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.List;

public class java_11081_XMLParser_A07 extends DefaultHandler {

    private List<String> elements;
    private StringBuilder elementContent;
    private boolean authFailure;

    public java_11081_XMLParser_A07(List<String> elements) {
        this.elements = elements;
        this.elementContent = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementContent.setLength(0);
        for (String element : elements) {
            if (element.equalsIgnoreCase(qName)) {
                authFailure = true;
                break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (authFailure) {
            System.out.println("Security alert: Authentication failure detected in XML data!");
            authFailure = false; // reset flag
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementContent.append(ch, start, length);
    }
}

public class XmlParser {

    public static void main(String[] args) throws Exception {
        String xml = "<doc><element1>Content1</element1><element2>Content2</element2></doc>";
        parseXml(xml, Arrays.asList("element1", "element2"));
    }

    public static void parseXml(String xml, List<String> elements) throws Exception {
        org.xml.sax.SAXParserFactory spf = org.xml.sax.SAXParserFactory.newInstance();
        org.xml.sax.SAXParser sp = spf.newSAXParser(null);
        SecurityHandler sh = new SecurityHandler(elements);
        sp.parse(new StringReader(xml), sh);
    }
}
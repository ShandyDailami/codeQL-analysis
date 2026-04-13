import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_40643_XMLParser_A03 extends DefaultHandler {
    private List<String> injectionList = new ArrayList<>();

    public List<String> getInjectionList() {
        return injectionList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("tag")) {
            String injection = attributes.getValue("id");
            if (injection != null) {
                injectionList.add(injection);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // do nothing
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // do nothing
    }
}

public class XMLParser {
    public static void main(String[] args) throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<document>\n" +
                "    <tag id=\"1\">Text 1</tag>\n" +
                "    <tag id=\"2\">Text 2</tag>\n" +
                "    <bad-tag id=\"3\">Bad Tag</bad-tag>\n" +
                "</document>";

        SecurityHandler handler = new SecurityHandler();
        org.xml.sax.SAXParserFactory saxFactory = org.xml.sax.SAXParserFactory.newInstance();
        org.xml.sax.SAXParser saxParser = saxFactory.newSAXParser(false);
        saxParser.parse(new InputSource(new StringReader(xml)), handler);

        List<String> injectionList = handler.getInjectionList();
        System.out.println("Found injection: " + injectionList);
    }
}
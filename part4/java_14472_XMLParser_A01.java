import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_14472_XMLParser_A01 extends DefaultHandler {
    private String lastTag = "";
    private List<String> results = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastTag = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(lastTag)) {
            results.add("<" + lastTag + ">");
        } else {
            results.add("</" + lastTag + ">");
            lastTag = "";
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastTag != null && lastTag.length() > 0) {
            results.add(new String(ch, start, length));
        }
    }

    public List<String> getResults() {
        return results;
    }
}

public class Main {
    public static void main(String[] args) {
        MyHandler handler = new MyHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(Main.class.getResourceAsStream("/sample.xml"), handler);
            for (String result : handler.getResults()) {
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
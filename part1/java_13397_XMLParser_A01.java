import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_13397_XMLParser_A01 extends DefaultHandler {
    private List<String> urls = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("url")) {
            String url = attributes.getValue("address");
            if (!url.matches("https?://.*")) {
                System.out.println("Security violation: Broken Access Control at " + url);
            } else {
                urls.add(url);
            }
        }
    }

    public static void main(String[] args) {
        SecurityHandler handler = new SecurityHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(Class.forName("Security").getClassLoader().getResourceAsStream("Security.xml"), handler);
            handler.printViolations();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printViolations() {
        for (String url : urls) {
            System.out.println("Broken Access Control at " + url);
        }
    }
}
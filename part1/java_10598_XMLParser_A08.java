import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class java_10598_XMLParser_A08 extends DefaultHandler {
    private boolean bElement = false;
    private boolean bValue = false;
    private String currentValue = null;
    private Map<String, String> map = new HashMap<>();

    public void startElement(String uri, String localName, String qName,
                             Map<String, String> attributes) {
        if (qName.equalsIgnoreCase("element")) {
            bElement = true;
        } else if (bElement) {
            bElement = false;
            bValue = true;
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("element")) {
            bElement = false;
        } else if (bElement && bValue) {
            bValue = false;
            map.put(localName, currentValue);
        }
    }

    public void characters(char[] ch, int start, int length) {
        if (bValue) {
            currentValue = new String(ch, start, length);
        }
    }

    public static void parseXML(String xmlString) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            MyXMLHandler handler = new MyXMLHandler();
            parser.parse(new StringReader(xmlString), handler);
            for (Map.Entry<String, String> entry : handler.map.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String xml = "<root><element1>value1</element1><element2>value2</element2></root>";
        parseXML(xml);
    }
}
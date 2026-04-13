import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XPDParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XSLTProcessor;
import org.xml.sax.parser.Xerces2SAXParser;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class java_09273_XMLParser_A03 extends DefaultHandler {
    private Map<String, String> data = new HashMap<>();
    private String currElement = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length);
        data.put(currElement, str);
    }

    public Map<String, String> getData() {
        return data;
    }
}

public class Main {
    public static void main(String[] args) throws IOException, SAXException {
        XMLParser parser = new Xerces2SAXParser();
        MyXMLHandler handler = new MyXMLHandler();
        parser.setContentHandler(handler);
        parser.parse(new File("input.xml"));

        Map<String, String> data = handler.getData();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
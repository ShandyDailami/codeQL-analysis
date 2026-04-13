import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class java_31581_XMLParser_A01 {
    public static void main(String[] args) {
        parseXML("data.xml");
    }

    public static void parseXML(String filename) {
        SAXHandler handler = new SAXHandler();
        try (InputStream input = new FileInputStream(filename)) {
            org.xml.sax.SAXParserFactory factory = org.xml.sax.SAXParserFactory.newInstance();
            org.xml.sax.SAXParser parser = factory.newSAXParser(input);
            parser.setContentHandler(handler);
            parser.parse(input, handler);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
        List<String> nodes = handler.getNodes();
        for (String node : nodes) {
            System.out.println(node);
        }
    }

    static class SAXHandler extends DefaultHandler {
        private List<String> nodes = new ArrayList<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            nodes.add(qName);
        }
    }
}
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XSLTProcessor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class java_33234_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml";
        parse(xmlFile);
    }

    private static void parse(String xmlFile) {
        SAXParser parser = SAXParserFactory.newInstance().createParser(
                new File(xmlFile),
                new MyHandler()
        );
        try {
            parser.parse(new XMLReader(parser));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private List<String> nodes = new ArrayList<>();
        private String currentElement = "";

        @Override
        public void startDocument() {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            currentElement = qName;
            nodes.add("Start of " + qName);
            System.out.println("Start of " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            currentElement = "";
            nodes.add("End of " + qName);
            System.out.println("End of " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (currentElement != null && currentElement.length() > 0) {
                String nodeContent = new String(ch, start, length);
                nodes.add("Character content: " + nodeContent);
                System.out.println("Character content: " + nodeContent);
            }
        }

        public List<String> getNodes() {
            return nodes;
        }
    }
}
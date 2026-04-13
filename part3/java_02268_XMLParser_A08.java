import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class java_02268_XMLParser_A08 extends DefaultHandler {
    private List<String> namespaces = new ArrayList<>();
    private List<String> elements = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        namespaces.add(uri);
        elements.add(localName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Ignore characters
    }

    public static void main(String[] args) throws Exception {
        String xml = "<root><element1>Content1</element1><element2>Content2</element2></root>";

        LegacyXmlParser parser = new LegacyXmlParser();
        XMLParser xp = XMLParser.newInstance();
        xp.setContentHandler(parser);
        xp.parse(new StringReader(xml));

        System.out.println("Namespaces: " + parser.namespaces);
        System.out.println("Elements: " + parser.elements);
    }
}
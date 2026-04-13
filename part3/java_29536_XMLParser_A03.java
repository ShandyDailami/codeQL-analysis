import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLErrorHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class java_29536_XMLParser_A03 extends DefaultHandler {

    private List<String> names = new ArrayList<>();
    private List<String> values = new ArrayList<>();

    public List<String> getNames() {
        return names;
    }

    public List<String> getValues() {
        return values;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        names.add(localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Do nothing
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        values.add(new String(ch, start, length));
    }

    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/example.xml");
        XMLParser parser = XMLParser.newInstance();
        parser.setErrorHandler(new XMLErrorHandler() {
            @Override
            public void warning(SAXParseException e) {
                // Ignore warnings
            }

            @Override
            public void error(SAXParseException e) {
                System.err.println("Parsing error: " + e.getMessage());
                System.exit(-1);
            }

            @Override
            public void fatalError(SAXParseException e) {
                System.err.println("Fatal parsing error: " + e.getMessage());
                System.exit(-1);
            }
        });
        try {
            XmlParser handler = new XmlParser();
            parser.setContentHandler(handler);
            parser.parse(xmlFile);

            List<String> names = handler.getNames();
            List<String> values = handler.getValues();

            for (int i = 0; i < names.size(); i++) {
                System.out.println(names.get(i) + " = " + values.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
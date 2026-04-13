import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMlSAXParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMlEntityResolver;
import org.xml.sax.ext.LexicalHandler;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class java_37010_XMLParser_A08 {

    private Map<String, String> tagMap = new HashMap<>();

    public void parse(String filename) {
        try {
            XMLParser parser = new XMlSAXParser();
            parser.setEntityResolver(new XMlEntityResolver() {
                @Override
                public InputSource resolveEntity(String namespace, String name) throws SAXException {
                    // Disallow all entities
                    return new InputSource(new StringReader(""));
                }
            });
            parser.setLexicalHandler(new LexicalHandler() {
                @Override
                public void startDocument() throws SAXException {
                    System.out.println("Parsing document");
                }

                @Override
                public void endDocument() throws SAXException {
                    System.out.println("End of document");
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    tagMap.put(qName, attributes.getValue("id"));
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End of " + qName);
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    String value = new String(ch, start, length);
                    System.out.println("Character data: " + value);
                }

                @Override
                public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
                    System.out.println("Ignorable whitespace: " + new String(ch, start, length));
                }

                @Override
                public void startPrefixMapping(String prefix, String uri) throws SAXException {
                    System.out.println("Start of prefix mapping: " + prefix + ", " + uri);
                }

                @Override
                public void endPrefixMapping(String prefix) throws SAXException {
                    System.out.println("End of prefix mapping: " + prefix);
                }
            });
            parser.parse(new File(filename));

            printTagMap();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printTagMap() {
        for (Map.Entry<String, String> entry : tagMap.entrySet()) {
            System.out.println("Tag: " + entry.getKey() + ", ID: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        new SecureXMLParser().parse("src/main/resources/sample.xml");
    }
}
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLSerializer;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_24038_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser;
        try {
            saxParser = factory.newSAXParser(new File("sample.xml"));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        XMLHandler handler = new XMLHandler();
        try {
            saxParser.parse(new File("sample.xml"), handler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class XMLHandler extends DefaultHandler {
        private boolean isElement = false;
        private String currentElement = "";
        private String currentAttribute = "";

        @Override
        public void startElement(String namespaceURI, String localName, String qualifiedName,
                                 Map attributes) {
            isElement = true;
            currentElement = qualifiedName;
            // Display the start element and its attributes
            System.out.println("Start Element: " + qualifiedName);
            if (attributes != null) {
                for (Map.Entry<String, String> entry : attributes.entrySet()) {
                    System.out.println("Attribute: " + entry.getKey() + "=" + entry.getValue());
                }
            }
        }

        @Override
        public void endElement(String namespaceURI, String localName, String qualifiedName) {
            isElement = false;
            currentElement = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (isElement) {
                System.out.print("Character Data: " + new String(ch, start, length));
            }
        }
    }
}
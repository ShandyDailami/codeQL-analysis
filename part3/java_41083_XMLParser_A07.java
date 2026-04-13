import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.xmlreader.XMLReader;
import org.xml.sax.xmlreader.XMLRepository;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.List;

public class java_41083_XMLParser_A07 {

    private static class MyHandler extends DefaultHandler {
        private List<String> elements;

        public java_41083_XMLParser_A07(List<String> elements) {
            this.elements = elements;
        }

        @Override
        public void startElement(String namespaceURI, String localName, String qualifiedName,
                                 org.xml.sax.Attributes atts) throws SAXException {
            if (localName.equals("element")) {
                for (int i = 0; i < atts.getLength(); i++) {
                    elements.add(atts.getQualifiedName(i));
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> elements = List.of("element1", "element2", "element3");
        MyHandler handler = new MyHandler(elements);

        Security.addProvider(new org.xml.sax.SAXProvider());

        try (XMLReader reader = XMLRepository.getXMLReader()) {
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/namespaces", false);
            reader.setContentHandler(handler);

            SAXParser parser = reader.getParser();
            parser.setValidation(true);
            parser.setNamespaceAware(true);
            parser.setXIncludeSchemaResolver(null);
            parser.setEntityResolver(null);
            parser.setDenialHandler(null);

            try (File file = new File("test.xml")) {
                parser.parse(file);
                for (String element : elements) {
                    System.out.println(element);
                }
            }
        } catch (IOException | SAXException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
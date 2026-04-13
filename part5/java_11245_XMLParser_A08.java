import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_11245_XMLParser_A08 {

    public static class MyHandler extends DefaultHandler {

        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            System.out.println("Start Element: " + localName);

            // Print attributes
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("Attribute: " + attributes.getQualifiedName(i) + "=" + attributes.getValue(i));
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element: " + localName);
        }

    }

    public static void main(String[] args) {
        try {
            EntityResolver entityResolver = new CustomEntityResolver();
            SAXParserFactory factory = new SAXParserFactory();

            factory.setValidating(true);
            factory.setNamespaceAware(true);
            factory.setXIncludeSchemaResolver(new CustomXIncludeSchemaResolver());
            factory.setEntityResolver(entityResolver);

            SAXParser saxParser = factory.newSAXParser(new XMLReaderFactory());
            MyHandler handler = new MyHandler();

            XMLReader xmlReader = saxParser.getXMLReader(handler);

            xmlReader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            xmlReader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);

            xmlReader.parse(new File("src/main/resources/test.xml"));

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
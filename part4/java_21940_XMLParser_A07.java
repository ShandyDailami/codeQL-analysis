import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_21940_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyHandler());

            parser.parse(new File("input.xml"), MyHandler.getContext());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private static final String SAX_NAMESPACE_PREFIX = "http://xmlns.oracle.com/xslt/";

        private static String ns = SAX_NAMESPACE_PREFIX + "parse-masking";

        public static String getNamespace(String prefix) {
            return ns + (prefix.isEmpty() ? "" : ('.' + prefix));
        }

        @Override
        public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + localName);

            // Your logic to process the data here
            // For example, you can print the attributes
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("Attribute: " + attributes.getQualifiedPrefix(i) + "=" + attributes.getValue(i));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
            System.out.println("End element: " + localName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            System.out.println("Start Prefix mapping: " + prefix + "=" + uri);
        }

        @Override
        public void endPrefixMapping(String prefix, String uri) throws SAXException {
            System.out.println("End Prefix mapping: " + prefix + "=" + uri);
        }
    }
}
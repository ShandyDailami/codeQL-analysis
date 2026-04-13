import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_17789_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader reader = XMLReaderFactory.createXMLReader(factory);
            reader.setContentHandler(new MyContentHandler());
            reader.parse(new File("example.xml"));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class MyContentHandler extends DefaultHandler {

        private StringBuilder sb;
        private String namespaceURI;

        @Override
        public void startDocument() throws SAXException {
            sb = new StringBuilder();
        }

        @Override
        public void startElement(String namespaceURI, String localName, String qualifiedName, String[] attributes) throws SAXException {
            super.startElement(namespaceURI, localName, qualifiedName, attributes);
            sb.append("<");
            sb.append(localName);
            if (attributes != null) {
                sb.append(" ");
                for (int i = 0; i < attributes.length; i++) {
                    sb.append(attributes[i]);
                    if (i < attributes.length - 1) {
                        sb.append(", ");
                    }
                }
            }
            sb.append(">");
        }

        @Override
        public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
            super.endElement(namespaceURI, localName, qualifiedName);
            sb.append("</");
            sb.append(localName);
            sb.append(">");
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            super.characters(ch, start, length);
            sb.append(new String(ch, start, length));
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println(sb.toString());
        }

    }

}
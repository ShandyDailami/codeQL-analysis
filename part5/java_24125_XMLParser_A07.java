import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.ElementListener;
import org.xml.sax.XMLHandler;

public class java_24125_XMLParser_A07 {
    public static void main(String[] args) {
        XMLHandler handler = new DefaultHandler();
        ElementListener elementListener = new ElementListener();

        handler.setContentHandler(elementListener);

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse("example.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class ElementListener extends DefaultHandler {
        private boolean isInsideElement = false;
        private String currentElementName = "";

        @Override
        public void startElement(String uri, String localName, String qName,
                                org.xml.sax.Attributes attributes) throws SAXException {
            isInsideElement = true;
            currentElementName = qName;
            printElementInfo(uri, localName, qName, attributes);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            isInsideElement = false;
            printElementInfo(uri, localName, qName, null);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isInsideElement) {
                printElementContent(new String(ch, start, length));
            }
        }

        private void printElementInfo(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
            System.out.println("Element: " + qName);
            if (attributes != null) {
                System.out.println("Attributes:");
                for (int i = 0; i < attributes.getLength(); i++) {
                    System.out.println("Attribute Name: " + attributes.getQName(i) + ", Attribute Value: " + attributes.getValue(i));
                }
            }
        }

        private void printElementContent(String content) {
            System.out.println("Content: " + content);
        }
    }
}